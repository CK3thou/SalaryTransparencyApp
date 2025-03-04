import pandas as pd
import os

def clean_salary_data(df):
    """Clean and format salary data"""
    try:
        print("Original columns:", df.columns.tolist())  # Debug print

        # Rename columns first
        column_mapping = {
            'Monthly Gross Salary ZMW': 'Monthly Gross Salary (in ZMW)',
            'Company location': 'Company location (Country)',
            'Salary Gross in USD (leave blank if you get paid in ZMW)': 'Salary Gross in USD'
        }

        for old_col, new_col in column_mapping.items():
            if old_col in df.columns:
                df = df.rename(columns={old_col: new_col})

        print("Columns after renaming:", df.columns.tolist())  # Debug print

        # Replace '#VALUE!' with NaN
        df['Monthly Gross Salary (in ZMW)'] = pd.to_numeric(df['Monthly Gross Salary (in ZMW)'], errors='coerce')

        # Clean up salary columns
        df['Salary Gross in USD'] = pd.to_numeric(df['Salary Gross in USD'], errors='coerce')

        # Clean up years of experience
        df['Years of Experience'] = df['Years of Experience'].astype(str)
        df['Years of Experience'] = df['Years of Experience'].str.extract('(\d+)', expand=False)
        df['Years of Experience'] = pd.to_numeric(df['Years of Experience'], errors='coerce')

        # Remove unnecessary columns
        columns_to_keep = [
            'Role', 'Company location (Country)', 'Monthly Gross Salary (in ZMW)',
            'Salary Gross in USD', 'Years of Experience', 'Degree',
            'Approx. No. of employees in company', 'Your Country/ Location',
            'Nationality', 'Industry'
        ]

        # Ensure all required columns exist
        for col in columns_to_keep:
            if col not in df.columns:
                df[col] = None

        df = df[columns_to_keep]

        # Drop rows where all values are NaN
        df = df.dropna(how='all')

        # Drop rows where salary is NaN
        df = df.dropna(subset=['Monthly Gross Salary (in ZMW)'])

        print("Final columns:", df.columns.tolist())  # Debug print
        print("Number of rows after cleaning:", len(df))  # Debug print

        return df
    except Exception as e:
        print(f"Error cleaning data: {str(e)}")
        return df

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
        # Fall back to CSV if Excel doesn't exist
        elif os.path.exists('data/salary_data.csv'):
            df = pd.read_csv('data/salary_data.csv')
        else:
            return empty_df

        # Clean and format the data
        df = clean_salary_data(df)
        return df
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
        # Clean data before saving
        df = clean_salary_data(df)
        # Save to both Excel and CSV for backup
        df.to_excel('data/salary_data.xlsx', index=False)
        df.to_csv('data/salary_data.csv', index=False)
        return True
    except Exception as e:
        print(f"Error saving uploaded file: {str(e)}")
        return False