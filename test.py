from Layout import Layout as ly
from mapword import Map
import numpy as np
import streamlit as st
import pandas as pd
import plotly.express as px
from streamlit_folium import folium_static
from column_chart import Column as c
from chart_line import Line as l
from Statistics import Statistical_data_visualization as S
from pie_data import pieee_data
 # chart column
def char_column(data_maps):
    """Create column chart"""
    st.header("Overall chart for 1 country")
    cl=c(data_maps.copy())
    cl.choose_chart_column()
    col=st.radio('Type:',('Comfirmed', 'Deaths', 'Recovered'))
    cl.Data_preprocessing()
    # if st.button('Show',key="1"):
    if col == 'Comfirmed':
        #Confirmed
        # st.markdown('Confirmed')
        st.plotly_chart(cl.cl_chart('Confirmed'))
    elif col=='Deaths':
        #Deaths
        # st.markdown('Deaths')
        st.plotly_chart(cl.cl_chart('Deaths'))
    elif col=='Recovered':
        #Recovered
        # st.markdown('Recoverd')
        st.plotly_chart(cl.cl_chart('Recovered'))
    else: st.caption('No style selected')

    # st.plotly_chart(cl.column())
    # else: st.caption('None')


#Line Chart
def Line_chart(df):
    """Create Line chart"""
    
    country=st.text_input('Name country') 
    date_first,date_last=ly.run_time()
    # print('Date_firtst')
    # print(date_first)
    # print('Date_last')
    # print(date_last)
    df=df.drop(columns=['Province/State','Lat','Long'])
    # st.pyplot(Line.chart_line())
    if st.button('Performances'):
        if str(date_first)>str(date_last):
            st.text('Invalid date')
        else:
            Line=l(df,country,str(date_first),str(date_last))
            # Line.Data_preprocessing()
            d=Line.chart_line()
            if d is not None:
                st.plotly_chart(Line.chart_line())
    else: st.text("Please select the country and time period you want to show")
    



#map word
def map_word(data_maps):
    """Create map word"""
    st.header("Map of infection distribution")
    df=data_maps
    date=ly.time()  
    maps=Map(data_maps,str(date))
    m=maps.datamap()
    if st.button('Show maps'):
        if m==0: st.write('Date not in data')
        else:
            folium_static(m)
    else: st.caption('No date selected')


#Statistics
def statistics(dt):
    Sta=S(dt)
    c,d=Sta.Data_preprocessing()
    #country
    country_max_comfirmed  , number_country_max_comfirmed , country_min_comfirmed, number_country_min_comfirmed = Sta.By_country(c,inf='Confirmed')
    country_max_deaths , number_country_max_deaths, country_min_deaths  , number_country_min_deaths = Sta.By_country(c,inf='Deaths')
    country_max_recovered  , number_country_max_recovered, country_min_recovered , number_country_min_recovered = Sta.By_country(c,inf='Recovered')
    #date
    days_ave_confirmed, days_max_confirmed, days_min_confirmed, date_max_confirmed, date_min_confirmed=Sta.Date_handling(d,inf='Confirmed')
    days_ave_deaths, days_max_deaths, days_min_deaths, date_max_deaths, date_min_deaths=Sta.Date_handling(d,inf='Deaths')
    days_ave_recovered, days_max_recovered, days_min_recovered, date_max_recovered, date_min_recovered=Sta.Date_handling(d,inf='Recovered')
    total_country_confirmed=Sta.total_country(c)
    st.markdown(f'Number of countries with Covid-19 cases: {total_country_confirmed}/195')
    col1,col2,col3=st.columns(3)
    with col1:
        
       
        st.subheader('Confirmed by country: ')
        st.caption(f"Country max: {country_max_comfirmed}({number_country_max_comfirmed})")
        st.caption(f"Country min: {country_min_comfirmed}({number_country_min_comfirmed})")
        st.subheader('Confirmed by date: ')
        st.caption(f'Avegare in word: {days_ave_confirmed}')
        st.caption(f'Day max: {date_max_confirmed}({days_max_confirmed})')
        st.caption(f'Day min: {date_min_confirmed}({days_min_confirmed})')
        
    with col2:
        st.subheader('Deaths by country')
        st.caption(f"Country max: {country_max_deaths}({number_country_max_deaths})")
        st.caption(f"Country min: {country_min_deaths}({number_country_min_deaths})")
        st.subheader('Deaths by date: ')
        st.caption(f'Avegare in word: {days_ave_deaths}')
        st.caption(f'Day max: {date_max_deaths}({days_max_deaths})')
        st.caption(f'Day min: {date_min_deaths}({days_min_deaths})')
    
    with col3:
        st.subheader('Recovered by country')
        st.caption(f"Country max: {country_max_recovered}({number_country_max_recovered})")
        st.caption(f"Country min: {country_min_recovered}({number_country_min_recovered})")
        st.subheader('Recovered by date: ')
        st.caption(f'Avegare in word: {days_ave_recovered}')
        st.caption(f'Day max: {date_max_recovered}({days_max_recovered})')
        st.caption(f'Day min: {date_min_recovered}({days_min_recovered})')

def pie_chart(dl):
    # d_country= dl['Country'].unique().tolist()
    # country=st.multiselect('Choose country:',d_country)
    country=st.text_input('hello', 'bye')
    st.text(country)
    try :

        # confirmed_dl=dl.drop(columns=['Lat','Long','Province/State','Recovered','Deaths','Active'])
        # deaths_dl=dl.drop(columns=['Lat','Long','Province/State','Confirmed','Recovered','Active'])
        # recovered_dl=dl.drop(columns=['Lat','Long','Province/State','Confirmed','Deaths','Active'])
        # confirmed_dl=confirmed_dl.groupby(by='Country').aggregate(np.sum).T
        # confirmed_dl.index.name='Date'
        # confirmed_dl = confirmed_dl.reset_index()
        # deaths_dl=deaths_dl.groupby(by='Country').aggregate(np.sum).T
        # deaths_dl.index.name='Date'
        # deaths_dl = deaths_dl.reset_index()
        # recovered_dl=recovered_dl.groupby(by='Country').aggregate(np.sum).T
        # recovered_dl.index.name='Date'
        # recovered_dl = recovered_dl.reset_index()

        # confirmed_melt_dl=confirmed_dl.melt(id_vars='Date').copy()
        # confirmed_melt_dl.rename(columns={'value':'Confirmed'}, inplace=True)
        # deaths_melt_dl=deaths_dl.melt(id_vars='Date').copy()
        # deaths_melt_dl.rename(columns={'value':'Deaths'}, inplace=True)
        # recovered_melt_dl=recovered_dl.melt(id_vars='Date').copy()
        # recovered_melt_dl.rename(columns={'value':'Recovered'}, inplace=True)
        # # country='China'
        # A=confirmed_melt_dl.copy()
        # A['Deaths']=deaths_melt_dl['Deaths']
        # A['Recovered']=recovered_melt_dl['Recovered']
        # A['% Confirmed']=(((A['Confirmed']-A['Deaths']-A['Recovered'])/A['Confirmed'])*100).round(2)
        # A['% Deaths']=((A['Deaths']/A['Confirmed'])*100).round(2)
        # A['% Recovered']=((A['Recovered']/A['Confirmed'])*100).round(2)
        
        a = pieee_data(dl,country)
        A=a.xuli()
        # list_pie = [b['% Confirmed'],b['% Deaths'],b['% Recovered']]
        list_pie=[]
            # country = 'China' 
        # for i in range(len(A)):
        #     if A['Country'][i] == country:
        #         list_pie.append(float(A['% Confirmed'][i]) )
        #         list_pie.append(float(A['% Deaths'][i]))
        #         list_pie.append(float(A['% Recovered'][i]))

        for i in range(len(A)):
            if A['Country'][i] == country:
                list_pie.append(float(A['% Confirmed'][i]) )
                list_pie.append(float(A['% Deaths'][i]))
                list_pie.append(float(A['% Recovered'][i]))
        
        nhan=['% Confirmed','% Deaths','% Recovered']
        print(list_pie)
        # print(b)SS
        # print(nhan)
        fig4=px.pie(values=list_pie,names= nhan)
        st.plotly_chart(fig4, use_container_width=True)
    except :
        st.text( 'nhap lai!')

        




st.title("Data visualization about covid-19")
ly.Title()

upload_file_maps=None

upload_file_maps=ly.upload_data()

global data_maps
if upload_file_maps is not None: 
    #read data
    data_maps=pd.read_csv(upload_file_maps)
    st.sidebar.text('Choose a representative number')
    st.sidebar.text('1. Column chart')
    st.sidebar.text('2. Line chart')
    st.sidebar.text('3. Map word')
    st.sidebar.text("4. Pie chart")
    st.sidebar.text("5. Statistics")
    option = None
    option = st.sidebar.number_input('Insert a number',step=1)
    if option is not None:
        if option == 1:
            char_column(data_maps.copy())
        elif option==2:
            Line_chart(data_maps.copy())
        elif option == 3:
            map_word(data_maps.copy())
        elif option == 4:
            pie_chart(data_maps.copy())
        elif option == 5:
            st.title('Statistics')
            statistics(data_maps.copy())
        else:
            st.text('dang up')
   



   
   
    