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

    # Main content
    st.subheader("Salary Data Overview")

    if not df.empty:
        # Country selection
        selected_country = country_filter(df)

        # Filter data by country
        if selected_country and selected_country != 'All Countries':
            country_data = df[df['Company location (Country)'] == selected_country]
        else:
            country_data = df

        if not country_data.empty:
            # Display statistics
            col1, col2, col3 = st.columns(3)
            with col1:
                st.metric("Total Entries", len(country_data))
            with col2:
                avg_salary = country_data['Monthly Gross Salary (in ZMW)'].mean()
                st.metric("Average Salary (ZMW)", f"{avg_salary:,.2f}")
            with col3:
                unique_roles = len(country_data['Role'].unique())
                st.metric("Unique Roles", unique_roles)

            # Display visualizations
            st.plotly_chart(create_salary_distribution(country_data), use_container_width=True)
            st.plotly_chart(create_experience_salary_correlation(country_data), use_container_width=True)

            # Display data table
            st.subheader("Detailed Data")
            st.dataframe(
                country_data[[
                    'Role', 'Monthly Gross Salary (in ZMW)', 
                    'Salary Gross in USD', 'Years of Experience',
                    'Industry', 'Company location (Country)'
                ]].sort_values('Monthly Gross Salary (in ZMW)', ascending=False),
                use_container_width=True,
                hide_index=True
            )
        else:
            st.info("No data available for this country yet. Be the first to contribute!")
    else:
        st.info("No salary data available yet. Be the first to contribute!")

    # Submission form
    st.sidebar.markdown("---")
    st.sidebar.subheader("Submit Your Salary Data")
    submission_form(save_submission)

if __name__ == "__main__":
    main()