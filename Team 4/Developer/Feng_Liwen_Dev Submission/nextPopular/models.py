from django.db import models

# Create your models here.
class Prediction(models.Model):
    link = models.CharField(max_length=200)
    viewcnt = models.IntegerField()
