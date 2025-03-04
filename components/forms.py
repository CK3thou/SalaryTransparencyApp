import streamlit as st

def submission_form(save_callback):
    """Render and handle the salary submission form"""
    with st.form("salary_submission"):
        role = st.text_input("Role", required=True)
        company_location = st.text_input("Company Location (Country)", required=True)
        
        salary_zmw = st.number_input(
            "Monthly Gross Salary (in ZMW)",
            min_value=0.0,
            required=True
        )
        
        salary_usd = st.number_input(
            "Salary Gross in USD (optional)",
            min_value=0.0,
            required=False
        )
        
        experience = st.number_input(
            "Years of Experience",
            min_value=0,
            required=True
        )
        
        degree = st.selectbox(
            "Do you have a degree?",
            options=["Yes", "No"],
            required=True
        )
        
        employees = st.number_input(
            "Approx. No. of employees in company",
            min_value=1,
            required=True
        )
        
        your_location = st.text_input("Your Country/Location", required=True)
        nationality = st.text_input("Nationality", required=True)
        industry = st.text_input("Industry", required=True)
        
        submitted = st.form_submit_button("Submit")
        
        if submitted:
            data = {
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
            
            if save_callback(data):
                st.success("Thank you for your submission!")
                return True
            else:
                st.error("An error occurred while saving your submission.")
                return False
