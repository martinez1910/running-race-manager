<helpset version="1.0">
	<title>Manual de ayuda de 'Gestión de Carreras App'</title>
	<maps>
		<homeID>app</homeID>
		<mapref location="map_file.jhm"/>
   </maps>

   <view>
		<name>Tabla de Contenidos</name>
		<label>Tabla de Contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
   </view>

   <view>
		<name>Índice</name>
		<label>Índice</label>
		<type>javax.help.IndexView</type>
		<data>index.xml</data>
   </view>

   <view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">
			JavaHelpSearch
		</data>
   </view>
</helpset>