from Layout import Layout as ly
from mapword import Map
import streamlit as st
import pandas as pd
from streamlit_folium import folium_static
from column_chart import Column

st.title("Data visualization about covid-19")
ly.Title()


upload_file_maps=None,None,None,None

upload_file_maps=ly.upload_data()
st.header("Map of infection distribution")
global data_maps
if upload_file_maps is not None: 
    data_maps=pd.read_csv(upload_file_maps)
    

   # df=pd.read_csv(r'G:/code1/Covid-19-Preprocessed-Dataset/preprocessed/covid_19_data_cleaned.csv')

    country=['Brazil','Afghanistan','Vietnam']
    a=Column(data_maps,country)
    # a.inn()
    st.plotly_chart(a.inn(), use_container_width=True)

    
    date=ly.time()
    maps=Map(data_maps,str(date))
    m=maps.datamap()
    if st.button('Show maps'):
        if m==0: st.write('Date not in data')
        else:
            folium_static(m)
    else: st.caption('No date selected')