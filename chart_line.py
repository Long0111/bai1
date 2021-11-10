import numpy as np
import pandas as pd
import streamlit as st
import matplotlib.pyplot as plt
import plotly.express as px
import plotly.graph_objects as go

# from data_visualization.Final.column_chart import Column

class Line:
    def __init__(self,df,country,time_start,time_end):
        self.df=df.copy()
        self.country=country
        self.time_start=time_start
        self.time_end=time_end
    # def Data_preprocessing(self):
    #     self.df=self.df.drop(columns=['Province/State','Lat','Long'])
    def chart_line(self):
        # self.df=self.df.drop(columns=['Province/State','Lat','Long'])
        time=[]
        Confirmed=[]
        Deaths=[]
        Recovered=[]
        flag=False
        for i in range(0,len(self.df)):
            if self.df['Country'][i].lower()==self.country.lower():
                if self.df['Date'][i]>self.time_start and self.df['Date'][i]<self.time_end:
                    time.append(self.df['Date'][i])
                    Confirmed.append(self.df['Confirmed'][i])
                    Deaths.append(self.df['Deaths'][i])
                    Recovered.append(self.df['Recovered'][i])
                    flag=True
        if flag==False: 
            st.text('Country not found or time not in data :(')
            return None
        else:
            fig, ax=plt.subplots()
            ax.plot(time,Confirmed,label='Confirmed')
            ax.plot(time,Deaths,label='Deaths')
            ax.plot(time,Recovered,label='Recovered')
            return fig
            # fig=go.Figure()
            # fig.add_trace(go.Scatter(x=time,y=Confirmed,mode='lines+markers',name='Confirmed',fillcolor='gray'))
            # fig.add_trace(go.Scatter(x=time,y=Deaths,mode='lines+markers',name='Deaths',fillcolor='gray'))
            # fig.add_trace(go.Scatter(x=time,y=Recovered,mode='lines+markers',name='Recovered',fillcolor='gray'))
            # return fig
            

