# -*- coding: utf-8 -*-
# Generated by Django 1.10.5 on 2017-04-22 10:56
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('festival', '0005_auto_20170422_1701'),
    ]

    operations = [
        migrations.AlterField(
            model_name='festival',
            name='name',
            field=models.CharField(default='2017fest', max_length=250),
        ),
    ]
