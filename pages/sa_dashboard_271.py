import streamlit as st
import pandas as pd
from utils.data_handler import load_data, save_uploaded_file

def check_password():
    """Returns `True` if the user had the correct password."""
    def password_entered():
        """Checks whether a password entered by the user is correct."""
        if st.session_state["password"] == st.secrets["admin_password"]:
            st.session_state["password_correct"] = True
            del st.session_state["password"]  # Don't store password
        else:
            st.session_state["password_correct"] = False

    if "password_correct" not in st.session_state:
        # First run, show input for password
        st.text_input(
            "Please enter the admin password", 
            type="password", 
            on_change=password_entered, 
            key="password"
        )
        return False
    elif not st.session_state["password_correct"]:
        # Password incorrect, show input + error
        st.text_input(
            "Please enter the admin password", 
            type="password", 
            on_change=password_entered, 
            key="password"
        )
        st.error("😕 Password incorrect")
        return False
    else:
        # Password correct
        return True

def show_admin_page():
    st.title("Admin Dashboard")
    st.markdown("### Data Management")

    uploaded_file = st.file_uploader(
        "Upload Excel File", 
        type=['xlsx'], 
        help="Upload your Excel file containing salary data"
    )

    if uploaded_file is not None:
        try:
            df = pd.read_excel(uploaded_file)
            st.write("Preview of uploaded data:")
            st.dataframe(df.head())
            
            if st.button("Confirm Upload"):
                if save_uploaded_file(df):
                    st.success("✅ File uploaded and data saved successfully!")
                else:
                    st.error("❌ Error saving the file")
        except Exception as e:
            st.error(f"Error processing file: {str(e)}")

def main():
    if check_password():
        show_admin_page()

if __name__ == "__main__":
    main()
