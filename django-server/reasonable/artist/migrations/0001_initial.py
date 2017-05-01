# -*- coding: utf-8 -*-
# Generated by Django 1.10.5 on 2017-04-22 06:32
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Artist',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=250)),
                ('naverlink', models.CharField(max_length=250)),
                ('imagelink', models.CharField(max_length=250)),
            ],
            options={
                'ordering': ('name',),
            },
        ),
    ]
