
import pandas as pd
import numpy as np
import plotly.express as px
import plotly.graph_objects as go
import streamlit as st
import matplotlib.pyplot as plt
import folium



class Column:
    def __init__(self,df,country):
        self.df = df
        self.country = country
    def inn(self):
        # self.df['Date']=pd.to_datetime(self.df['Date'])
        # self.df['Date']=self.df['Date'].dt.strftime("%y-%m-%d")
        self.df_country= self.df['Country'].unique().tolist()

        self.df_date = self.df['Date'].unique().tolist()
        date = st.selectbox('Which date would you like to see ?', self.df_date,100)
        country = st.multiselect('Which country would you like to see ?',self.df_country,self.country)

        self.df = self.df[self.df['Country'].isin(country)]
        self.df = self.df[self.df['Date']==date]

        fig2=px.bar(self.df,x='Country',y='Confirmed',color='Country')
        return fig2