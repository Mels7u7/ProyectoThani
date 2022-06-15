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
      AV32TituloDoc = "TÉRMINOS Y CONDICIONES GENERALES" ;
      AV20NombreEmpresa = "DESARROLLO DE PLATAFORMAS Y SERVICIOS DIGITALES S.A.C" ;
      AV19NombreComercial = "THANI" ;
      AV27RucEmpresa = "20606936134" ;
      AV9DireccionEmpresa = "Jirón Fermín Tanguis N°145 Dpto 501 Urb. Santa Catalina, distrito de La Victoria." ;
      AV10DominioPlataforma = "app.thanitech.pe" ;
      AV11EmailEmpresa = "soporte@thanitech.pe" ;
      AV28TCUserItem = (com.projectthani.SdtSDTTerminosCondiciones)new com.projectthani.SdtSDTTerminosCondiciones(remoteHandle, context);
      AV28TCUserItem.setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionestitulo( AV32TituloDoc );
      AV14HtmGeneral += AV20NombreEmpresa + " (en adelante usaremos el nombre comercial: “" ;
      AV14HtmGeneral += AV19NombreComercial + "”) es una sociedad debidamente inscrita en el" ;
      AV14HtmGeneral += "registro de personas jurídicas de Lima y Callao, identificada " ;
      AV14HtmGeneral += "con RUC N° " + AV27RucEmpresa + ", siendo su domicilio fiscal en " ;
      AV14HtmGeneral += AV9DireccionEmpresa + " Asimismo, " + AV19NombreComercial + " es un proveedor " ;
      AV14HtmGeneral += "de sitio web, mediante el cual los Usuarios que se registren " ;
      AV14HtmGeneral += "podrán solicitar y agendar consultas con médicos y/o Clínicas " ;
      AV14HtmGeneral += "previamente inscritos de las especialidades que se indiquen, " ;
      AV14HtmGeneral += "las mismas que se llevarán a cabo de manera virtual y/o presencial. " ;
      AV14HtmGeneral += "Asimismo, se podrá agendar o solicitar exámenes auxiliares, " ;
      AV14HtmGeneral += "de laboratorio y/o farmacia.<br><br>" ;
      AV14HtmGeneral += "Este documento describe los términos y condiciones generales " ;
      AV14HtmGeneral += "(los \"Términos y Condiciones Generales\") aplicables al acceso y " ;
      AV14HtmGeneral += "uso de los servicios ofrecidos por " + AV19NombreComercial + " (\"los Servicios\") " ;
      AV14HtmGeneral += "dentro del sitio " + AV10DominioPlataforma + "” y/o una aplicación móvil " ;
      AV14HtmGeneral += "denominada “" + AV19NombreComercial + "”, las cuales, en adelante, denominaremos " ;
      AV14HtmGeneral += "en su conjunto como “LAS APLICACIONES”, en donde estos Términos " ;
      AV14HtmGeneral += "y Condiciones se encuentren. Cualquier persona que desee acceder " ;
      AV14HtmGeneral += "y/o suscribirse y/o usar el Sitio o los Servicios podrá hacerlo" ;
      AV14HtmGeneral += "sujetándose a los Términos y Condiciones Generales y las " ;
      AV14HtmGeneral += "Políticas de Privacidad, junto con todas las demás políticas " ;
      AV14HtmGeneral += "y principios que rigen " + AV10DominioPlataforma + " y la aplicación " + AV19NombreComercial + ". " ;
      AV14HtmGeneral += "En consecuencia, todas las visitas y todos los contratos y " ;
      AV14HtmGeneral += "transacciones que se realicen en este Sitio, así como sus efectos " ;
      AV14HtmGeneral += "jurídicos, quedarán regidos por estas reglas y sometidos a la " ;
      AV14HtmGeneral += "legislación aplicable en Perú.<br><br>" ;
      AV14HtmGeneral += "Los Términos y Condiciones contenidos en este instrumento se " ;
      AV14HtmGeneral += "aplicarán y se entenderán como parte integral de todos los " ;
      AV14HtmGeneral += "actos y contratos que se ejecuten o celebren mediante los " ;
      AV14HtmGeneral += "sistemas de oferta y prestación del servicio comprendidos en " ;
      AV14HtmGeneral += "este sitio entre los usuarios de este sitio y " + AV19NombreComercial + ", y por " ;
      AV14HtmGeneral += "cualquiera de las otras sociedades o personas que hagan uso " ;
      AV14HtmGeneral += "de este sitio, a las cuales se las denominará en adelante " ;
      AV14HtmGeneral += "también en forma indistinta como el \"Proveedor\" o la \"Empresa " ;
      AV14HtmGeneral += "Proveedora\", según convenga al sentido del texto.<br><br>" ;
      AV14HtmGeneral += "En caso que las Empresas proveedoras o el proveedor " ;
      AV14HtmGeneral += "hubieran fijado sus propios Términos y Condiciones y sus " ;
      AV14HtmGeneral += "Políticas de Privacidad para los actos y contratos que realicen " ;
      AV14HtmGeneral += "en este sitio, ellas aparecerán en esta página señalada con un " ;
      AV14HtmGeneral += "link o indicada como parte de la promoción de sus ofertas y " ;
      AV14HtmGeneral += "promociones y prevalecerán sobre éstas.<br><br> " ;
      AV14HtmGeneral += "CUALQUIER PERSONA QUE NO ACEPTE ESTOS " ;
      AV14HtmGeneral += "TÉRMINOS Y CONDICIONES GENERALES Y LAS " ;
      AV14HtmGeneral += "POLÍTICAS DE PRIVACIDAD, LOS CUALES TIENEN UN " ;
      AV14HtmGeneral += "CARÁCTER OBLIGATORIO Y VINCULANTE, DEBERÁ " ;
      AV14HtmGeneral += "ABSTENERSE DE UTILIZAR EL SITIO Y/O LOS SERVICIOS.<br><br>" ;
      AV14HtmGeneral += "El Usuario debe leer, entender y aceptar todas las condiciones " ;
      AV14HtmGeneral += "establecidas en los Términos y Condiciones Generales y en las " ;
      AV14HtmGeneral += "Políticas de Privacidad de " + AV19NombreComercial + ", así como en los demás " ;
      AV14HtmGeneral += "documentos incorporados a los mismos por referencia, previo " ;
      AV14HtmGeneral += "a su registro como Usuario de la página web app.thanitech.pe o en la " ;
      AV14HtmGeneral += "aplicación " + AV19NombreComercial + " quedando sujetos a lo señalado y dispuesto " ;
      AV14HtmGeneral += "en los Términos y Condiciones.<br><br>" ;
      AV14HtmGeneral += "Cuando usted visita o accede a la página web o a la aplicación " ;
      AV14HtmGeneral += "" + AV19NombreComercial + " se está comunicando con " + AV19NombreComercial + " de manera " ;
      AV14HtmGeneral += "electrónica. En ese sentido, usted brinda su consentimiento " ;
      AV14HtmGeneral += "para recibir comunicaciones de " + AV19NombreComercial + " por correo electrónico o " ;
      AV14HtmGeneral += "mediante la publicación de avisos en su portal.<br><br>" ;
      AV28TCUserItem.setgxTv_SdtSDTTerminosCondiciones_Terminoscondicionesdescripcion( AV14HtmGeneral );
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "1. Capacidad legal" );
      AV13HtmCapLegal += "Los Servicios sólo están disponibles para personas que " ;
      AV13HtmCapLegal += "tengan capacidad legal para contratar. No podrán utilizar los " ;
      AV13HtmCapLegal += "servicios las personas que no tengan esa capacidad tales " ;
      AV13HtmCapLegal += "como: menores de edad o Usuarios que hayan sido " ;
      AV13HtmCapLegal += "suspendidos temporalmente o inhabilitados definitivamente " ;
      AV13HtmCapLegal += "en razón de lo dispuesto en la sección 2 “Registro y Uso del " ;
      AV13HtmCapLegal += "Sitio”. Los actos que los menores realicen en este sitio serán " ;
      AV13HtmCapLegal += "responsabilidad de sus padres, tutores, encargados o " ;
      AV13HtmCapLegal += "curadores, y por tanto se considerarán realizados por éstos " ;
      AV13HtmCapLegal += "en ejercicio de la representación legal con la que cuentan.<br><br>" ;
      AV13HtmCapLegal += "Quien registre un Usuario como empresa afirmará que (i) " ;
      AV13HtmCapLegal += "cuenta con capacidad para contratar en representación de tal " ;
      AV13HtmCapLegal += "entidad y de obligar a la misma en los términos de este " ;
      AV13HtmCapLegal += "Acuerdo, (ii) la dirección señalada en el registro es el domicilio " ;
      AV13HtmCapLegal += "principal Legal y/o Fiscal de dicha entidad, y (iii) cualquier otra " ;
      AV13HtmCapLegal += "información presentada a La empresa es verdadera, precisa, " ;
      AV13HtmCapLegal += "actualizada, completa y oportuna.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV13HtmCapLegal );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "2. Registro y uso del Sitio" );
      AV15HtmlRegUso += "Es obligatorio completar el formulario de registro en todos sus " ;
      AV15HtmlRegUso += "campos con datos válidos y verdaderos para convertirse en " ;
      AV15HtmlRegUso += "Usuario autorizado de THANI (el \"Usuario\"), de esta manera, " ;
      AV15HtmlRegUso += "podrá acceder a las promociones y servicios ofrecidos en este " ;
      AV15HtmlRegUso += "sitio. El futuro Usuario deberá completar el formulario de " ;
      AV15HtmlRegUso += "registro con su información personal de manera exacta, precisa " ;
      AV15HtmlRegUso += "y verdadera (\"Datos Personales\") y asume el compromiso de " ;
      AV15HtmlRegUso += "actualizar los Datos Personales conforme resulte necesario. " ;
      AV15HtmlRegUso += "THANI podrá utilizar diversos medios para identificar a sus " ;
      AV15HtmlRegUso += "Miembros, pero NO se responsabiliza por la certeza de los " ;
      AV15HtmlRegUso += "Datos Personales provistos por sus Usuarios. Los Usuarios " ;
      AV15HtmlRegUso += "garantizan y responden, en cualquier caso, de la exactitud, " ;
      AV15HtmlRegUso += "veracidad, vigencia y autenticidad de los Datos Personales " ;
      AV15HtmlRegUso += "ingresados. Por tanto, la declaración realizada por los Usuarios " ;
      AV15HtmlRegUso += "al momento de registrarse se entenderá como una Declaración " ;
      AV15HtmlRegUso += "Jurada.<br><br>" ;
      AV15HtmlRegUso += "Cada persona natural sólo podrá ser titular de una (1) cuenta, " ;
      AV15HtmlRegUso += "no pudiendo acceder a más de una (1) cuenta con distintas " ;
      AV15HtmlRegUso += "direcciones de correo electrónico o falseando, modificando y/o " ;
      AV15HtmlRegUso += "alterando sus datos personales de cualquier manera posible. " ;
      AV15HtmlRegUso += "En caso se detecte esta infracción, THANI se comunicará con " ;
      AV15HtmlRegUso += "el usuario informándole que todas sus cuentas serán " ;
      AV15HtmlRegUso += "agrupadas en una sola cuenta anulándose las adicionales, ello " ;
      AV15HtmlRegUso += "se informara al usuario mediante correo electrónico indicado " ;
      AV15HtmlRegUso += "por él mismo o el último registrado.<br><br>" ;
      AV15HtmlRegUso += "Si se verifica o sospecha algún uso fraudulento y/o " ;
      AV15HtmlRegUso += "malintencionado y/o contrario a estos Términos y Condiciones " ;
      AV15HtmlRegUso += "y/o contrarios a la buena fe, THANI tendrá el derecho " ;
      AV15HtmlRegUso += "inapelable de dar por terminado el servicio, no hacer efectiva " ;
      AV15HtmlRegUso += "las promociones, cancelar las transacciones en curso, dar de " ;
      AV15HtmlRegUso += "baja las cuentas y perseguir judicialmente a los infractores.<br><br>" ;
      AV15HtmlRegUso += "THANI podrá realizar los controles que crea convenientes para " ;
      AV15HtmlRegUso += "verificar la veracidad de la información brindada. En ese " ;
      AV15HtmlRegUso += "sentido, se reserva el derecho de solicitar algún comprobante " ;
      AV15HtmlRegUso += "y/o dato adicional a efectos de corroborar los Datos " ;
      AV15HtmlRegUso += "Personales, así como de suspender temporal o definitivamente " ;
      AV15HtmlRegUso += "a aquellos Usuarios cuyos datos no hayan podido ser " ;
      AV15HtmlRegUso += "confirmados. En caso de suspensión temporal, THANI " ;
      AV15HtmlRegUso += "comunicará al cliente informando el tiempo de suspensión de " ;
      AV15HtmlRegUso += "la cuenta. En casos de inhabilitación definitiva THANI podrá dar " ;
      AV15HtmlRegUso += "de baja la cuenta, sin que ello genere derecho alguno a " ;
      AV15HtmlRegUso += "resarcimiento, pago y/o indemnización.<br><br>" ;
      AV15HtmlRegUso += "El Usuario, una vez registrado, dispondrá de una clave secreta " ;
      AV15HtmlRegUso += " (en adelante \"Clave\") que le permitirá el acceso personalizado, " ;
      AV15HtmlRegUso += "confidencial y seguro. En caso de poseer estos datos, el " ;
      AV15HtmlRegUso += "Usuario tendrá la posibilidad de cambiar la Clave de acceso " ;
      AV15HtmlRegUso += "para lo cual deberá sujetarse al procedimiento establecido en " ;
      AV15HtmlRegUso += "el sitio respectivo. El Usuario se obliga a mantener la " ;
      AV15HtmlRegUso += "confidencialidad de su Clave de acceso, asumiendo totalmente " ;
      AV15HtmlRegUso += "la responsabilidad por el mantenimiento de la confidencialidad " ;
      AV15HtmlRegUso += "de su Clave secreta registrada en este sitio web, la cual le " ;
      AV15HtmlRegUso += "permite solicitar servicios médicos en la especialidad y con el " ;
      AV15HtmlRegUso += "doctor o clínica de su preferencia; solicitar exámenes " ;
      AV15HtmlRegUso += "auxiliares, laboratorio y/o farmacia. Dicha Clave es de uso " ;
      AV15HtmlRegUso += "personal, y su entrega a terceros no involucra responsabilidad " ;
      AV15HtmlRegUso += "de THANI en caso de utilización indebida, negligente y/o " ;
      AV15HtmlRegUso += "incorrecta.<br><br>" ;
      AV15HtmlRegUso += "El Usuario será responsable por todas las operaciones " ;
      AV15HtmlRegUso += "efectuadas en y desde su Cuenta, pues el acceso a la misma " ;
      AV15HtmlRegUso += "está restringido al ingreso y uso de una Clave secreta, de uso " ;
      AV15HtmlRegUso += "y conocimiento exclusivo del Usuario. El Usuario se " ;
      AV15HtmlRegUso += "compromete a notificar a THANI en forma inmediata y por " ;
      AV15HtmlRegUso += "medio idóneo y fehaciente, cualquier uso indebido o no " ;
      AV15HtmlRegUso += "autorizado de su Cuenta y/o Clave, así como el ingreso por " ;
      AV15HtmlRegUso += "terceros no autorizados a la misma. Se aclara que está " ;
      AV15HtmlRegUso += "prohibida la venta, cesión, préstamo o transferencia de la Clave " ;
      AV15HtmlRegUso += "y/o Cuenta bajo ningún título.<br><br>" ;
      AV15HtmlRegUso += "THANI se reserva el derecho de rechazar cualquier solicitud de " ;
      AV15HtmlRegUso += "registro o de cancelar un registro previamente aceptado, sin " ;
      AV15HtmlRegUso += "que esté obligado a comunicar o exponer las razones de su " ;
      AV15HtmlRegUso += "decisión y sin que ello genere algún derecho a indemnización " ;
      AV15HtmlRegUso += "o resarcimiento.<br><br>" ;
      AV15HtmlRegUso += "El registro del Usuario es personal y no se puede transferir por " ;
      AV15HtmlRegUso += "ningún motivo a terceras personas. En ese sentido, ningún " ;
      AV15HtmlRegUso += "usuario podrá vender, intentar vender, ceder o transferir un " ;
      AV15HtmlRegUso += "usuario o contraseña. Por lo dicho, THANI podrá suspender o " ;
      AV15HtmlRegUso += "cancelar definitivamente una cuenta en el caso de una venta, " ;
      AV15HtmlRegUso += "ofrecimiento de venta, cesión o transferencia, en infracción de " ;
      AV15HtmlRegUso += "lo dispuesto en el presente párrafo.<br><br>" ;
      AV15HtmlRegUso += "El Usuario es informado que en todo momento tendrá derecho " ;
      AV15HtmlRegUso += "a acceder a sus datos personales, rectificarlos, cancelarlos, " ;
      AV15HtmlRegUso += "oponerse, y/o limitar su tratamiento. Asimismo, en cualquier " ;
      AV15HtmlRegUso += "momento, puede revocar el consentimiento brindado. Para el " ;
      AV15HtmlRegUso += "ejercicio de estos derechos, podrá presentar una solicitud con " ;
      AV15HtmlRegUso += "los requisitos exigidos por la normativa de protección de datos " ;
      AV15HtmlRegUso += "personales (Ley N° 29733, y su Reglamento), en cualquiera de " ;
      AV15HtmlRegUso += "los canales de atención previstos en el presente documento. " ;
      AV15HtmlRegUso += "Asimismo, el Usuario ha sido informado que puede presentar " ;
      AV15HtmlRegUso += "un reclamo ante la Autoridad Nacional de Protección de Datos " ;
      AV15HtmlRegUso += "Personales en la Mesa de Partes del Ministerio de Justicia y " ;
      AV15HtmlRegUso += "Derechos Humanos: Calle Scipión Llona N° 350, Miraflores, " ;
      AV15HtmlRegUso += "Lima, Perú, de considerar que no ha sido atendido " ;
      AV15HtmlRegUso += "adecuadamente en el ejercicio de sus derechos.<br><br> " ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV15HtmlRegUso );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "3. Modificaciones del acuerdo" );
      AV18ModAcuerdo += "THANI podrá modificar los Términos y Condiciones " ;
      AV18ModAcuerdo += "Generales en cualquier momento, haciendo públicos en el " ;
      AV18ModAcuerdo += "Sitio los términos modificados. Todos los términos " ;
      AV18ModAcuerdo += "modificados entrarán en vigencia a los 10 (diez) días hábiles " ;
      AV18ModAcuerdo += "después de su publicación. Dentro de los 5 (cinco) días " ;
      AV18ModAcuerdo += "hábiles siguientes a la publicación de las modificaciones " ;
      AV18ModAcuerdo += "introducidas, el Usuario se deberá comunicar por e-mail a la " ;
      AV18ModAcuerdo += "siguiente dirección: app.thanitech.pe si no acepta las " ;
      AV18ModAcuerdo += "mismas; en ese caso quedará disuelto el vínculo contractual " ;
      AV18ModAcuerdo += "y será inhabilitado como Usuario. Vencido este plazo, se " ;
      AV18ModAcuerdo += "considerará que el Usuario acepta los nuevos términos y el " ;
      AV18ModAcuerdo += "contrato continuará vinculando a ambas partes.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV18ModAcuerdo );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "4. Procedimiento para uso del Sitio de internet y la APP" );
      AV24ProcUsoSitioApp += "En los contratos ofrecidos por medio del Sitio, THANI " ;
      AV24ProcUsoSitioApp += "informará, de manera inequívoca y fácilmente accesible, " ;
      AV24ProcUsoSitioApp += "los pasos que deberán seguirse para celebrarlos, e " ;
      AV24ProcUsoSitioApp += "informará, cuando corresponda, si el documento " ;
      AV24ProcUsoSitioApp += "electrónico en que se formalice el contrato será archivado " ;
      AV24ProcUsoSitioApp += "y si éste será accesible al Usuario. El sólo hecho de seguir " ;
      AV24ProcUsoSitioApp += "los pasos que para tales efectos se indiquen en este sitio " ;
      AV24ProcUsoSitioApp += "para solicitar un servicio, equivale a aceptar que " ;
      AV24ProcUsoSitioApp += "efectivamente ha dado cumplimiento a las condiciones " ;
      AV24ProcUsoSitioApp += "contenidas en este apartado. Indicará, además, su " ;
      AV24ProcUsoSitioApp += "dirección de correo postal o electrónico y los medios " ;
      AV24ProcUsoSitioApp += "técnicos a disposición del Usuario para identificar y " ;
      AV24ProcUsoSitioApp += "corregir errores en el envío o en sus datos.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV24ProcUsoSitioApp );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "5. Medios de pago que se podrán utilizar en el Sitio web y APP" );
      AV17MediosPagoWA += "Los productos y servicios ofrecidos en el Sitio, serán " ;
      AV17MediosPagoWA += "pagados a través de los distintos medios de pago, que se " ;
      AV17MediosPagoWA += "habilitarán al momento de solicitar el servicio. El uso de " ;
      AV17MediosPagoWA += "tarjetas de créditos o débito se sujetará a lo establecido en " ;
      AV17MediosPagoWA += "estos Términos y Condiciones y, en relación con su emisor, " ;
      AV17MediosPagoWA += "a lo pactado en los respectivos Contratos de Apertura y " ;
      AV17MediosPagoWA += "Reglamento de Uso. En caso de contradicción, " ;
      AV17MediosPagoWA += "predominará lo expresado en ese último instrumento. " ;
      AV17MediosPagoWA += "Tratándose de tarjetas bancarias aceptadas en el Sitio, los " ;
      AV17MediosPagoWA += "aspectos relativos a éstas, tales como la fecha de emisión, " ;
      AV17MediosPagoWA += "caducidad, cupo, bloqueos, cobros de comisiones, interés " ;
      AV17MediosPagoWA += "de compra en cuotas etc., se regirán por el respectivo " ;
      AV17MediosPagoWA += "Contrato de Apertura y Reglamento de Uso, de tal forma " ;
      AV17MediosPagoWA += "que THANI y los Proveedores no tendrán responsabilidad " ;
      AV17MediosPagoWA += "por cualquiera de los aspectos señalados. El Sitio podrá " ;
      AV17MediosPagoWA += "indicar determinadas condiciones de compra según el " ;
      AV17MediosPagoWA += "medio de pago que se utilice por el usuario.<br><br> " ;
      AV17MediosPagoWA += "Ante cualquier sospecha y/o confirmación de pagos no " ;
      AV17MediosPagoWA += "autorizadas THANI cancelará la solicitud de servicio, de no " ;
      AV17MediosPagoWA += "haberse prestado ésta aún, y estará facultado para iniciar " ;
      AV17MediosPagoWA += "acciones judiciales en contra de la persona que haya " ;
      AV17MediosPagoWA += "llevado a cabo la transacción sospechosa. Asimismo, " ;
      AV17MediosPagoWA += "THANI podrá en los términos de la ley, entregar la " ;
      AV17MediosPagoWA += "información personal de quien haya realizado la " ;
      AV17MediosPagoWA += "transacción sospechosa a los tarjetahabientes afectados.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV17MediosPagoWA );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "6. Formación del consentimiento en los contratos celebrados a través de este Sitio" );
      AV12FormConContratos += "A través del Sitio web y la aplicación THANI las " ;
      AV12FormConContratos += "empresas proveedoras o el proveedor realizarán ofertas " ;
      AV12FormConContratos += "de servicios que podrán ser vinculantes para las Partes, " ;
      AV12FormConContratos += "a través de la aceptación del Usuario por vía electrónica " ;
      AV12FormConContratos += "y utilizando los mecanismos que el mismo Sitio ofrece " ;
      AV12FormConContratos += "para ello.<br><br> " ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV12FormConContratos );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "7. Plazo de validez de la tarifa" );
      AV22PlazoValidezTar += "Las tarifas y/o honorarios de los servicios disponibles en el " ;
      AV22PlazoValidezTar += "Sitio, mientras aparezcan como disponibles, solo tendrán " ;
      AV22PlazoValidezTar += "vigencia y aplicación en éste y no serán aplicables a otros " ;
      AV22PlazoValidezTar += "canales de prestación de servicios utilizados por las " ;
      AV22PlazoValidezTar += "empresas proveedoras. Las tarifas de los servicios " ;
      AV22PlazoValidezTar += "ofrecidos en el Sitio están expresadas en Soles o su " ;
      AV22PlazoValidezTar += "conversión en moneda extranjera si fuera el caso.<br><br>" ;
      AV22PlazoValidezTar += "Las empresas proveedoras podrán modificar cualquier " ;
      AV22PlazoValidezTar += "información contenida en este Sitio, razón por la cual se " ;
      AV22PlazoValidezTar += "sugiere verificar el detalle del servicio siempre antes de " ;
      AV22PlazoValidezTar += "proceder a la solicitud. <br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV22PlazoValidezTar );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "8. Prestación del servicio" );
      AV23PrestamoServico += "THANI pone a disposición del usuario debidamente " ;
      AV23PrestamoServico += "registrado, la posibilidad de solicitar servicios con las " ;
      AV23PrestamoServico += "empresas o proveedores que previamente se encuentran " ;
      AV23PrestamoServico += "registrados como Empresas Proveedoras o Proveedores " ;
      AV23PrestamoServico += "del servicio. Asimismo, pondrá a disposición los servicios " ;
      AV23PrestamoServico += "auxiliares, de laboratorio y/o farmacia que ahí se indiquen.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV23PrestamoServico );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "9. Responsabilidad de THANI" );
      AV26ResposabilidadTani += "THANI sólo es responsable del correcto " ;
      AV26ResposabilidadTani += "funcionamiento de la plataforma y APP mediante la " ;
      AV26ResposabilidadTani += "cual se realiza la solicitud del servicio.<br><br>" ;
      AV26ResposabilidadTani += "THANI hará lo posible dentro de sus capacidades para " ;
      AV26ResposabilidadTani += "que la transmisión del Sitio sea ininterrumpida y libre " ;
      AV26ResposabilidadTani += "de errores. Sin embargo, dada la naturaleza del " ;
      AV26ResposabilidadTani += "servicio de Internet, dichas condiciones no pueden ser " ;
      AV26ResposabilidadTani += "garantizadas. En el mismo sentido, el acceso del " ;
      AV26ResposabilidadTani += "Usuario puede ser ocasionalmente restringido o " ;
      AV26ResposabilidadTani += "suspendido con el objeto de efectuar reparaciones, " ;
      AV26ResposabilidadTani += "mantenimiento o introducir nuevos Servicios o " ;
      AV26ResposabilidadTani += "Proveedores. THANI no será responsable por pérdidas " ;
      AV26ResposabilidadTani += " (i) que no hayan sido causadas por el incumplimiento " ;
      AV26ResposabilidadTani += "de sus obligaciones; (ii) lucro cesante; (iii) cualquier " ;
      AV26ResposabilidadTani += "daño indirecto.<br><br>" ;
      AV26ResposabilidadTani += "El servicio de consulta médica, es prestado por las " ;
      AV26ResposabilidadTani += "empresas proveedoras o proveedores del servicio; " ;
      AV26ResposabilidadTani += "quienes han manifestado ser médicos debidamente " ;
      AV26ResposabilidadTani += "registrados en el Colegio Médico del Perú, y poseen las " ;
      AV26ResposabilidadTani += "especialidades que ahí se indican.<br><br>" ;
      AV26ResposabilidadTani += "Por tanto, el Usuario declara conocer, que en caso se " ;
      AV26ResposabilidadTani += "encuentre en desacuerdo con algún aspecto de la " ;
      AV26ResposabilidadTani += "atención brindada, deberá realizar el reclamo " ;
      AV26ResposabilidadTani += "directamente al Proveedor o Empresa Proveedora del servicio.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV26ResposabilidadTani );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "10. Propiedad Intelectual" );
      AV25PropiedadIntelectual += "THANI está protegido por los derechos de propiedad " ;
      AV25PropiedadIntelectual += "de autor. Todos los derechos involucrados como por " ;
      AV25PropiedadIntelectual += "ejemplo el contenido, el diseño visual, logos y eslogan " ;
      AV25PropiedadIntelectual += "que forman parte del contenido y servicios, pertenecen " ;
      AV25PropiedadIntelectual += "a THANI. En base a ello, se prohíbe utilizar, codificar, " ;
      AV25PropiedadIntelectual += "copiar, distribuir, transmitir o comercializar los " ;
      AV25PropiedadIntelectual += "derechos involucrados sin el permiso expreso por escrito.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV25PropiedadIntelectual );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "11. Términos de Ley" );
      AV31TerminoLey += "Este acuerdo será gobernado e interpretado de acuerdo con " ;
      AV31TerminoLey += "las leyes de Perú, sin dar efecto a cualquier principio de " ;
      AV31TerminoLey += "conflictos de ley. Si alguna disposición de estos Términos y " ;
      AV31TerminoLey += "Condiciones es declarada ilegal, o presenta un vacío, o por " ;
      AV31TerminoLey += "cualquier razón resulta inaplicable, la misma deberá ser " ;
      AV31TerminoLey += "interpretada dentro del marco del mismo y en cualquier caso no " ;
      AV31TerminoLey += "afectará la validez y la aplicabilidad de las cláusulas restantes.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV31TerminoLey );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "12. Notificaciones" );
      AV21Notificaciones += "Cualquier comentario, inquietud o reclamación respecto de " ;
      AV21Notificaciones += "los anteriores Términos y Condiciones, la Política de " ;
      AV21Notificaciones += "Privacidad, o la ejecución de cualquiera de éstos, deberá ser " ;
      AV21Notificaciones += "notificada por escrito a THANI.<br><br>" ;
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Stcitemdescripcion( AV21Notificaciones );
      AV28TCUserItem.getgxTv_SdtSDTTerminosCondiciones_Subterminoscondiciones().add(AV30TCUserSubItem, 0);
      AV30TCUserSubItem = (com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem)new com.projectthani.SdtSDTTerminosCondiciones_SubTerminosCondicionesItem(remoteHandle, context);
      AV30TCUserSubItem.setgxTv_SdtSDTTerminosCondiciones_SubTerminosCondicionesItem_Sdtitemtitulo( "13. Jurisdicción y Ley Aplicable" );
      AV16JurisdiccionLeyAp += "Este acuerdo estará regido en todos sus puntos por las " ;
      AV16JurisdiccionLeyAp += "leyes vigentes en la República del Perú.<br><br>" ;
      AV16JurisdiccionLeyAp += "Cualquier controversia derivada del presente acuerdo, su " ;
      AV16JurisdiccionLeyAp += "existencia, validez, interpretación, alcance o " ;
      AV16JurisdiccionLeyAp += "cumplimiento, será sometida a los tribunales competentes de la ciudad de Lima, Perú.<br><br>" ;
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

