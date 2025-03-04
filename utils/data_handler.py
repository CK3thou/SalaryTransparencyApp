import pandas as pd
import os

def load_data():
    """Load salary data from Excel or CSV file"""
    # Define empty DataFrame with required columns
    empty_df = pd.DataFrame(columns=[
        'Role', 'Company location (Country)', 'Monthly Gross Salary (in ZMW)',
        'Salary Gross in USD', 'Years of Experience', 'Degree',
        'Approx. No. of employees in company', 'Your Country/ Location',
        'Nationality', 'Industry'
    ])

    try:
        # Try to load Excel file first
        if os.path.exists('data/salary_data.xlsx'):
            df = pd.read_excel('data/salary_data.xlsx')
            return df
        # Fall back to CSV if Excel doesn't exist
        elif os.path.exists('data/salary_data.csv'):
            df = pd.read_csv('data/salary_data.csv')
            return df
        else:
            return empty_df
    except Exception as e:
        st.error(f"Error loading data: {str(e)}")
        return empty_df

def save_submission(data):
    """Save new submission to both Excel and CSV files"""
    df = load_data()
    new_row = pd.DataFrame([data])

    if os.path.exists('data/salary_data.xlsx'):
        df = pd.concat([df, new_row], ignore_index=True)
        df.to_excel('data/salary_data.xlsx', index=False)
    else:
        # If Excel file doesn't exist, save to CSV
        if os.path.exists('data/salary_data.csv'):
            df = pd.concat([df, new_row], ignore_index=True)
        else:
            df = new_row
        df.to_csv('data/salary_data.csv', index=False)

    return True