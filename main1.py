import pandas as pd                                 #pip install pandas
import numpy as np
import plotly.express as px
import plotly.graph_objects as go
import streamlit as st
import matplotlib.pyplot as plt
import folium                                       #pip install folium
from streamlit_folium import folium_static   

from map import Map 

df=pd.read_csv(r'G:/code1/Covid-19-Preprocessed-Dataset/preprocessed/covid_19_data_cleaned.csv')
l='2021-01-22'
x = Map(df,l)

folium_static(x.nhap())