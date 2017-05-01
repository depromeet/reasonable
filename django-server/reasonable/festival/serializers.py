from rest_framework import serializers
from .models import Festival, FestivalUnit

class FestivalUnitSerializer(serializers.ModelSerializer):
    class Meta:
        model = FestivalUnit
        fields = ['start_date', 'end_date', 'artist']
        # fields = '__all__'




class FestivalSerializer(serializers.ModelSerializer):
    festival_units = serializers.SerializerMethodField()

    def get_festival_units(self, obj):
        serializer = FestivalUnitSerializer(obj.festival_units.all(), many=True)
        result = serializer.data
        return result

    class Meta:
        model = Festival
        fields = '__all__'


class FestivalListSerializer(serializers.ModelSerializer):
    max_pages = serializers.SerializerMethodField()
    university_id = serializers.SerializerMethodField()
    university_name = serializers.SerializerMethodField()

    def get_max_pages(self, obj):
        return self.context['num_pages']

    def get_university_id(self, obj):
        return obj.university.id

    def get_university_name(self, obj):
        return obj.university.name

    class Meta:
        model = Festival
        # fields = ['id', 'name', 'num_pages', 'university', 'start_date', 'end_date']
        fields = '__all__'
