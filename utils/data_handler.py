import pandas as pd
import os

def load_data():
    """Load salary data from CSV file"""
    try:
        df = pd.read_csv('data/salary_data.csv')
        return df
    except FileNotFoundError:
        # Create empty DataFrame with required columns
        return pd.DataFrame(columns=[
            'Role', 'Company location (Country)', 'Monthly Gross Salary (in ZMW)',
            'Salary Gross in USD', 'Years of Experience', 'Degree',
            'Approx. No. of employees in company', 'Your Country/ Location',
            'Nationality', 'Industry'
        ])

def save_submission(data):
    """Save new submission to CSV file"""
    df = load_data()
    new_row = pd.DataFrame([data])
    
    if os.path.exists('data/salary_data.csv'):
        df = pd.concat([df, new_row], ignore_index=True)
    else:
        df = new_row
    
    df.to_csv('data/salary_data.csv', index=False)
    return True
