from rest_framework import serializers
from .models import University


class UniversitySerializer(serializers.ModelSerializer):
    class Meta:
        model = University
        # fields = ['start_date', 'end_date', 'artist']
        fields = '__all__'
