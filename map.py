import pandas as pd                                 #pip install pandas
import numpy as np
import plotly.express as px
import plotly.graph_objects as go
import streamlit as st
import matplotlib.pyplot as plt
import folium                                       #pip install folium
from streamlit_folium import folium_static          #pip install streamlit_folium

class Map:
    def __init__(self,df,date):
        # tao ban do 
        # input 
        #   df:  du lieu vao
        #   date: ngay tim kiem
        self.m = folium.Map(location=[0, 0], tiles='cartodbpositron', min_zoom = 1, max_zoom=10, zoom_start=2)
        self.df = df
        self.date = date
    def nhap(self):


        for i in range(0, len(self.df)):
                if self.df['Date'][i]==self.date:
                        
                        folium.Circle(location=[self.df.iloc[i]['Lat'], self.df.iloc[i]['Long']],color ='red', fill='crimson',
                                tooltip='<li><bold> Country: ' + str(self.df.iloc[i]['Country'])+
                                                '<li><bold> Province: ' + str(self.df.iloc[i]['Province/State'])+
                                                '<li><bold> Confirmed: ' + str(self.df.iloc[i]['Confirmed'])+
                                                '<li><bold> Deaths: ' + str(self.df.iloc[i]['Deaths']),
                                        radius = int(self.df.iloc[i]['Confirmed'])**0.6).add_to(self.m) 
                                        
                else:
                        continue
                
        
        return self.m