import plotly.express as px
import plotly.graph_objects as go

def create_salary_distribution(df):
    """Create salary distribution chart"""
    fig = px.histogram(
        df,
        x='Monthly Gross Salary (in ZMW)',
        title='Salary Distribution',
        labels={'Monthly Gross Salary (in ZMW)': 'Salary (ZMW)'},
        opacity=0.7
    )
    fig.update_layout(
        showlegend=False,
        height=400,
        margin=dict(l=10, r=10, t=40, b=20),  # Tighter margins for mobile
        title_x=0.5,  # Center title
        xaxis_title_standoff=10,
        yaxis_title_standoff=10
    )
    return fig

def create_experience_salary_correlation(df):
    """Create experience vs salary scatter plot"""
    fig = px.scatter(
        df,
        x='Years of Experience',
        y='Monthly Gross Salary (in ZMW)',
        title='Experience vs Salary Correlation',
        labels={
            'Years of Experience': 'Experience (Years)',
            'Monthly Gross Salary (in ZMW)': 'Salary (ZMW)'
        }
    )
    fig.update_layout(
        height=400,
        margin=dict(l=10, r=10, t=40, b=20),  # Tighter margins for mobile
        title_x=0.5,  # Center title
        xaxis_title_standoff=10,
        yaxis_title_standoff=10
    )
    return fig