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
      AV46TituloDoc = "Política de Privacidad y Datos Personales" ;
      AV35NombreEmpresa = "DESARROLLO DE PLATAFORMAS Y SERVICIOS DIGITALES S.A.C" ;
      AV34NombreComercial = "THANI" ;
      AV44RucEmpresa = "20606936134" ;
      AV21DireccionEmpresa = "Jirón Fermín Tanguis N°145 Dpto 501 Urb. Santa Catalina, distrito de La Victoria." ;
      AV22DominioPlataforma = "www.****.com" ;
      AV23EmailEmpresa = "....@gmail.com" ;
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "I. Introducción" );
      AV32Itroduccion = AV35NombreEmpresa + " (en adelante usaremos el nombre comercial: “" + AV34NombreComercial + "”) en cumplimiento de todas las disposiciones legales y reglamentarias, entiende que los datos personales, al ser parte integrante de la privacidad de las personas; y también, fundamentales para nuestra actividad, deben ser tratados de tal forma que no solo impliquen el cumplimiento del ordenamiento legal, sino que, además, se deben tomar medidas que generen un ambiente de confianza y seguridad en el público respecto a dicho tratamiento." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV32Itroduccion );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "II. Objetivo" );
      AV36Objetivo = "El presente documento contiene la Política de Privacidad de " + AV34NombreComercial + " y se encuentra acorde a la normativa vigente sobre Protección de Datos Personales (Ley N° 29733 Y Decreto Supremo 003-2013-JUS). En el presente documento, se señalan las finalidades de la información que usted nos proporciona, quiénes son los encargados de tratarla, las medidas de protección y los medios para ejercer sus derechos como titular de los Datos Personales, entre otros aspectos. Por favor lea con detenimiento este documento para entender la información que recolectamos sobre usted, cómo la usamos y las circunstancias bajo las cuales la compartiremos con terceros." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV36Objetivo );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "III. Consentimiento" );
      AV8Consentimiento = "Al hacer uso de " + AV34NombreComercial + " usted acepta esta Política de Privacidad y presta su consentimiento expreso para que " + AV34NombreComercial + " recolecte y procese información personal del usuario. Asimismo, declara estar de acuerdo con todos los aspectos expuestos en este documento y autoriza a tratar sus datos personales para las finalidades expuestas. Cabe precisar que, " + AV34NombreComercial + " no requiere consentimiento para tratar sus datos personales obtenidos de fuentes accesibles al público; asimismo, podrá tratar sus datos personales de fuentes no públicas, siempre que dichas fuentes cuenten con su consentimiento para tratar y transferir dichos datos personales." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV8Consentimiento );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "IV. Principios" );
      AV41Principios += "THANI se compromete a respetar los principios rectores establecidos en la Normativa de Protección de Datos Personales. Estos son:<br>" ;
      AV41Principios += "<b>Principio de legalidad:</b> El tratamiento de los datos personales se hace conforme a lo establecido en la ley, estando prohibida la recopilación de los datos personales por medios fraudulentos, desleales o ilícitos.<br>" ;
      AV41Principios += "<b>Principio de consentimiento:</b> Para el tratamiento de los datos personales debe mediar el consentimiento de su titular, salvo que medie alguna de las excepciones previstas en la ley. Dicho consentimiento debe cumplir con los requisitos de ser libre, previo a su recopilación o tratamiento, expreso e inequívoco, e informado.<br>" ;
      AV41Principios += "<b>Principio de finalidad:</b> Los datos personales deben ser recopilados para una finalidad determinada, explícita y lícita, y su tratamiento no debe extenderse a otra finalidad distinta a aquella para la cual fueron recopilados.<br>" ;
      AV41Principios += "<b>Principio de proporcionalidad:</b> El tratamiento de datos personales debe ser adecuado, relevante y no excesivo a la finalidad para la que estos hubiesen sido recopilados.<br>" ;
      AV41Principios += "<b>Principio de calidad:</b> Los datos personales que vayan a ser tratados deben ser veraces, exactos y, en la medida de lo posible, actualizados, necesarios, pertinentes y adecuados respecto de la finalidad para la que fueron recopilados.<br>" ;
      AV41Principios += "<b>Principio de seguridad:</b> El titular del banco de datos personales y el Encargado del banco de datos personales deben adoptar las medidas técnicas, organizativas y legales necesarias para garantizar la seguridad de los datos personales.<br>" ;
      AV41Principios += "<b>Principio de disposición de recurso:</b> El titular de datos personales debe contar con las vías administrativas o jurisdiccionales necesarias para reclamar y hacer valer sus derechos, cuando estos sean vulnerados por el tratamiento de sus datos personales.<br>" ;
      AV41Principios += "<b>Principio de nivel de protección adecuado:</b> Para el flujo transfronterizo de datos personales, se debe garantizar un nivel suficiente de protección para los datos personales que se vayan a tratar o, por lo menos, equiparable a lo previsto por la Ley de Protección de Datos Personales o por los estándares internacionales en la materia." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV41Principios );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "V. Información Personal" );
      AV42PrincipiosPer = "Por información personal nos referimos a información que se encuentre asociada con una persona natural en específico y que puede ser razonablemente utilizada para identificar a esta persona.<br>La información personal no incluye a la información que haya pasado por un proceso de anonimato y que por tanto no puede ser utilizada para identificar a una persona." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV42PrincipiosPer );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "VI. Información que podríamos recolectar sobre usted" );
      AV25InformacionRec = "Información proporcionada por usted al llenarlos formatos en nuestra página web, y aplicativo, y/o al interactuar con nosotros por vía telefónica, correo electrónico o de otra forma. Esto incluye, pero no se limita a información proporcionada al registrarse como usuario para utilizar la página web, realizar operaciones utilizando la página web o reportar algún problema en la página web. La información podría incluir su nombre, fecha de nacimiento, dirección, números de cuenta bancarios e interbancarios, descripción personal, ubicación geográfica, fotografía, copias de documentos de identidad, y entre otros." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV25InformacionRec );
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "Usos de la información recolectada" );
      AV26InformacionRec2 = "• La recolección y tratamiento de los Datos Personales, así como los eventuales encargos, transferencias y flujos transfronterizos que se realicen sobre estos a empresas vinculadas o proveedores de THANI, tiene las siguientes finalidades:" ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV26InformacionRec2 );
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "a)	Información proporcionada por usted:" );
      AV27InformacionRec21 += "• Para cumplir con nuestras obligaciones adquiridas en el marco de cualquier contrato entre usted y nosotros (incluyendo, pero sin limitarse a los Términos y Condiciones) y para proveerle de información, productos y servicios que requiera.<br>" ;
      AV27InformacionRec21 += "• Para proveerle información sobre otros bienes y servicios que ofrecemos, que sean similares a aquellos que usted ya utiliza. <br>" ;
      AV27InformacionRec21 += "• Para el envío de anuncios y oferta de servicios por medio del correo electrónico registrado en la página web, envío de SMS y/o llamadas al número telefónico que el usted ha registrado.<br>" ;
      AV27InformacionRec21 += "• Para la ejecución y mantenimiento de otras relaciones contractuales mantenidas entre Usted y THANI.<br>" ;
      AV27InformacionRec21 += "• Para asegurarnos que el contenido presentado en nuestra página web sea el más idóneo de acuerdo a sus preferencias y dispositivos.<br>" ;
      AV27InformacionRec21 += "• Para cumplir con todos los requerimientos legales y regulatorios impuestos por las autoridades respectivas.<br>" ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV27InformacionRec21 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "b)	Información que recolectamos sobre usted:" );
      AV28InformacionRec22 += "• Para administrar nuestra página web y para operaciones internas como solución de problemas operativos, análisis de datos, pruebas, así como fines estadísticos y de investigación.<br>" ;
      AV28InformacionRec22 += "• Para permitirle participar en partes interactivas de nuestros servicios cuando usted desee hacerlo.<br>" ;
      AV28InformacionRec22 += "• Para asegurar, mantener y mejorar la seguridad de nuestra APP y/o página web.<br>" ;
      AV28InformacionRec22 += "• Para medir y entender la efectividad de la publicidad enviada a usted y a otros, con el fin de poder enviarle publicidad relevante y adecuada a sus intereses.<br>" ;
      AV28InformacionRec22 += "• Para brindarle recomendaciones acerca de otros bienes y servicios que podrían interesarle." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV28InformacionRec22 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "c)	Información que recibimos de otras fuentes:" );
      AV29InformacionRec23 = "Nosotros podríamos combinar la información brindada por usted con información recolectada de otras fuentes con la finalidad de actualizar datos que se encuentren incompletos o sustituirlos, en base a consultas de fuentes de acceso público. Esta información, y la información combinada, podría ser usada para cualquiera de los fines mencionados anteriormente." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV29InformacionRec23 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "Revelación de su información: " );
      AV30InformacionRec3 += "Nosotros podríamos compartir su información personal con proveedores o terceros contratados para proveer cualquier contrato que tengamos con usted o para ayudar a mejorar nuestro servicio. • Agencias de publicidad que requieran datos para seleccionar y enviar avisos relevantes a usted o terceros. • Proveedores de análisis de datos y de buscadores que nos asistan en la mejora y optimización de nuestros servicios. • Entes reguladores o autoridades en el ejercicio de sus funciones que así nos lo demanden.<br>" ;
      AV30InformacionRec3 += "Podríamos compartir su información personal con terceros: En caso que se venda o compre cualquier unidad del negocio o activo y sea necesario revelar su información personal a potenciales compradores o vendedores de dichas unidades de negocio o activos. Si THANI o todos sus activos son adquiridos por un tercero, en cuyo caso la información personal recolectada podría ser uno de los activos a transferir Si es que estamos bajo obligación de revelar o compartir su información personal para cumplir con cualquier obligación legal, o para poder aplicar los Términos y Condiciones o cualquier documento al cual se haga referencia en éstos, o para proteger los derechos, propiedad y seguridad de THANI de nuestros usuarios o de terceros. Esto incluye intercambiar información con otras compañías y organizaciones con objetivos de protección frente a fraudes, investigación relacionada crímenes financieros o proveer datos para asistir al cumplimiento de la ley." ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV30InformacionRec3 );
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Titulo( "Dónde almacenamos su información personal:" );
      AV31InformacionRec4 = "La información recolectada podría ser transferida y almacenada en un destino fuera del Perú. Esta podría ser también procesada por trabajadores operando fuera del Perú que trabajen para nosotros o para algún proveedor. Estos trabajadores podrían estar asociados a actividades como la provisión de servicios de soporte o de análisis de datos. Al enviar su información personal usted reconoce que se encuentra de acuerdo con esta transferencia, almacenamiento o procesamiento. Nosotros tomaremos todas las medidas necesarias para asegurarnos de que su información sea tratada de forma segura y de acuerdo con las Políticas de Privacidad que se establecen en este documento. Toda la información que nos envíe se almacena en nuestros servidores seguros. Usted es responsable de mantener la confidencialidad de la contraseña seleccionada para acceder a ciertas partes de la página web. Le pedimos <b>no compartir su contraseña con nadie</b> ya que THANI no se hará responsable ante la pérdida, mal uso o robo de su contraseña. Desafortunadamente la transmisión de información a través de internet no es completamente segura. A pesar de que tomamos los mayores cuidados, no podemos garantizar la seguridad de la información transmitida a nuestra página web; cualquier transmisión es bajo su propio riesgo. Una vez recibida la información, utilizamos procedimientos estrictos y procesos de seguridad para evitar cualquier acceso a ésta sin autorización. Nosotros restringimos el acceso a su información personal a empleados de THANI que tengan necesidad de conocerla por razones asociadas a los servicios brindados. Nuestros trabajadores son capacitados sobre la importancia de la confidencialidad y privacidad de la información de los usuarios y nuestros procesos cumplen con los requerimientos legales para proteger su información personal de cualquier acceso no autorizado." ;
      AV38PPDPItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Descripcion( AV31InformacionRec4 );
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "VIII.	Derechos de los Titulares" );
      AV11DerechosTitulares = "De acuerdo con la Normativa de Protección de Datos Personales, los titulares de datos personales tienen los siguientes derechos:" ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV11DerechosTitulares );
      AV38PPDPItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem(remoteHandle, context);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>1. Derecho de Acceso e información:</b>" );
      AV12DerechosTitulares1 = "Como consecuencia del derecho de acceso, el titular de datos personales tiene derecho a obtener la información que sobre sí mismo sea objeto de tratamiento en bancos de datos, la forma en que sus datos fueron recopilados, las razones que motivaron su recopilación, las transferencias realizadas, o a quién se prevén hacer, entre otras. El derecho de información, por su parte, otorga al titular el derecho de conocer de forma previa a la recopilación de sus datos, la finalidad para la cual sus datos serán tratados, la existencia del banco de datos en que serán almacenados, la identidad y domicilio del titular del banco de datos y de los encargados del tratamiento, si se producirá la transferencia de datos personales y a quienes, el tiempo de conservación, entre otros." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV12DerechosTitulares1 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>2. Derecho de rectificación, actualización e inclusión:</b>" );
      AV13DerechosTitulares2 = "El titular de datos personales tiene derecho a la actualización, inclusión y rectificación de sus datos personales materia de tratamiento por parte de THANI cuando estos sean parcial o totalmente inexactos, incompletos o cuando se hubiere advertido omisión, error o falsedad." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV13DerechosTitulares2 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>3.	Derecho de Cancelación o Supresión:</b>" );
      AV14DerechosTitulares3 = "El titular de datos personales podrá solicitar la cancelación o supresión de sus datos personales no relacionados o necesarios para la ejecución de las obligaciones de cargo de THANI previstas en los contratos suscritos o las dispuestas por la normativa vigente." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV14DerechosTitulares3 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>4.	Derecho a impedir el suministro:</b>" );
      AV15DerechosTitulares4 = "El titular de datos personales tiene derecho a impedir que sus datos personales sean suministrados, especialmente cuando el suministro afecte sus derechos fundamentales, salvo que el suministro se ejecute entre el titular del banco de datos personales y un encargado del banco de datos personales, para efectos de su tratamiento." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV15DerechosTitulares4 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>5.	Derecho de Oposición:</b>" );
      AV16DerechosTitulares5 = "El titular de datos personales puede oponerse al tratamiento de sus datos personales en cualquier momento. La oposición procederá en la medida que el tratamiento no tenga justificación contractual o legal." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV16DerechosTitulares5 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>6.	Derecho de revocación:</b>" );
      AV17DerechosTitulares6 = "El titular de datos personales puede retirar en cualquier momento el consentimiento otorgado de manera previa. La revocación no alcanzará a los usos y/o tratamientos que puedan ejecutarse en los escenarios autorizados por la regulación." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV17DerechosTitulares6 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>7.	Derecho al tratamiento objetivo:</b>" );
      AV18DerechosTitulares7 = "El titular de datos personales tiene derecho a no ser afectado por una decisión que se sustente únicamente en un tratamiento de datos personales destinado a evaluar determinados aspectos de su personalidad o conducta, salvo que ello ocurra en el marco de un contrato o en los casos de evaluación con fines de incorporación a una entidad pública, de acuerdo a ley, sin perjuicio de la posibilidad de defender su punto de vista, para salvaguardar su legítimo interés." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV18DerechosTitulares7 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>8.	Derecho a la tutela:</b>" );
      AV19DerechosTitulares8 = "En caso de que el titular o el encargado del banco de datos personales deniegue al titular de datos personales, total o parcialmente, el ejercicio de los derechos establecidos en esta Ley, este puede recurrir ante la Autoridad Nacional de Protección de Datos Personales en vía de reclamación o al Poder Judicial para los efectos de la correspondiente acción de hábeas data." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV19DerechosTitulares8 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV40PPDPSubItem = (com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem)new com.projectthani.SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem(remoteHandle, context);
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Titulo( "<b>9.	Derecho a ser indemnizado:</b>" );
      AV20DerechosTitulares9 = "El titular de datos personales que sea afectado a consecuencia del incumplimiento de la presente Ley por el titular o por el encargado del banco de datos personales o por terceros, tiene derecho a obtener la indemnización correspondiente, conforme a ley." ;
      AV40PPDPSubItem.setgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_Descripcion( AV20DerechosTitulares9 );
      AV38PPDPItem.getgxTv_SdtSDT_PPDP_SDT_PPDP_SubItem_Sdt_ppdp_subitem_sub().add(AV40PPDPSubItem, 0);
      AV37PPDP.getgxTv_SdtSDT_PPDP_Sdt_ppdp_sub().add(AV38PPDPItem, 0);
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "IX. Procedimiento para el ejercicio de los derechos del Titular de los Datos Personales" );
      AV43ProcedimientoEjer = "Los Titulares podrán revocar su consentimiento o ejercer sus derechos de Ley, dirigiéndose al correo ******@*******.com indicando su nombre completo, DNI y adjuntando copia de dicho DNI." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV43ProcedimientoEjer );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "X. Plazo del Tratamiento de Datos Personales" );
      AV47TratamientoDat = "Los datos personales tratados por THANI serán almacenados por el tiempo necesario para cumplir las finalidades de tratamiento autorizadas por el titular, sin perjuicio de que este pueda ejercer en cualquier momento los derechos mencionados en el numeral VIII de esta política." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV47TratamientoDat );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XI. Seguridad de los Datos Personales" );
      AV45Seguridad = "En cumplimiento de la normativa vigente, THANI adopta las medidas jurídicas, organizativas y técnicas apropiadas para garantizar la seguridad de los datos personales, evitando su alteración, pérdida, tratamiento indebido o acceso no autorizado." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV45Seguridad );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XI. Cookies" );
      AV9Cookies += "En THANI usamos cookies y tecnologías similares para personalizar y mejorar su experiencia de cliente y para mostrarle publicidad online relevante. Las cookies son pequeños archivos de texto que contienen un identificador único que se almacena en el computador o aparato móvil a través del cual usted accede al Sitio, de manera que aquellos pueden ser reconocidos cada vez que usa el Sitio.<br>" ;
      AV9Cookies += "Usted puede deshabilitar el uso de cookies según la configuración de su navegador. Tenga en cuenta que existen algunas cookies técnicas que al deshabilitarse podrían incluso impedir el funcionamiento correcto del sitio web." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV9Cookies );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XII. Modificaciones" );
      AV33Modificaciones = "De producirse cualquier cambio o modificación de la presente Política, el texto vigente de la misma será publicado en nuestro portal web: https://www.********** en la sección Política de Privacidad." ;
      AV37PPDP.setgxTv_SdtSDT_PPDP_Descripcion( AV33Modificaciones );
      AV39PPDPList.add(AV37PPDP, 0);
      AV37PPDP = (com.projectthani.SdtSDT_PPDP)new com.projectthani.SdtSDT_PPDP(remoteHandle, context);
      AV37PPDP.setgxTv_SdtSDT_PPDP_Titulo( "XIV. Información General" );
      AV24InfoGeneral += "Como parte de nuestra actividad, tratamos datos personales en cumplimiento con lo dispuesto en la Normativa de Protección de Datos Personales.<br>" ;
      AV24InfoGeneral += "Los datos personales cuyo tratamiento realizamos son almacenados en bancos de datos personales de titularidad de THANI, debidamente inscritos ante la Autoridad de Protección de Datos Personales." ;
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

