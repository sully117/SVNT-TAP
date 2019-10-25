from django import forms
from nextPopular.models import Prediction

class PredForm(forms.ModelForm):
    class Meta:
        model = Prediction
        fields = ('link', )