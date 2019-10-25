from django.db import models
from django.contrib.auth.models import User

# This is the model for user
class Youtuber(models.Model):
    user = models.ForeignKey(User, default=None, on_delete=models.PROTECT)
    picture = models.FileField(blank=True)
    bio = models.CharField(max_length=140, default=None)