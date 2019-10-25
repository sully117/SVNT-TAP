from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login
from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from django.urls import reverse

from YoutubePro.forms import LoginForm, RegistrationForm
from YoutubePro.models import Youtuber


def login_action(request):
    context = {}
    if request.method == 'GET':
        context['form'] = LoginForm()
        return render(request, 'YoutubePro/login.html', context)

    form = LoginForm(request.POST)
    context['form'] = form

    if not form.is_valid():
        return render(request, 'YoutubePro/login.html', context)

    new_user = authenticate(username=form.cleaned_data['username'],
                            password=form.cleaned_data['password'])

    login(request, new_user)
    return redirect(reverse('login'))


def register(request):
    context = {}

    # Just display the registration form if this is a GET request.
    if request.method == 'GET':
        context['form'] = RegistrationForm()
        return render(request, 'YoutubePro/register.html', context)

    # Creates a bound form from the request POST parameters and makes the
    # form available in the request context dictionary.
    form = RegistrationForm(request.POST)

    context['form'] = form

    # Validates the form.
    if not form.is_valid():
        return render(request, 'YoutubePro/register.html', context)

    # At this point, the form data is valid.  Register and login the user.
    new_user = User.objects.create_user(username=form.cleaned_data['username'],
                                        password=form.cleaned_data['password1'],
                                        email=form.cleaned_data['Email'],
                                        first_name=form.cleaned_data['FirstName'],
                                        last_name=form.cleaned_data['LastName'])
    new_user.save()
    YoutuberInstance = Youtuber(user=new_user,
                                      bio="")  # type: Youtuber
    YoutuberInstance.save()

    new_user = authenticate(username=form.cleaned_data['username'],
                            password=form.cleaned_data['password1'])

    login(request, new_user)
    return redirect(reverse('dashboard'))


@login_required
def go_to_dashboard(request):
    errors = []  # A list to record messages for any errors we encounter.
    context = {}
    if request.method == "GET":
        return render(request, 'YoutubePro/dashboard.html', context)

