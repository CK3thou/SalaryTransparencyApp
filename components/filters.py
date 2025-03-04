import streamlit as st

def country_filter(df):
    """Render country selection filter"""
    countries = sorted(df['Company location (Country)'].unique())
    
    # Add "All Countries" option
    if len(countries) > 0:
        countries = ['All Countries'] + list(countries)
    else:
        countries = ['All Countries']
    
    selected_country = st.selectbox(
        "Select a country to view salary data:",
        options=countries,
        index=0
    )
    
    if selected_country == 'All Countries':
        return None
    return selected_country
