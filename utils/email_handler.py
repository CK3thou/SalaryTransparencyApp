import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import streamlit as st
import secrets
import time
from datetime import datetime, timedelta

def generate_reset_token():
    """Generate a secure reset token"""
    return secrets.token_urlsafe(32)

def send_reset_email(reset_token):
    """Send password reset email"""
    try:
        # Get email configuration from secrets
        smtp_server = st.secrets["SMTP_SERVER"]
        smtp_port = int(st.secrets["SMTP_PORT"])
        smtp_username = st.secrets["SMTP_USERNAME"]
        smtp_password = st.secrets["SMTP_PASSWORD"]
        admin_email = st.secrets["ADMIN_EMAIL"]

        # Create the email
        msg = MIMEMultipart()
        msg['From'] = smtp_username
        msg['To'] = admin_email
        msg['Subject'] = "Password Reset Request - Salary Transparency Platform"

        # Create the reset link
        reset_link = f"https://{st.experimental_get_query_params().get('REPL_SLUG', [''])[0]}.repl.co/admin?reset_token={reset_token}"

        body = f"""
        A password reset was requested for your Salary Transparency Platform admin account.

        Click the following link to reset your password:
        {reset_link}

        This link will expire in 30 minutes.

        If you didn't request this reset, please ignore this email.
        """

        msg.attach(MIMEText(body, 'plain'))

        # Create server connection
        server = smtplib.SMTP(smtp_server, smtp_port)
        server.starttls()
        server.login(smtp_username, smtp_password)
        
        # Send email
        server.send_message(msg)
        server.quit()
        return True

    except Exception as e:
        print(f"Error sending reset email: {str(e)}")
        return False

def verify_reset_token(token, valid_tokens):
    """Verify if a reset token is valid"""
    if token in valid_tokens:
        timestamp = valid_tokens[token]
        if datetime.now() - timestamp < timedelta(minutes=30):
            return True
    return False
