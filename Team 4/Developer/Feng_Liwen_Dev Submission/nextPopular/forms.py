from django import forms
from nextPopular.models import Prediction

class PredForm(forms.ModelForm):
    class Meta:
        model = Prediction
        fields = ('link', )

    # TODO: some validations of the form can be added here