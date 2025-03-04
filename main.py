import streamlit as st
import pandas as pd
from utils.data_handler import load_data, save_submission
from utils.visualizations import create_salary_distribution, create_experience_salary_correlation
from components.forms import submission_form
from components.filters import country_filter

st.set_page_config(
    page_title="Salary Transparency Platform",
    page_icon="💰",
    layout="wide"
)

def main():
    st.title("Salary Transparency Platform")
    
    # Load data
    df = load_data()
    
    # Country selection
    selected_country = country_filter(df)
    
    # Main content
    col1, col2 = st.columns([2, 1])
    
    with col1:
        st.subheader(f"Salary Data for {selected_country}")
        
        # Filter data by country
        country_data = df[df['Company location (Country)'] == selected_country]
        
        if not country_data.empty:
            # Display visualizations
            st.plotly_chart(create_salary_distribution(country_data))
            st.plotly_chart(create_experience_salary_correlation(country_data))
            
            # Display data table
            st.dataframe(
                country_data[[
                    'Role', 'Monthly Gross Salary (in ZMW)', 
                    'Salary Gross in USD', 'Years of Experience',
                    'Industry'
                ]]
            )
        else:
            st.info("No data available for this country yet. Be the first to contribute!")
    
    with col2:
        # Google Ads placeholder
        st.markdown("""
        <div style='background-color: #f0f2f6; padding: 10px; margin-bottom: 20px; text-align: center;'>
            Google Ads Space
        </div>
        """, unsafe_allow_html=True)
        
        # Submission form
        st.subheader("Submit Your Salary Data")
        submission_form(save_submission)

if __name__ == "__main__":
    main()
