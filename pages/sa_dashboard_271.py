import streamlit as st
import pandas as pd
from utils.data_handler import load_data, save_uploaded_file
from utils.email_handler import generate_reset_token, send_reset_email, verify_reset_token
from datetime import datetime

def generate_reset_code():
    """Generate a temporary reset code"""
    import secrets
    return secrets.token_hex(4)  # 8 character hex code

def check_password():
    """Returns `True` if the user had the correct password."""

    # Initialize session state
    if 'password_correct' not in st.session_state:
        st.session_state.password_correct = False
    if 'reset_tokens' not in st.session_state:
        st.session_state.reset_tokens = {}

    if not st.session_state.password_correct:
        st.title("Admin Login")

        # Check for reset token in URL
        query_params = st.experimental_get_query_params()
        reset_token = query_params.get("reset_token", [None])[0]

        if reset_token and verify_reset_token(reset_token, st.session_state.reset_tokens):
            # Show new password form
            new_password = st.text_input("Enter new password:", type="password")
            if st.button("Set New Password"):
                try:
                    # Update the password
                    st.experimental_set_query_params(update_password="true", new_password=new_password)
                    # Remove the used token
                    del st.session_state.reset_tokens[reset_token]
                    st.success("Password updated successfully!")
                    st.rerun()
                except Exception as e:
                    st.error(f"Error updating password: {str(e)}")
        else:
            # Normal login form
            col1, col2 = st.columns(2)

            with col1:
                password = st.text_input(
                    "Please enter the admin password", 
                    type="password",
                    key="password_input"
                )

                if st.button("Login"):
                    try:
                        stored_password = st.secrets.admin_password
                        if password == stored_password:
                            st.session_state.password_correct = True
                            st.rerun()
                        else:
                            st.error("😕 Password incorrect")
                    except Exception as e:
                        st.error(f"Authentication error: {str(e)}")

            with col2:
                st.markdown("---")
                if st.button("Forgot Password?"):
                    # Generate and store reset token
                    reset_token = generate_reset_token()
                    st.session_state.reset_tokens[reset_token] = datetime.now()

                    if send_reset_email(reset_token):
                        st.success("Password reset link has been sent to your email.")
                    else:
                        st.error("Failed to send reset email. Please try again later.")

    return st.session_state.password_correct

def edit_data():
    df = load_data()
    st.write("### Edit Existing Entries")

    # Display editable dataframe
    edited_df = st.data_editor(
        df,
        num_rows="dynamic",
        use_container_width=True,
        hide_index=True,
        column_config={
            "Monthly Gross Salary (in ZMW)": st.column_config.NumberColumn(
                "Monthly Gross Salary (in ZMW)",
                min_value=0,
                format="%.2f"
            ),
            "Salary Gross in USD": st.column_config.NumberColumn(
                "Salary Gross in USD",
                min_value=0,
                format="%.2f"
            ),
            "Years of Experience": st.column_config.NumberColumn(
                "Years of Experience",
                min_value=0,
                step=1
            )
        }
    )

    if st.button("Save Changes"):
        try:
            save_uploaded_file(edited_df)
            st.success("✅ Changes saved successfully!")
        except Exception as e:
            st.error(f"❌ Error saving changes: {str(e)}")

def show_admin_page():
    st.title("Admin Dashboard")

    # Tabs for different admin functions
    tab1, tab2, tab3 = st.tabs(["Upload Data", "Edit Data", "Manual Entry"])

    with tab1:
        st.markdown("### Data Upload")
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

    with tab2:
        edit_data()

    with tab3:
        st.markdown("### Manual Data Entry")
        with st.form("manual_entry"):
            cols = st.columns(2)
            with cols[0]:
                role = st.text_input("Role*")
                company_location = st.text_input("Company Location (Country)*")
                salary_zmw = st.number_input("Monthly Gross Salary (in ZMW)*", min_value=0.0)
                salary_usd = st.number_input("Salary Gross in USD", min_value=0.0)
                experience = st.number_input("Years of Experience*", min_value=0)

            with cols[1]:
                degree = st.selectbox("Do you have a degree?*", options=["Yes", "No"])
                employees = st.number_input("Approx. No. of employees*", min_value=1)
                your_location = st.text_input("Your Country/Location*")
                nationality = st.text_input("Nationality*")
                industry = st.text_input("Industry*")

            if st.form_submit_button("Add Entry"):
                if not all([role, company_location, salary_zmw, experience, 
                           your_location, nationality, industry]):
                    st.error("Please fill in all required fields.")
                else:
                    new_data = {
                        'Role': role,
                        'Company location (Country)': company_location,
                        'Monthly Gross Salary (in ZMW)': salary_zmw,
                        'Salary Gross in USD': salary_usd if salary_usd > 0 else None,
                        'Years of Experience': experience,
                        'Degree': degree,
                        'Approx. No. of employees in company': employees,
                        'Your Country/ Location': your_location,
                        'Nationality': nationality,
                        'Industry': industry
                    }
                    df = load_data()
                    new_df = pd.concat([df, pd.DataFrame([new_data])], ignore_index=True)
                    if save_uploaded_file(new_df):
                        st.success("✅ Entry added successfully!")
                    else:
                        st.error("❌ Error adding entry")

def main():
    if check_password():
        show_admin_page()

if __name__ == "__main__":
    main()