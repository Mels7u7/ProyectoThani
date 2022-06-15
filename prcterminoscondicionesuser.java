package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcterminoscondicionesuser extends GXProcedure
{
   public prcterminoscondicionesuser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcterminoscondicionesuser.class ), "" );
   }

   public prcterminoscondicionesuser( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones> executeUdp( )
   {
      prcterminoscondicionesuser.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones>[] aP0 )
   {
      prcterminoscondicionesuser.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV32TituloDoc = "T�RMINOS Y CONDICIONES GENERALES" ;
      AV20NombreEmpresa = "DESARROLLO DE PLATAFORMAS Y SERVICIOS DIGITALES S.A.C" ;
      AV19NombreComercial = "THANI" ;
      AV27RucEmpresa = "20606936134" ;
      AV9DireccionEmpresa = "Jir�n Ferm�n Tanguis N�145 Dpto 501 Urb. Santa Catalina, distrito de La Victoria." ;
      AV10DominioPlataforma = "app.thanitech.pe" ;
      AV11EmailEmpresa = "soporte@thanitech.pe" ;
      AV28TCUserItem = (com.projectthani.SdtSDTTerminosCondiciones)new com.projectthani.SdtSDTTerminosCondiciones(remoteHandle, context);
      AV28TCUserItem.setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo( AV32TituloDoc );
      AV14HtmGeneral += AV20NombreEmpresa + " (en adelante usaremos el nombre comercial: �" ;
      AV14HtmGeneral += AV19NombreComercial + "�) es una sociedad debidamente inscrita en el" ;
      AV14HtmGeneral += "registro de personas jur�dicas de Lima y Callao, identificada " ;
      AV14HtmGeneral += "con RUC N� " + AV27RucEmpresa + ", siendo su domicilio fiscal en " ;
      AV14HtmGeneral += AV9DireccionEmpresa + " Asimismo, " + AV19NombreComercial + " es un proveedor " ;
      AV14HtmGeneral += "de sitio web, mediante el cual los Usuarios que se registren " ;
      AV14HtmGeneral += "podr�n solicitar y agendar consultas con m�dicos y/o Cl�nicas " ;
      AV14HtmGeneral += "previamente inscritos de las especialidades que se indiquen, " ;
      AV14HtmGeneral += "las mismas que se llevar�n a cabo de manera virtual y/o presencial. " ;
      AV14HtmGeneral += "Asimismo, se podr� agendar o solicitar ex�menes auxiliares, " ;
      AV14HtmGeneral += "de laboratorio y/o farmacia.<br><br>" ;
      AV14HtmGeneral += "Este documento describe los t�rminos y condiciones generales " ;
      AV14HtmGeneral += "(los \"T�rminos y Condiciones Generales\") aplicables al acceso y " ;
      AV14HtmGeneral += "uso de los servicios ofrecidos por " + AV19NombreComercial + " (\"los Servicios\") " ;
      AV14HtmGeneral += "dentro del sitio " + AV10DominioPlataforma + "� y/o una aplicaci�n m�vil " ;
      AV14HtmGeneral += "denominada �" + AV19NombreComercial + "�, las cuales, en adelante, denominaremos " ;
      AV14HtmGeneral += "en su conjunto como �LAS APLICACIONES�, en donde estos T�rminos " ;
      AV14HtmGeneral += "y Condiciones se encuentren. Cualquier persona que desee acceder " ;
      AV14HtmGeneral += "y/o suscribirse y/o usar el Sitio o los Servicios podr� hacerlo" ;
      AV14HtmGeneral += "sujet�ndose a los T�rminos y Condiciones Generales y las " ;
      AV14HtmGeneral += "Pol�ticas de Privacidad, junto con todas las dem�s pol�ticas " ;
      AV14HtmGeneral += "y principios que rigen " + AV10DominioPlataforma + " y la aplicaci�n " + AV19NombreComercial + ". " ;
      AV14HtmGeneral += "En consecuencia, todas las visitas y todos los contratos y " ;
      AV14HtmGeneral += "transacciones que se realicen en este Sitio, as� como sus efectos " ;
      AV14HtmGeneral += "jur�dicos, quedar�n regidos por estas reglas y sometidos a la " ;
      AV14HtmGeneral += "legislaci�n aplicable en Per�.<br><br>" ;
      AV14HtmGeneral += "Los T�rminos y Condiciones contenidos en este instrumento se " ;
      AV14HtmGeneral += "aplicar�n y se entender�n como parte integral de todos los " ;
      AV14HtmGeneral += "actos y contratos que se ejecuten o celebren mediante los " ;
      AV14HtmGeneral += "sistemas de oferta y prestaci�n del servicio comprendidos en " ;
      AV14HtmGeneral += "este sitio entre los usuarios de este sitio y " + AV19NombreComercial + ", y por " ;
      AV14HtmGeneral += "cualquiera de las otras sociedades o personas que hagan uso " ;
      AV14HtmGeneral += "de este sitio, a las cuales se las denominar� en adelante " ;
      AV14HtmGeneral += "tambi�n en forma indistinta como el \"Proveedor\" o la \"Empresa " ;
      AV14HtmGeneral += "Proveedora\", seg�n convenga al sentido del texto.<br><br>" ;
      AV14HtmGeneral += "En caso que las Empresas proveedoras o el proveedor " ;
      AV14HtmGeneral += "hubieran fijado sus propios T�rminos y Condiciones y sus " ;
      AV14HtmGeneral += "Pol�ticas de Privacidad para los actos y contratos que realicen " ;
      AV14HtmGeneral += "en este sitio, ellas aparecer�n en esta p�gina se�alada con un " ;
      AV14HtmGeneral += "link o indicada como parte de la promoci�n de sus ofertas y " ;
      AV14HtmGeneral += "promociones y prevalecer�n sobre �stas.<br><br> " ;
      AV14HtmGeneral += "CUALQUIER PERSONA QUE NO ACEPTE ESTOS " ;
      AV14HtmGeneral += "T�RMINOS Y CONDICIONES GENERALES Y LAS " ;
      AV14HtmGeneral += "POL�TICAS DE PRIVACIDAD, LOS CUALES TIENEN UN " ;
      AV14HtmGeneral += "CAR�CTER OBLIGATORIO Y VINCULANTE, DEBER� " ;
      AV14HtmGeneral += "ABSTENERSE DE UTILIZAR EL SITIO Y/O LOS SERVICIOS.<br><br>" ;
      AV14HtmGeneral += "El Usuario debe leer, entender y aceptar todas las condiciones " ;
      AV14HtmGeneral += "establecidas en los T�rminos y Condiciones Generales y en las " ;
      AV14HtmGeneral += "Pol�ticas de Privacidad de " + AV19NombreComercial + ", as� como en los dem�s " ;
      AV14HtmGeneral += "documentos incorporados a los mismos por referencia, previo " ;
      AV14HtmGeneral += "a su registro como Usuario de la p�gina web app.thanitech.pe o en la " ;
      AV14HtmGeneral += "aplicaci�n " + AV19NombreComercial + " quedando sujetos a lo se�alado y dispuesto " ;
      AV14HtmGeneral += "en los T�rminos y Condiciones.<br><br>" ;
      AV14HtmGeneral += "Cuando usted visita o accede a la p�gina web o a la aplicaci�n " ;
      AV14HtmGeneral += "" + AV19NombreComercial + " se est� comunicando con " + AV19NombreComercial + " de manera " ;
      AV14HtmGeneral += "electr�nica. En ese sentido, usted brinda su consentimiento " ;
      AV14HtmGeneral += "para recibir comunicaciones de " + AV19NombreComercial + " por correo electr�nico o " ;
      AV14HtmGeneral += "mediante la publicaci�n de avisos en su portal.<br><br>" ;
      AV28TCUserItem.setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion( AV14HtmGeneral );
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "1. Capacidad legal" );
      AV13HtmCapLegal += "Los Servicios s�lo est�n disponibles para personas que " ;
      AV13HtmCapLegal += "tengan capacidad legal para contratar. No podr�n utilizar los " ;
      AV13HtmCapLegal += "servicios las personas que no tengan esa capacidad tales " ;
      AV13HtmCapLegal += "como: menores de edad o Usuarios que hayan sido " ;
      AV13HtmCapLegal += "suspendidos temporalmente o inhabilitados definitivamente " ;
      AV13HtmCapLegal += "en raz�n de lo dispuesto en la secci�n 2 �Registro y Uso del " ;
      AV13HtmCapLegal += "Sitio�. Los actos que los menores realicen en este sitio ser�n " ;
      AV13HtmCapLegal += "responsabilidad de sus padres, tutores, encargados o " ;
      AV13HtmCapLegal += "curadores, y por tanto se considerar�n realizados por �stos " ;
      AV13HtmCapLegal += "en ejercicio de la representaci�n legal con la que cuentan.<br><br>" ;
      AV13HtmCapLegal += "Quien registre un Usuario como empresa afirmar� que (i) " ;
      AV13HtmCapLegal += "cuenta con capacidad para contratar en representaci�n de tal " ;
      AV13HtmCapLegal += "entidad y de obligar a la misma en los t�rminos de este " ;
      AV13HtmCapLegal += "Acuerdo, (ii) la direcci�n se�alada en el registro es el domicilio " ;
      AV13HtmCapLegal += "principal Legal y/o Fiscal de dicha entidad, y (iii) cualquier otra " ;
      AV13HtmCapLegal += "informaci�n presentada a La empresa es verdadera, precisa, " ;
      AV13HtmCapLegal += "actualizada, completa y oportuna.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV13HtmCapLegal );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "2. Registro y uso del Sitio" );
      AV15HtmlRegUso += "Es obligatorio completar el formulario de registro en todos sus " ;
      AV15HtmlRegUso += "campos con datos v�lidos y verdaderos para convertirse en " ;
      AV15HtmlRegUso += "Usuario autorizado de THANI (el \"Usuario\"), de esta manera, " ;
      AV15HtmlRegUso += "podr� acceder a las promociones y servicios ofrecidos en este " ;
      AV15HtmlRegUso += "sitio. El futuro Usuario deber� completar el formulario de " ;
      AV15HtmlRegUso += "registro con su informaci�n personal de manera exacta, precisa " ;
      AV15HtmlRegUso += "y verdadera (\"Datos Personales\") y asume el compromiso de " ;
      AV15HtmlRegUso += "actualizar los Datos Personales conforme resulte necesario. " ;
      AV15HtmlRegUso += "THANI podr� utilizar diversos medios para identificar a sus " ;
      AV15HtmlRegUso += "Miembros, pero NO se responsabiliza por la certeza de los " ;
      AV15HtmlRegUso += "Datos Personales provistos por sus Usuarios. Los Usuarios " ;
      AV15HtmlRegUso += "garantizan y responden, en cualquier caso, de la exactitud, " ;
      AV15HtmlRegUso += "veracidad, vigencia y autenticidad de los Datos Personales " ;
      AV15HtmlRegUso += "ingresados. Por tanto, la declaraci�n realizada por los Usuarios " ;
      AV15HtmlRegUso += "al momento de registrarse se entender� como una Declaraci�n " ;
      AV15HtmlRegUso += "Jurada.<br><br>" ;
      AV15HtmlRegUso += "Cada persona natural s�lo podr� ser titular de una (1) cuenta, " ;
      AV15HtmlRegUso += "no pudiendo acceder a m�s de una (1) cuenta con distintas " ;
      AV15HtmlRegUso += "direcciones de correo electr�nico o falseando, modificando y/o " ;
      AV15HtmlRegUso += "alterando sus datos personales de cualquier manera posible. " ;
      AV15HtmlRegUso += "En caso se detecte esta infracci�n, THANI se comunicar� con " ;
      AV15HtmlRegUso += "el usuario inform�ndole que todas sus cuentas ser�n " ;
      AV15HtmlRegUso += "agrupadas en una sola cuenta anul�ndose las adicionales, ello " ;
      AV15HtmlRegUso += "se informara al usuario mediante correo electr�nico indicado " ;
      AV15HtmlRegUso += "por �l mismo o el �ltimo registrado.<br><br>" ;
      AV15HtmlRegUso += "Si se verifica o sospecha alg�n uso fraudulento y/o " ;
      AV15HtmlRegUso += "malintencionado y/o contrario a estos T�rminos y Condiciones " ;
      AV15HtmlRegUso += "y/o contrarios a la buena fe, THANI tendr� el derecho " ;
      AV15HtmlRegUso += "inapelable de dar por terminado el servicio, no hacer efectiva " ;
      AV15HtmlRegUso += "las promociones, cancelar las transacciones en curso, dar de " ;
      AV15HtmlRegUso += "baja las cuentas y perseguir judicialmente a los infractores.<br><br>" ;
      AV15HtmlRegUso += "THANI podr� realizar los controles que crea convenientes para " ;
      AV15HtmlRegUso += "verificar la veracidad de la informaci�n brindada. En ese " ;
      AV15HtmlRegUso += "sentido, se reserva el derecho de solicitar alg�n comprobante " ;
      AV15HtmlRegUso += "y/o dato adicional a efectos de corroborar los Datos " ;
      AV15HtmlRegUso += "Personales, as� como de suspender temporal o definitivamente " ;
      AV15HtmlRegUso += "a aquellos Usuarios cuyos datos no hayan podido ser " ;
      AV15HtmlRegUso += "confirmados. En caso de suspensi�n temporal, THANI " ;
      AV15HtmlRegUso += "comunicar� al cliente informando el tiempo de suspensi�n de " ;
      AV15HtmlRegUso += "la cuenta. En casos de inhabilitaci�n definitiva THANI podr� dar " ;
      AV15HtmlRegUso += "de baja la cuenta, sin que ello genere derecho alguno a " ;
      AV15HtmlRegUso += "resarcimiento, pago y/o indemnizaci�n.<br><br>" ;
      AV15HtmlRegUso += "El Usuario, una vez registrado, dispondr� de una clave secreta " ;
      AV15HtmlRegUso += " (en adelante \"Clave\") que le permitir� el acceso personalizado, " ;
      AV15HtmlRegUso += "confidencial y seguro. En caso de poseer estos datos, el " ;
      AV15HtmlRegUso += "Usuario tendr� la posibilidad de cambiar la Clave de acceso " ;
      AV15HtmlRegUso += "para lo cual deber� sujetarse al procedimiento establecido en " ;
      AV15HtmlRegUso += "el sitio respectivo. El Usuario se obliga a mantener la " ;
      AV15HtmlRegUso += "confidencialidad de su Clave de acceso, asumiendo totalmente " ;
      AV15HtmlRegUso += "la responsabilidad por el mantenimiento de la confidencialidad " ;
      AV15HtmlRegUso += "de su Clave secreta registrada en este sitio web, la cual le " ;
      AV15HtmlRegUso += "permite solicitar servicios m�dicos en la especialidad y con el " ;
      AV15HtmlRegUso += "doctor o cl�nica de su preferencia; solicitar ex�menes " ;
      AV15HtmlRegUso += "auxiliares, laboratorio y/o farmacia. Dicha Clave es de uso " ;
      AV15HtmlRegUso += "personal, y su entrega a terceros no involucra responsabilidad " ;
      AV15HtmlRegUso += "de THANI en caso de utilizaci�n indebida, negligente y/o " ;
      AV15HtmlRegUso += "incorrecta.<br><br>" ;
      AV15HtmlRegUso += "El Usuario ser� responsable por todas las operaciones " ;
      AV15HtmlRegUso += "efectuadas en y desde su Cuenta, pues el acceso a la misma " ;
      AV15HtmlRegUso += "est� restringido al ingreso y uso de una Clave secreta, de uso " ;
      AV15HtmlRegUso += "y conocimiento exclusivo del Usuario. El Usuario se " ;
      AV15HtmlRegUso += "compromete a notificar a THANI en forma inmediata y por " ;
      AV15HtmlRegUso += "medio id�neo y fehaciente, cualquier uso indebido o no " ;
      AV15HtmlRegUso += "autorizado de su Cuenta y/o Clave, as� como el ingreso por " ;
      AV15HtmlRegUso += "terceros no autorizados a la misma. Se aclara que est� " ;
      AV15HtmlRegUso += "prohibida la venta, cesi�n, pr�stamo o transferencia de la Clave " ;
      AV15HtmlRegUso += "y/o Cuenta bajo ning�n t�tulo.<br><br>" ;
      AV15HtmlRegUso += "THANI se reserva el derecho de rechazar cualquier solicitud de " ;
      AV15HtmlRegUso += "registro o de cancelar un registro previamente aceptado, sin " ;
      AV15HtmlRegUso += "que est� obligado a comunicar o exponer las razones de su " ;
      AV15HtmlRegUso += "decisi�n y sin que ello genere alg�n derecho a indemnizaci�n " ;
      AV15HtmlRegUso += "o resarcimiento.<br><br>" ;
      AV15HtmlRegUso += "El registro del Usuario es personal y no se puede transferir por " ;
      AV15HtmlRegUso += "ning�n motivo a terceras personas. En ese sentido, ning�n " ;
      AV15HtmlRegUso += "usuario podr� vender, intentar vender, ceder o transferir un " ;
      AV15HtmlRegUso += "usuario o contrase�a. Por lo dicho, THANI podr� suspender o " ;
      AV15HtmlRegUso += "cancelar definitivamente una cuenta en el caso de una venta, " ;
      AV15HtmlRegUso += "ofrecimiento de venta, cesi�n o transferencia, en infracci�n de " ;
      AV15HtmlRegUso += "lo dispuesto en el presente p�rrafo.<br><br>" ;
      AV15HtmlRegUso += "El Usuario es informado que en todo momento tendr� derecho " ;
      AV15HtmlRegUso += "a acceder a sus datos personales, rectificarlos, cancelarlos, " ;
      AV15HtmlRegUso += "oponerse, y/o limitar su tratamiento. Asimismo, en cualquier " ;
      AV15HtmlRegUso += "momento, puede revocar el consentimiento brindado. Para el " ;
      AV15HtmlRegUso += "ejercicio de estos derechos, podr� presentar una solicitud con " ;
      AV15HtmlRegUso += "los requisitos exigidos por la normativa de protecci�n de datos " ;
      AV15HtmlRegUso += "personales (Ley N� 29733, y su Reglamento), en cualquiera de " ;
      AV15HtmlRegUso += "los canales de atenci�n previstos en el presente documento. " ;
      AV15HtmlRegUso += "Asimismo, el Usuario ha sido informado que puede presentar " ;
      AV15HtmlRegUso += "un reclamo ante la Autoridad Nacional de Protecci�n de Datos " ;
      AV15HtmlRegUso += "Personales en la Mesa de Partes del Ministerio de Justicia y " ;
      AV15HtmlRegUso += "Derechos Humanos: Calle Scipi�n Llona N� 350, Miraflores, " ;
      AV15HtmlRegUso += "Lima, Per�, de considerar que no ha sido atendido " ;
      AV15HtmlRegUso += "adecuadamente en el ejercicio de sus derechos.<br><br> " ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV15HtmlRegUso );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "3. Modificaciones del acuerdo" );
      AV18ModAcuerdo += "THANI podr� modificar los T�rminos y Condiciones " ;
      AV18ModAcuerdo += "Generales en cualquier momento, haciendo p�blicos en el " ;
      AV18ModAcuerdo += "Sitio los t�rminos modificados. Todos los t�rminos " ;
      AV18ModAcuerdo += "modificados entrar�n en vigencia a los 10 (diez) d�as h�biles " ;
      AV18ModAcuerdo += "despu�s de su publicaci�n. Dentro de los 5 (cinco) d�as " ;
      AV18ModAcuerdo += "h�biles siguientes a la publicaci�n de las modificaciones " ;
      AV18ModAcuerdo += "introducidas, el Usuario se deber� comunicar por e-mail a la " ;
      AV18ModAcuerdo += "siguiente direcci�n: app.thanitech.pe si no acepta las " ;
      AV18ModAcuerdo += "mismas; en ese caso quedar� disuelto el v�nculo contractual " ;
      AV18ModAcuerdo += "y ser� inhabilitado como Usuario. Vencido este plazo, se " ;
      AV18ModAcuerdo += "considerar� que el Usuario acepta los nuevos t�rminos y el " ;
      AV18ModAcuerdo += "contrato continuar� vinculando a ambas partes.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV18ModAcuerdo );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "4. Procedimiento para uso del Sitio de internet y la APP" );
      AV24ProcUsoSitioApp += "En los contratos ofrecidos por medio del Sitio, THANI " ;
      AV24ProcUsoSitioApp += "informar�, de manera inequ�voca y f�cilmente accesible, " ;
      AV24ProcUsoSitioApp += "los pasos que deber�n seguirse para celebrarlos, e " ;
      AV24ProcUsoSitioApp += "informar�, cuando corresponda, si el documento " ;
      AV24ProcUsoSitioApp += "electr�nico en que se formalice el contrato ser� archivado " ;
      AV24ProcUsoSitioApp += "y si �ste ser� accesible al Usuario. El s�lo hecho de seguir " ;
      AV24ProcUsoSitioApp += "los pasos que para tales efectos se indiquen en este sitio " ;
      AV24ProcUsoSitioApp += "para solicitar un servicio, equivale a aceptar que " ;
      AV24ProcUsoSitioApp += "efectivamente ha dado cumplimiento a las condiciones " ;
      AV24ProcUsoSitioApp += "contenidas en este apartado. Indicar�, adem�s, su " ;
      AV24ProcUsoSitioApp += "direcci�n de correo postal o electr�nico y los medios " ;
      AV24ProcUsoSitioApp += "t�cnicos a disposici�n del Usuario para identificar y " ;
      AV24ProcUsoSitioApp += "corregir errores en el env�o o en sus datos.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV24ProcUsoSitioApp );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "5. Medios de pago que se podr�n utilizar en el Sitio web y APP" );
      AV17MediosPagoWA += "Los productos y servicios ofrecidos en el Sitio, ser�n " ;
      AV17MediosPagoWA += "pagados a trav�s de los distintos medios de pago, que se " ;
      AV17MediosPagoWA += "habilitar�n al momento de solicitar el servicio. El uso de " ;
      AV17MediosPagoWA += "tarjetas de cr�ditos o d�bito se sujetar� a lo establecido en " ;
      AV17MediosPagoWA += "estos T�rminos y Condiciones y, en relaci�n con su emisor, " ;
      AV17MediosPagoWA += "a lo pactado en los respectivos Contratos de Apertura y " ;
      AV17MediosPagoWA += "Reglamento de Uso. En caso de contradicci�n, " ;
      AV17MediosPagoWA += "predominar� lo expresado en ese �ltimo instrumento. " ;
      AV17MediosPagoWA += "Trat�ndose de tarjetas bancarias aceptadas en el Sitio, los " ;
      AV17MediosPagoWA += "aspectos relativos a �stas, tales como la fecha de emisi�n, " ;
      AV17MediosPagoWA += "caducidad, cupo, bloqueos, cobros de comisiones, inter�s " ;
      AV17MediosPagoWA += "de compra en cuotas etc., se regir�n por el respectivo " ;
      AV17MediosPagoWA += "Contrato de Apertura y Reglamento de Uso, de tal forma " ;
      AV17MediosPagoWA += "que THANI y los Proveedores no tendr�n responsabilidad " ;
      AV17MediosPagoWA += "por cualquiera de los aspectos se�alados. El Sitio podr� " ;
      AV17MediosPagoWA += "indicar determinadas condiciones de compra seg�n el " ;
      AV17MediosPagoWA += "medio de pago que se utilice por el usuario.<br><br> " ;
      AV17MediosPagoWA += "Ante cualquier sospecha y/o confirmaci�n de pagos no " ;
      AV17MediosPagoWA += "autorizadas THANI cancelar� la solicitud de servicio, de no " ;
      AV17MediosPagoWA += "haberse prestado �sta a�n, y estar� facultado para iniciar " ;
      AV17MediosPagoWA += "acciones judiciales en contra de la persona que haya " ;
      AV17MediosPagoWA += "llevado a cabo la transacci�n sospechosa. Asimismo, " ;
      AV17MediosPagoWA += "THANI podr� en los t�rminos de la ley, entregar la " ;
      AV17MediosPagoWA += "informaci�n personal de quien haya realizado la " ;
      AV17MediosPagoWA += "transacci�n sospechosa a los tarjetahabientes afectados.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV17MediosPagoWA );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "6. Formaci�n del consentimiento en los contratos celebrados a trav�s de este Sitio" );
      AV12FormConContratos += "A trav�s del Sitio web y la aplicaci�n THANI las " ;
      AV12FormConContratos += "empresas proveedoras o el proveedor realizar�n ofertas " ;
      AV12FormConContratos += "de servicios que podr�n ser vinculantes para las Partes, " ;
      AV12FormConContratos += "a trav�s de la aceptaci�n del Usuario por v�a electr�nica " ;
      AV12FormConContratos += "y utilizando los mecanismos que el mismo Sitio ofrece " ;
      AV12FormConContratos += "para ello.<br><br> " ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV12FormConContratos );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "7. Plazo de validez de la tarifa" );
      AV22PlazoValidezTar += "Las tarifas y/o honorarios de los servicios disponibles en el " ;
      AV22PlazoValidezTar += "Sitio, mientras aparezcan como disponibles, solo tendr�n " ;
      AV22PlazoValidezTar += "vigencia y aplicaci�n en �ste y no ser�n aplicables a otros " ;
      AV22PlazoValidezTar += "canales de prestaci�n de servicios utilizados por las " ;
      AV22PlazoValidezTar += "empresas proveedoras. Las tarifas de los servicios " ;
      AV22PlazoValidezTar += "ofrecidos en el Sitio est�n expresadas en Soles o su " ;
      AV22PlazoValidezTar += "conversi�n en moneda extranjera si fuera el caso.<br><br>" ;
      AV22PlazoValidezTar += "Las empresas proveedoras podr�n modificar cualquier " ;
      AV22PlazoValidezTar += "informaci�n contenida en este Sitio, raz�n por la cual se " ;
      AV22PlazoValidezTar += "sugiere verificar el detalle del servicio siempre antes de " ;
      AV22PlazoValidezTar += "proceder a la solicitud. <br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV22PlazoValidezTar );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "8. Prestaci�n del servicio" );
      AV23PrestamoServico += "THANI pone a disposici�n del usuario debidamente " ;
      AV23PrestamoServico += "registrado, la posibilidad de solicitar servicios con las " ;
      AV23PrestamoServico += "empresas o proveedores que previamente se encuentran " ;
      AV23PrestamoServico += "registrados como Empresas Proveedoras o Proveedores " ;
      AV23PrestamoServico += "del servicio. Asimismo, pondr� a disposici�n los servicios " ;
      AV23PrestamoServico += "auxiliares, de laboratorio y/o farmacia que ah� se indiquen.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV23PrestamoServico );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "9. Responsabilidad de THANI" );
      AV26ResposabilidadTani += "THANI s�lo es responsable del correcto " ;
      AV26ResposabilidadTani += "funcionamiento de la plataforma y APP mediante la " ;
      AV26ResposabilidadTani += "cual se realiza la solicitud del servicio.<br><br>" ;
      AV26ResposabilidadTani += "THANI har� lo posible dentro de sus capacidades para " ;
      AV26ResposabilidadTani += "que la transmisi�n del Sitio sea ininterrumpida y libre " ;
      AV26ResposabilidadTani += "de errores. Sin embargo, dada la naturaleza del " ;
      AV26ResposabilidadTani += "servicio de Internet, dichas condiciones no pueden ser " ;
      AV26ResposabilidadTani += "garantizadas. En el mismo sentido, el acceso del " ;
      AV26ResposabilidadTani += "Usuario puede ser ocasionalmente restringido o " ;
      AV26ResposabilidadTani += "suspendido con el objeto de efectuar reparaciones, " ;
      AV26ResposabilidadTani += "mantenimiento o introducir nuevos Servicios o " ;
      AV26ResposabilidadTani += "Proveedores. THANI no ser� responsable por p�rdidas " ;
      AV26ResposabilidadTani += " (i) que no hayan sido causadas por el incumplimiento " ;
      AV26ResposabilidadTani += "de sus obligaciones; (ii) lucro cesante; (iii) cualquier " ;
      AV26ResposabilidadTani += "da�o indirecto.<br><br>" ;
      AV26ResposabilidadTani += "El servicio de consulta m�dica, es prestado por las " ;
      AV26ResposabilidadTani += "empresas proveedoras o proveedores del servicio; " ;
      AV26ResposabilidadTani += "quienes han manifestado ser m�dicos debidamente " ;
      AV26ResposabilidadTani += "registrados en el Colegio M�dico del Per�, y poseen las " ;
      AV26ResposabilidadTani += "especialidades que ah� se indican.<br><br>" ;
      AV26ResposabilidadTani += "Por tanto, el Usuario declara conocer, que en caso se " ;
      AV26ResposabilidadTani += "encuentre en desacuerdo con alg�n aspecto de la " ;
      AV26ResposabilidadTani += "atenci�n brindada, deber� realizar el reclamo " ;
      AV26ResposabilidadTani += "directamente al Proveedor o Empresa Proveedora del servicio.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV26ResposabilidadTani );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "10. Propiedad Intelectual" );
      AV25PropiedadIntelectual += "THANI est� protegido por los derechos de propiedad " ;
      AV25PropiedadIntelectual += "de autor. Todos los derechos involucrados como por " ;
      AV25PropiedadIntelectual += "ejemplo el contenido, el dise�o visual, logos y eslogan " ;
      AV25PropiedadIntelectual += "que forman parte del contenido y servicios, pertenecen " ;
      AV25PropiedadIntelectual += "a THANI. En base a ello, se proh�be utilizar, codificar, " ;
      AV25PropiedadIntelectual += "copiar, distribuir, transmitir o comercializar los " ;
      AV25PropiedadIntelectual += "derechos involucrados sin el permiso expreso por escrito.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV25PropiedadIntelectual );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "11. T�rminos de Ley" );
      AV31TerminoLey += "Este acuerdo ser� gobernado e interpretado de acuerdo con " ;
      AV31TerminoLey += "las leyes de Per�, sin dar efecto a cualquier principio de " ;
      AV31TerminoLey += "conflictos de ley. Si alguna disposici�n de estos T�rminos y " ;
      AV31TerminoLey += "Condiciones es declarada ilegal, o presenta un vac�o, o por " ;
      AV31TerminoLey += "cualquier raz�n resulta inaplicable, la misma deber� ser " ;
      AV31TerminoLey += "interpretada dentro del marco del mismo y en cualquier caso no " ;
      AV31TerminoLey += "afectar� la validez y la aplicabilidad de las cl�usulas restantes.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV31TerminoLey );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "12. Notificaciones" );
      AV21Notificaciones += "Cualquier comentario, inquietud o reclamaci�n respecto de " ;
      AV21Notificaciones += "los anteriores T�rminos y Condiciones, la Pol�tica de " ;
      AV21Notificaciones += "Privacidad, o la ejecuci�n de cualquiera de �stos, deber� ser " ;
      AV21Notificaciones += "notificada por escrito a THANI.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV21Notificaciones );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "13. Jurisdicci�n y Ley Aplicable" );
      AV16JurisdiccionLeyAp += "Este acuerdo estar� regido en todos sus puntos por las " ;
      AV16JurisdiccionLeyAp += "leyes vigentes en la Rep�blica del Per�.<br><br>" ;
      AV16JurisdiccionLeyAp += "Cualquier controversia derivada del presente acuerdo, su " ;
      AV16JurisdiccionLeyAp += "existencia, validez, interpretaci�n, alcance o " ;
      AV16JurisdiccionLeyAp += "cumplimiento, ser� sometida a los tribunales competentes de la ciudad de Lima, Per�.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV16JurisdiccionLeyAp );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV29TCUserList.add(AV28TCUserItem, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcterminoscondicionesuser.this.AV29TCUserList;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29TCUserList = new GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones>(com.projectthani.SdtSDTTerminosCondiciones.class, "SDTTerminosCondiciones", "ProjectThani", remoteHandle);
      AV32TituloDoc = "" ;
      AV20NombreEmpresa = "" ;
      AV19NombreComercial = "" ;
      AV27RucEmpresa = "" ;
      AV9DireccionEmpresa = "" ;
      AV10DominioPlataforma = "" ;
      AV11EmailEmpresa = "" ;
      AV28TCUserItem = new com.projectthani.SdtSDTTerminosCondiciones(remoteHandle, context);
      AV14HtmGeneral = "" ;
      AV30TCUserSubItem = new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV13HtmCapLegal = "" ;
      AV15HtmlRegUso = "" ;
      AV18ModAcuerdo = "" ;
      AV24ProcUsoSitioApp = "" ;
      AV17MediosPagoWA = "" ;
      AV12FormConContratos = "" ;
      AV22PlazoValidezTar = "" ;
      AV23PrestamoServico = "" ;
      AV26ResposabilidadTani = "" ;
      AV25PropiedadIntelectual = "" ;
      AV31TerminoLey = "" ;
      AV21Notificaciones = "" ;
      AV16JurisdiccionLeyAp = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV14HtmGeneral ;
   private String AV13HtmCapLegal ;
   private String AV15HtmlRegUso ;
   private String AV18ModAcuerdo ;
   private String AV24ProcUsoSitioApp ;
   private String AV17MediosPagoWA ;
   private String AV12FormConContratos ;
   private String AV22PlazoValidezTar ;
   private String AV23PrestamoServico ;
   private String AV26ResposabilidadTani ;
   private String AV25PropiedadIntelectual ;
   private String AV31TerminoLey ;
   private String AV21Notificaciones ;
   private String AV16JurisdiccionLeyAp ;
   private String AV32TituloDoc ;
   private String AV20NombreEmpresa ;
   private String AV19NombreComercial ;
   private String AV27RucEmpresa ;
   private String AV9DireccionEmpresa ;
   private String AV10DominioPlataforma ;
   private String AV11EmailEmpresa ;
   private GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTTerminosCondiciones> AV29TCUserList ;
   private com.projectthani.SdtSDTTerminosCondiciones AV28TCUserItem ;
   private com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem AV30TCUserSubItem ;
}

