from django.shortcuts import render
from nextPopular.forms import PredForm
from nextPopular.models import Prediction
from django.views.decorators.csrf import ensure_csrf_cookie

# Create your views here.
def home(request):
    context = {}

    pred_form = PredForm(request.POST)
    context['pred_form'] = pred_form
    context['cnt'] = 0
    return render(request, 'home.html', context)

def get_pred(link):
    # TODO: integrate with data scientist
    return 100

@ensure_csrf_cookie
def add_pred(request):
    context = {}
    new_pred = Prediction()
    pred_form = PredForm(request.POST, instance = new_pred)

    new_pred.link = request.POST['link']
    # TODO: get directly from database
    new_pred.viewcnt = get_pred(new_pred.link)
    pred_form.save()
    context['pred_form'] = pred_form
    context['cnt'] = new_pred.viewcnt

    return render(request, 'home.html', context)
