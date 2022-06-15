package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcpoliticaprivacidaddatospersonales extends GXProcedure
{
   public prcpoliticaprivacidaddatospersonales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcpoliticaprivacidaddatospersonales.class ), "" );
   }

   public prcpoliticaprivacidaddatospersonales( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( GXBaseCollection<com.projectthani.SdtSDT_PPDP>[] aP0 )
   {
      prcpoliticaprivacidaddatospersonales.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDT_PPDP>[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDT_PPDP>[] aP0 ,
                             String[] aP1 )
   {
      prcpoliticaprivacidaddatospersonales.this.aP0 = aP0;
      prcpoliticaprivacidaddatospersonales.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV46TituloDoc = "Pol�tica de Privacidad y Datos Personales" ;
      AV35NombreEmpresa = "DESARROLLO DE PLATAFORMAS Y SERVICIOS DIGITALES S.A.C" ;
      AV34NombreComercial = "THANI" ;
      AV44RucEmpresa = "20606936134" ;
      AV21DireccionEmpresa = "Jir�n Ferm�n Tanguis N�145 Dpto 501 Urb. Santa Catalina, distrito de La Victoria." ;
      AV22DominioPlataforma = "www.****.com" ;
      AV23EmailEmpresa = "....@gmail.com" ;
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "I. Introducci�n" );
      AV32Itroduccion = AV35NombreEmpresa + " (en adelante usaremos el nombre comercial: �" + AV34NombreComercial + "�) en cumplimiento de todas las disposiciones legales y reglamentarias, entiende que los datos personales, al ser parte integrante de la privacidad de las personas; y tambi�n, fundamentales para nuestra actividad, deben ser tratados de tal forma que no solo impliquen el cumplimiento del ordenamiento legal, sino que, adem�s, se deben tomar medidas que generen un ambiente de confianza y seguridad en el p�blico respecto a dicho tratamiento." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV32Itroduccion );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "II. Objetivo" );
      AV36Objetivo = "El presente documento contiene la Pol�tica de Privacidad de " + AV34NombreComercial + " y se encuentra acorde a la normativa vigente sobre Protecci�n de Datos Personales (Ley N� 29733 Y Decreto Supremo 003-2013-JUS). En el presente documento, se se�alan las finalidades de la informaci�n que usted nos proporciona, qui�nes son los encargados de tratarla, las medidas de protecci�n y los medios para ejercer sus derechos como titular de los Datos Personales, entre otros aspectos. Por favor lea con detenimiento este documento para entender la informaci�n que recolectamos sobre usted, c�mo la usamos y las circunstancias bajo las cuales la compartiremos con terceros." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV36Objetivo );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "III. Consentimiento" );
      AV8Consentimiento = "Al hacer uso de " + AV34NombreComercial + " usted acepta esta Pol�tica de Privacidad y presta su consentimiento expreso para que " + AV34NombreComercial + " recolecte y procese informaci�n personal del usuario. Asimismo, declara estar de acuerdo con todos los aspectos expuestos en este documento y autoriza a tratar sus datos personales para las finalidades expuestas. Cabe precisar que, " + AV34NombreComercial + " no requiere consentimiento para tratar sus datos personales obtenidos de fuentes accesibles al p�blico; asimismo, podr� tratar sus datos personales de fuentes no p�blicas, siempre que dichas fuentes cuenten con su consentimiento para tratar y transferir dichos datos personales." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV8Consentimiento );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "IV. Principios" );
      AV41Principios += "THANI se compromete a respetar los principios rectores establecidos en la Normativa de Protecci�n de Datos Personales. Estos son:<br>" ;
      AV41Principios += "<b>Principio de legalidad:</b> El tratamiento de los datos personales se hace conforme a lo establecido en la ley, estando prohibida la recopilaci�n de los datos personales por medios fraudulentos, desleales o il�citos.<br>" ;
      AV41Principios += "<b>Principio de consentimiento:</b> Para el tratamiento de los datos personales debe mediar el consentimiento de su titular, salvo que medie alguna de las excepciones previstas en la ley. Dicho consentimiento debe cumplir con los requisitos de ser libre, previo a su recopilaci�n o tratamiento, expreso e inequ�voco, e informado.<br>" ;
      AV41Principios += "<b>Principio de finalidad:</b> Los datos personales deben ser recopilados para una finalidad determinada, expl�cita y l�cita, y su tratamiento no debe extenderse a otra finalidad distinta a aquella para la cual fueron recopilados.<br>" ;
      AV41Principios += "<b>Principio de proporcionalidad:</b> El tratamiento de datos personales debe ser adecuado, relevante y no excesivo a la finalidad para la que estos hubiesen sido recopilados.<br>" ;
      AV41Principios += "<b>Principio de calidad:</b> Los datos personales que vayan a ser tratados deben ser veraces, exactos y, en la medida de lo posible, actualizados, necesarios, pertinentes y adecuados respecto de la finalidad para la que fueron recopilados.<br>" ;
      AV41Principios += "<b>Principio de seguridad:</b> El titular del banco de datos personales y el Encargado del banco de datos personales deben adoptar las medidas t�cnicas, organizativas y legales necesarias para garantizar la seguridad de los datos personales.<br>" ;
      AV41Principios += "<b>Principio de disposici�n de recurso:</b> El titular de datos personales debe contar con las v�as administrativas o jurisdiccionales necesarias para reclamar y hacer valer sus derechos, cuando estos sean vulnerados por el tratamiento de sus datos personales.<br>" ;
      AV41Principios += "<b>Principio de nivel de protecci�n adecuado:</b> Para el flujo transfronterizo de datos personales, se debe garantizar un nivel suficiente de protecci�n para los datos personales que se vayan a tratar o, por lo menos, equiparable a lo previsto por la Ley de Protecci�n de Datos Personales o por los est�ndares internacionales en la materia." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV41Principios );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "V. Informaci�n Personal" );
      AV42PrincipiosPer = "Por informaci�n personal nos referimos a informaci�n que se encuentre asociada con una persona natural en espec�fico y que puede ser razonablemente utilizada para identificar a esta persona.<br>La informaci�n personal no incluye a la informaci�n que haya pasado por un proceso de anonimato y que por tanto no puede ser utilizada para identificar a una persona." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV42PrincipiosPer );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "VI. Informaci�n que podr�amos recolectar sobre usted" );
      AV25InformacionRec = "Informaci�n proporcionada por usted al llenarlos formatos en nuestra p�gina web, y aplicativo, y/o al interactuar con nosotros por v�a telef�nica, correo electr�nico o de otra forma. Esto incluye, pero no se limita a informaci�n proporcionada al registrarse como usuario para utilizar la p�gina web, realizar operaciones utilizando la p�gina web o reportar alg�n problema en la p�gina web. La informaci�n podr�a incluir su nombre, fecha de nacimiento, direcci�n, n�meros de cuenta bancarios e interbancarios, descripci�n personal, ubicaci�n geogr�fica, fotograf�a, copias de documentos de identidad, y entre otros." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV25InformacionRec );
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "Usos de la informaci�n recolectada" );
      AV26InformacionRec2 = "� La recolecci�n y tratamiento de los Datos Personales, as� como los eventuales encargos, transferencias y flujos transfronterizos que se realicen sobre estos a empresas vinculadas o proveedores de THANI, tiene las siguientes finalidades:" ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV26InformacionRec2 );
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "a)	Informaci�n proporcionada por usted:" );
      AV27InformacionRec21 += "� Para cumplir con nuestras obligaciones adquiridas en el marco de cualquier contrato entre usted y nosotros (incluyendo, pero sin limitarse a los T�rminos y Condiciones) y para proveerle de informaci�n, productos y servicios que requiera.<br>" ;
      AV27InformacionRec21 += "� Para proveerle informaci�n sobre otros bienes y servicios que ofrecemos, que sean similares a aquellos que usted ya utiliza. <br>" ;
      AV27InformacionRec21 += "� Para el env�o de anuncios y oferta de servicios por medio del correo electr�nico registrado en la p�gina web, env�o de SMS y/o llamadas al n�mero telef�nico que el usted ha registrado.<br>" ;
      AV27InformacionRec21 += "� Para la ejecuci�n y mantenimiento de otras relaciones contractuales mantenidas entre Usted y THANI.<br>" ;
      AV27InformacionRec21 += "� Para asegurarnos que el contenido presentado en nuestra p�gina web sea el m�s id�neo de acuerdo a sus preferencias y dispositivos.<br>" ;
      AV27InformacionRec21 += "� Para cumplir con todos los requerimientos legales y regulatorios impuestos por las autoridades respectivas.<br>" ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV27InformacionRec21 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "b)	Informaci�n que recolectamos sobre usted:" );
      AV28InformacionRec22 += "� Para administrar nuestra p�gina web y para operaciones internas como soluci�n de problemas operativos, an�lisis de datos, pruebas, as� como fines estad�sticos y de investigaci�n.<br>" ;
      AV28InformacionRec22 += "� Para permitirle participar en partes interactivas de nuestros servicios cuando usted desee hacerlo.<br>" ;
      AV28InformacionRec22 += "� Para asegurar, mantener y mejorar la seguridad de nuestra APP y/o p�gina web.<br>" ;
      AV28InformacionRec22 += "� Para medir y entender la efectividad de la publicidad enviada a usted y a otros, con el fin de poder enviarle publicidad relevante y adecuada a sus intereses.<br>" ;
      AV28InformacionRec22 += "� Para brindarle recomendaciones acerca de otros bienes y servicios que podr�an interesarle." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV28InformacionRec22 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "c)	Informaci�n que recibimos de otras fuentes:" );
      AV29InformacionRec23 = "Nosotros podr�amos combinar la informaci�n brindada por usted con informaci�n recolectada de otras fuentes con la finalidad de actualizar datos que se encuentren incompletos o sustituirlos, en base a consultas de fuentes de acceso p�blico. Esta informaci�n, y la informaci�n combinada, podr�a ser usada para cualquiera de los fines mencionados anteriormente." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV29InformacionRec23 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "Revelaci�n de su informaci�n: " );
      AV30InformacionRec3 += "Nosotros podr�amos compartir su informaci�n personal con proveedores o terceros contratados para proveer cualquier contrato que tengamos con usted o para ayudar a mejorar nuestro servicio. � Agencias de publicidad que requieran datos para seleccionar y enviar avisos relevantes a usted o terceros. � Proveedores de an�lisis de datos y de buscadores que nos asistan en la mejora y optimizaci�n de nuestros servicios. � Entes reguladores o autoridades en el ejercicio de sus funciones que as� nos lo demanden.<br>" ;
      AV30InformacionRec3 += "Podr�amos compartir su informaci�n personal con terceros: En caso que se venda o compre cualquier unidad del negocio o activo y sea necesario revelar su informaci�n personal a potenciales compradores o vendedores de dichas unidades de negocio o activos. Si THANI o todos sus activos son adquiridos por un tercero, en cuyo caso la informaci�n personal recolectada podr�a ser uno de los activos a transferir Si es que estamos bajo obligaci�n de revelar o compartir su informaci�n personal para cumplir con cualquier obligaci�n legal, o para poder aplicar los T�rminos y Condiciones o cualquier documento al cual se haga referencia en �stos, o para proteger los derechos, propiedad y seguridad de THANI de nuestros usuarios o de terceros. Esto incluye intercambiar informaci�n con otras compa��as y organizaciones con objetivos de protecci�n frente a fraudes, investigaci�n relacionada cr�menes financieros o proveer datos para asistir al cumplimiento de la ley." ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV30InformacionRec3 );
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "D�nde almacenamos su informaci�n personal:" );
      AV31InformacionRec4 = "La informaci�n recolectada podr�a ser transferida y almacenada en un destino fuera del Per�. Esta podr�a ser tambi�n procesada por trabajadores operando fuera del Per� que trabajen para nosotros o para alg�n proveedor. Estos trabajadores podr�an estar asociados a actividades como la provisi�n de servicios de soporte o de an�lisis de datos. Al enviar su informaci�n personal usted reconoce que se encuentra de acuerdo con esta transferencia, almacenamiento o procesamiento. Nosotros tomaremos todas las medidas necesarias para asegurarnos de que su informaci�n sea tratada de forma segura y de acuerdo con las Pol�ticas de Privacidad que se establecen en este documento. Toda la informaci�n que nos env�e se almacena en nuestros servidores seguros. Usted es responsable de mantener la confidencialidad de la contrase�a seleccionada para acceder a ciertas partes de la p�gina web. Le pedimos <b>no compartir su contrase�a con nadie</b> ya que THANI no se har� responsable ante la p�rdida, mal uso o robo de su contrase�a. Desafortunadamente la transmisi�n de informaci�n a trav�s de internet no es completamente segura. A pesar de que tomamos los mayores cuidados, no podemos garantizar la seguridad de la informaci�n transmitida a nuestra p�gina web; cualquier transmisi�n es bajo su propio riesgo. Una vez recibida la informaci�n, utilizamos procedimientos estrictos y procesos de seguridad para evitar cualquier acceso a �sta sin autorizaci�n. Nosotros restringimos el acceso a su informaci�n personal a empleados de THANI que tengan necesidad de conocerla por razones asociadas a los servicios brindados. Nuestros trabajadores son capacitados sobre la importancia de la confidencialidad y privacidad de la informaci�n de los usuarios y nuestros procesos cumplen con los requerimientos legales para proteger su informaci�n personal de cualquier acceso no autorizado." ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV31InformacionRec4 );
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "VIII.	Derechos de los Titulares" );
      AV11DerechosTitulares = "De acuerdo con la Normativa de Protecci�n de Datos Personales, los titulares de datos personales tienen los siguientes derechos:" ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV11DerechosTitulares );
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>1. Derecho de Acceso e informaci�n:</b>" );
      AV12DerechosTitulares1 = "Como consecuencia del derecho de acceso, el titular de datos personales tiene derecho a obtener la informaci�n que sobre s� mismo sea objeto de tratamiento en bancos de datos, la forma en que sus datos fueron recopilados, las razones que motivaron su recopilaci�n, las transferencias realizadas, o a qui�n se prev�n hacer, entre otras. El derecho de informaci�n, por su parte, otorga al titular el derecho de conocer de forma previa a la recopilaci�n de sus datos, la finalidad para la cual sus datos ser�n tratados, la existencia del banco de datos en que ser�n almacenados, la identidad y domicilio del titular del banco de datos y de los encargados del tratamiento, si se producir� la transferencia de datos personales y a quienes, el tiempo de conservaci�n, entre otros." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV12DerechosTitulares1 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>2. Derecho de rectificaci�n, actualizaci�n e inclusi�n:</b>" );
      AV13DerechosTitulares2 = "El titular de datos personales tiene derecho a la actualizaci�n, inclusi�n y rectificaci�n de sus datos personales materia de tratamiento por parte de THANI cuando estos sean parcial o totalmente inexactos, incompletos o cuando se hubiere advertido omisi�n, error o falsedad." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV13DerechosTitulares2 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>3.	Derecho de Cancelaci�n o Supresi�n:</b>" );
      AV14DerechosTitulares3 = "El titular de datos personales podr� solicitar la cancelaci�n o supresi�n de sus datos personales no relacionados o necesarios para la ejecuci�n de las obligaciones de cargo de THANI previstas en los contratos suscritos o las dispuestas por la normativa vigente." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV14DerechosTitulares3 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>4.	Derecho a impedir el suministro:</b>" );
      AV15DerechosTitulares4 = "El titular de datos personales tiene derecho a impedir que sus datos personales sean suministrados, especialmente cuando el suministro afecte sus derechos fundamentales, salvo que el suministro se ejecute entre el titular del banco de datos personales y un encargado del banco de datos personales, para efectos de su tratamiento." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV15DerechosTitulares4 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>5.	Derecho de Oposici�n:</b>" );
      AV16DerechosTitulares5 = "El titular de datos personales puede oponerse al tratamiento de sus datos personales en cualquier momento. La oposici�n proceder� en la medida que el tratamiento no tenga justificaci�n contractual o legal." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV16DerechosTitulares5 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>6.	Derecho de revocaci�n:</b>" );
      AV17DerechosTitulares6 = "El titular de datos personales puede retirar en cualquier momento el consentimiento otorgado de manera previa. La revocaci�n no alcanzar� a los usos y/o tratamientos que puedan ejecutarse en los escenarios autorizados por la regulaci�n." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV17DerechosTitulares6 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>7.	Derecho al tratamiento objetivo:</b>" );
      AV18DerechosTitulares7 = "El titular de datos personales tiene derecho a no ser afectado por una decisi�n que se sustente �nicamente en un tratamiento de datos personales destinado a evaluar determinados aspectos de su personalidad o conducta, salvo que ello ocurra en el marco de un contrato o en los casos de evaluaci�n con fines de incorporaci�n a una entidad p�blica, de acuerdo a ley, sin perjuicio de la posibilidad de defender su punto de vista, para salvaguardar su leg�timo inter�s." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV18DerechosTitulares7 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>8.	Derecho a la tutela:</b>" );
      AV19DerechosTitulares8 = "En caso de que el titular o el encargado del banco de datos personales deniegue al titular de datos personales, total o parcialmente, el ejercicio de los derechos establecidos en esta Ley, este puede recurrir ante la Autoridad Nacional de Protecci�n de Datos Personales en v�a de reclamaci�n o al Poder Judicial para los efectos de la correspondiente acci�n de h�beas data." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV19DerechosTitulares8 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>9.	Derecho a ser indemnizado:</b>" );
      AV20DerechosTitulares9 = "El titular de datos personales que sea afectado a consecuencia del incumplimiento de la presente Ley por el titular o por el encargado del banco de datos personales o por terceros, tiene derecho a obtener la indemnizaci�n correspondiente, conforme a ley." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV20DerechosTitulares9 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "IX. Procedimiento para el ejercicio de los derechos del Titular de los Datos Personales" );
      AV43ProcedimientoEjer = "Los Titulares podr�n revocar su consentimiento o ejercer sus derechos de Ley, dirigi�ndose al correo ******@*******.com indicando su nombre completo, DNI y adjuntando copia de dicho DNI." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV43ProcedimientoEjer );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "X. Plazo del Tratamiento de Datos Personales" );
      AV47TratamientoDat = "Los datos personales tratados por THANI ser�n almacenados por el tiempo necesario para cumplir las finalidades de tratamiento autorizadas por el titular, sin perjuicio de que este pueda ejercer en cualquier momento los derechos mencionados en el numeral VIII de esta pol�tica." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV47TratamientoDat );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XI. Seguridad de los Datos Personales" );
      AV45Seguridad = "En cumplimiento de la normativa vigente, THANI adopta las medidas jur�dicas, organizativas y t�cnicas apropiadas para garantizar la seguridad de los datos personales, evitando su alteraci�n, p�rdida, tratamiento indebido o acceso no autorizado." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV45Seguridad );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XI. Cookies" );
      AV9Cookies += "En THANI usamos cookies y tecnolog�as similares para personalizar y mejorar su experiencia de cliente y para mostrarle publicidad online relevante. Las cookies son peque�os archivos de texto que contienen un identificador �nico que se almacena en el computador o aparato m�vil a trav�s del cual usted accede al Sitio, de manera que aquellos pueden ser reconocidos cada vez que usa el Sitio.<br>" ;
      AV9Cookies += "Usted puede deshabilitar el uso de cookies seg�n la configuraci�n de su navegador. Tenga en cuenta que existen algunas cookies t�cnicas que al deshabilitarse podr�an incluso impedir el funcionamiento correcto del sitio web." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV9Cookies );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XII. Modificaciones" );
      AV33Modificaciones = "De producirse cualquier cambio o modificaci�n de la presente Pol�tica, el texto vigente de la misma ser� publicado en nuestro portal web: https://www.********** en la secci�n Pol�tica de Privacidad." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV33Modificaciones );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XIV. Informaci�n General" );
      AV24InfoGeneral += "Como parte de nuestra actividad, tratamos datos personales en cumplimiento con lo dispuesto en la Normativa de Protecci�n de Datos Personales.<br>" ;
      AV24InfoGeneral += "Los datos personales cuyo tratamiento realizamos son almacenados en bancos de datos personales de titularidad de THANI, debidamente inscritos ante la Autoridad de Protecci�n de Datos Personales." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV24InfoGeneral );
      AV39PPDPList.add(AV37PPDP, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcpoliticaprivacidaddatospersonales.this.AV39PPDPList;
      this.aP1[0] = prcpoliticaprivacidaddatospersonales.this.AV46TituloDoc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39PPDPList = new GXBaseCollection<com.projectthani.SdtSDT_PPDP>(com.projectthani.SdtSDT_PPDP.class, "SDT_PPDP", "ProjectThani", remoteHandle);
      AV46TituloDoc = "" ;
      AV35NombreEmpresa = "" ;
      AV34NombreComercial = "" ;
      AV44RucEmpresa = "" ;
      AV21DireccionEmpresa = "" ;
      AV22DominioPlataforma = "" ;
      AV23EmailEmpresa = "" ;
      AV37PPDP = new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV32Itroduccion = "" ;
      AV36Objetivo = "" ;
      AV8Consentimiento = "" ;
      AV41Principios = "" ;
      AV42PrincipiosPer = "" ;
      AV25InformacionRec = "" ;
      AV38PPDPItem = new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV26InformacionRec2 = "" ;
      AV40PPDPSubItem = new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV27InformacionRec21 = "" ;
      AV28InformacionRec22 = "" ;
      AV29InformacionRec23 = "" ;
      AV30InformacionRec3 = "" ;
      AV31InformacionRec4 = "" ;
      AV11DerechosTitulares = "" ;
      AV12DerechosTitulares1 = "" ;
      AV13DerechosTitulares2 = "" ;
      AV14DerechosTitulares3 = "" ;
      AV15DerechosTitulares4 = "" ;
      AV16DerechosTitulares5 = "" ;
      AV17DerechosTitulares6 = "" ;
      AV18DerechosTitulares7 = "" ;
      AV19DerechosTitulares8 = "" ;
      AV20DerechosTitulares9 = "" ;
      AV43ProcedimientoEjer = "" ;
      AV47TratamientoDat = "" ;
      AV45Seguridad = "" ;
      AV9Cookies = "" ;
      AV33Modificaciones = "" ;
      AV24InfoGeneral = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV46TituloDoc ;
   private String AV35NombreEmpresa ;
   private String AV34NombreComercial ;
   private String AV44RucEmpresa ;
   private String AV21DireccionEmpresa ;
   private String AV22DominioPlataforma ;
   private String AV23EmailEmpresa ;
   private String AV32Itroduccion ;
   private String AV36Objetivo ;
   private String AV8Consentimiento ;
   private String AV41Principios ;
   private String AV42PrincipiosPer ;
   private String AV25InformacionRec ;
   private String AV26InformacionRec2 ;
   private String AV27InformacionRec21 ;
   private String AV28InformacionRec22 ;
   private String AV29InformacionRec23 ;
   private String AV30InformacionRec3 ;
   private String AV31InformacionRec4 ;
   private String AV11DerechosTitulares ;
   private String AV12DerechosTitulares1 ;
   private String AV13DerechosTitulares2 ;
   private String AV14DerechosTitulares3 ;
   private String AV15DerechosTitulares4 ;
   private String AV16DerechosTitulares5 ;
   private String AV17DerechosTitulares6 ;
   private String AV18DerechosTitulares7 ;
   private String AV19DerechosTitulares8 ;
   private String AV20DerechosTitulares9 ;
   private String AV43ProcedimientoEjer ;
   private String AV47TratamientoDat ;
   private String AV45Seguridad ;
   private String AV9Cookies ;
   private String AV33Modificaciones ;
   private String AV24InfoGeneral ;
   private String[] aP1 ;
   private GXBaseCollection<com.projectthani.SdtSDT_PPDP>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDT_PPDP> AV39PPDPList ;
   private com.projectthani.SdtSDT_PPDP AV37PPDP ;
   private com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem AV38PPDPItem ;
   private com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem AV40PPDPSubItem ;
}

