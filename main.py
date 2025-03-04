import streamlit as st
import pandas as pd
from utils.data_handler import load_data, save_submission
from utils.visualizations import create_salary_distribution, create_experience_salary_correlation
from components.forms import submission_form
from components.filters import country_filter

st.set_page_config(
    page_title="Salary Transparency Platform",
    page_icon="💰",
    layout="wide",
    initial_sidebar_state="collapsed"  # Better for mobile
)

def main():
    # Custom CSS for mobile responsiveness
    st.markdown("""
        <style>
            /* Mobile-first styles */
            .stDataFrame {
                width: 100%;
                overflow-x: auto;
            }
            .st-emotion-cache-1y4p8pa {  /* Streamlit's column class */
                min-width: 250px !important;
            }
            /* Improve padding on mobile */
            .main .block-container {
                padding-top: 1rem;
                padding-left: 1rem;
                padding-right: 1rem;
            }
            /* Make metrics more compact on mobile */
            [data-testid="metric-container"] {
                width: 100%;
                min-width: unset;
                padding: 0.5rem;
            }
            /* Adjust chart container for mobile */
            .plotly-chart-container {
                width: 100%;
                min-width: unset !important;
            }
        </style>
    """, unsafe_allow_html=True)

    st.title("Salary Transparency Platform")

    # Load data
    df = load_data()

    # Main content
    st.subheader("Salary Data Overview")

    if not df.empty:
        # Country selection - full width on mobile
        selected_country = country_filter(df)

        # Filter data by country
        if selected_country and selected_country != 'All Countries':
            country_data = df[df['Company location (Country)'] == selected_country]
        else:
            country_data = df

        if not country_data.empty:
            # Responsive metrics layout
            metrics = st.columns([1, 1, 1])
            with metrics[0]:
                st.metric("Total Entries", len(country_data))
            with metrics[1]:
                avg_salary = country_data['Monthly Gross Salary (in ZMW)'].mean()
                st.metric("Average Salary (ZMW)", f"{avg_salary:,.2f}")
            with metrics[2]:
                unique_roles = len(country_data['Role'].unique())
                st.metric("Unique Roles", unique_roles)

            # Charts with responsive container width
            chart_container = st.container()
            with chart_container:
                st.plotly_chart(
                    create_salary_distribution(country_data),
                    use_container_width=True,
                    config={'responsive': True}
                )
                st.plotly_chart(
                    create_experience_salary_correlation(country_data),
                    use_container_width=True,
                    config={'responsive': True}
                )

            # Data table with horizontal scroll on mobile
            st.subheader("Detailed Data")
            st.markdown('<div class="table-container">', unsafe_allow_html=True)
            st.dataframe(
                country_data[[
                    'Role', 'Monthly Gross Salary (in ZMW)', 
                    'Salary Gross in USD', 'Years of Experience',
                    'Industry', 'Company location (Country)'
                ]].sort_values('Monthly Gross Salary (in ZMW)', ascending=False),
                use_container_width=True,
                hide_index=True
            )
            st.markdown('</div>', unsafe_allow_html=True)
        else:
            st.info("No data available for this country yet. Be the first to contribute!")
    else:
        st.info("No salary data available yet. Be the first to contribute!")

    # Mobile-friendly submission form
    with st.expander("Submit Your Salary Data", expanded=False):
        submission_form(save_submission)

if __name__ == "__main__":
    main()