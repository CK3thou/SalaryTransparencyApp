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
        print(f"Error loading data: {str(e)}")
        return empty_df

def save_submission(data):
    """Save new submission to the current data file"""
    df = load_data()
    new_row = pd.DataFrame([data])

    try:
        # If Excel file exists, append to it
        if os.path.exists('data/salary_data.xlsx'):
            df = pd.concat([df, new_row], ignore_index=True)
            df.to_excel('data/salary_data.xlsx', index=False)
        else:
            # Otherwise, append to CSV
            if os.path.exists('data/salary_data.csv'):
                df = pd.concat([df, new_row], ignore_index=True)
            else:
                df = new_row
            df.to_csv('data/salary_data.csv', index=False)
        return True
    except Exception as e:
        print(f"Error saving submission: {str(e)}")
        return False

def save_uploaded_file(df):
    """Save uploaded Excel file data"""
    try:
        # Save to both Excel and CSV for backup
        df.to_excel('data/salary_data.xlsx', index=False)
        df.to_csv('data/salary_data.csv', index=False)
        return True
    except Exception as e:
        print(f"Error saving uploaded file: {str(e)}")
        return False