from django import forms
from django.contrib.auth import authenticate
from django.contrib.auth.models import User


# This form is designed for login operation
class LoginForm(forms.Form):
    username = forms.CharField(max_length=20, widget=forms.TextInput(attrs={'id': 'id_username'}))
    password = forms.CharField(max_length=200, widget=forms.PasswordInput(attrs={'id': 'id_password'}))

    def clean(self):
        # Calls our parent (forms.Form) .clean function, gets a dictionary
        # of cleaned data as a result
        cleaned_data = super().clean()

        # Confirms that the two password fields match
        username = cleaned_data.get('username')
        password = cleaned_data.get('password')
        user = authenticate(username=username, password=password)
        if not user:
            raise forms.ValidationError("Invalid username/password")

        return cleaned_data



# This form is designed for register operation
class RegistrationForm(forms.Form):
    username = forms.CharField(max_length=20, widget=forms.TextInput(attrs={'id': 'id_username'}))
    password1 = forms.CharField(max_length=200,
                                label='Password',
                                widget=forms.PasswordInput(attrs={'id': 'id_password'}))
    password2 = forms.CharField(max_length=200,
                                label='Confirm',
                                widget=forms.PasswordInput(attrs={'id': 'id_confirm_password'}))
    Email = forms.CharField(max_length=30,
                            widget=forms.EmailInput(attrs={'id': 'id_email'}))
    FirstName = forms.CharField(max_length=20, widget=forms.TextInput(attrs={'id': 'id_first_name'}))
    LastName = forms.CharField(max_length=20, widget=forms.TextInput(attrs={'id': 'id_last_name'}))

    def clean(self):
        # Calls our parent (forms.Form) .clean function, gets a dictionary
        # of cleaned data as a result
        cleaned_data = super(RegistrationForm, self).clean()
        # Confirms that the two password fields match
        password1 = cleaned_data.get('password1')
        password2 = cleaned_data.get('password2')
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError("Passwords did not match.")

        # We must return the cleaned data we got from our parent.
        return cleaned_data

    # Customizes form validation for the username field.
    def clean_username(self):
        # Confirms that the username is not already present in the
        # User model database.
        username = self.cleaned_data.get('username')
        if User.objects.filter(username__exact=username):
            raise forms.ValidationError("Username is already taken.")

        # We must return the cleaned data we got from the cleaned_data
        # dictionary
        return username



