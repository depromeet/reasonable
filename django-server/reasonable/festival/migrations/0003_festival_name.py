# -*- coding: utf-8 -*-
# Generated by Django 1.10.5 on 2017-04-22 07:09
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('festival', '0002_auto_20170422_0634'),
    ]

    operations = [
        migrations.AddField(
            model_name='festival',
            name='name',
            field=models.CharField(default='2017축제', max_length=250),
        ),
    ]
