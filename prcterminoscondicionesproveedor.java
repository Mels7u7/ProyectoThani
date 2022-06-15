package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcterminoscondicionesproveedor extends GXProcedure
{
   public prcterminoscondicionesproveedor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcterminoscondicionesproveedor.class ), "" );
   }

   public prcterminoscondicionesproveedor( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor> executeUdp( )
   {
      prcterminoscondicionesproveedor.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>[] aP0 )
   {
      prcterminoscondicionesproveedor.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV35TituloDoc = "T�RMINOS Y CONDICIONES GENERALES ENTRE LA EMPRESA Y EL PROVEEDOR DEL SERVICIO" ;
      AV19NombreEmpresa = "DESARROLLO DE PLATAFORMAS Y SERVICIOS DIGITALES S.A.C" ;
      AV18NombreComercial = "THANI" ;
      AV29RucEmpresa = "20606936134" ;
      AV11DireccionEmpresa = "Jir�n Ferm�n Tanguis N�145 Dpto 501 Urb. Santa Catalina, distrito de La Victoria." ;
      AV12DominioPlataforma = "app.thanitech.pe" ;
      AV13EmailEmpresa = "soporte@thanitech.pe" ;
      AV30TCProveedor = (com.projectthani.SdtSDTTermCondProveedor)new com.projectthani.SdtSDTTermCondProveedor(remoteHandle, context);
      AV30TCProveedor.setgxTv_SdtSDTTermCondProveedor_Titulo( AV35TituloDoc );
      AV15GeneralText += AV19NombreEmpresa + " (en adelante usaremos el nombre " ;
      AV15GeneralText += "comercial: �" + AV18NombreComercial + "�) es una sociedad debidamente inscrita en el registro de personas jur�dicas " ;
      AV15GeneralText += "de Lima y Callao, identificada con RUC N� " + AV29RucEmpresa + ", siendo su domicilio fiscal en " ;
      AV15GeneralText += AV11DireccionEmpresa + " Asimismo, " + AV18NombreComercial ;
      AV15GeneralText += "es un proveedor de sitio web, mediante el cual los Usuarios que se registren podr�n solicitar " ;
      AV15GeneralText += "y agendar consultas con m�dicos y/o Cl�nicas previamente inscritas de las especialidades que " ;
      AV15GeneralText += "se indiquen, las mismas que se llevar�n a cabo de manera virtual y/o presencial. Asimismo, se " ;
      AV15GeneralText += "podr� agendar o solicitar ex�menes auxiliares, de laboratorio y/o pedidos a farmacias afiliadas. <br><br>" ;
      AV15GeneralText += "Este documento describe los t�rminos y condiciones generales (los \"T�rminos y Condiciones Generales\") " ;
      AV15GeneralText += "aplicables entre los m�dicos, personal de salud, laboratorios, farmacias y/o " ;
      AV15GeneralText += "cl�nicas a quienes en adelante se le denominar� �EL PROVEEDOR� del servicio y " + AV18NombreComercial + ". La " ;
      AV15GeneralText += "persona que acepte los presentes T�rminos y Condiciones, brindar�n el servicio que ha sido " ;
      AV15GeneralText += "solicitado a trav�s del sitio " + AV12DominioPlataforma + "� y/o la aplicaci�n m�vil denominada �" + AV18NombreComercial + "�, las " ;
      AV15GeneralText += "cuales, en adelante, denominaremos en su conjunto como �LAS APLICACIONES�.<br><br>" ;
      AV15GeneralText += "EL PROVEEDOR que desee brindar su servicio a los usuarios que utilicen LAS APLICACIONES " ;
      AV15GeneralText += "podr� hacerlo sujet�ndose a los T�rminos y Condiciones Generales y las Pol�ticas de " ;
      AV15GeneralText += "Privacidad, junto con todas las dem�s pol�ticas y principios que rigen " + AV12DominioPlataforma + " y la " ;
      AV15GeneralText += "aplicaci�n " + AV18NombreComercial + " y que son incorporados al presente directamente o por referencia o que son " ;
      AV15GeneralText += "explicados y/o detallados en otras secciones del Sitio. En consecuencia, todas las visitas y " ;
      AV15GeneralText += "todos los contratos y transacciones que se realicen en este Sitio, as� como sus efectos " ;
      AV15GeneralText += "jur�dicos, quedar�n regidos por estas reglas y sometidos a la legislaci�n aplicable en Per�.<br><br>" ;
      AV15GeneralText += "Los T�rminos y Condiciones contenidos en este instrumento se aplicar�n y se entender�n como " ;
      AV15GeneralText += "parte integral de todos los actos y contratos que se ejecuten o celebren mediante los " ;
      AV15GeneralText += "sistemas de oferta y prestaci�n del servicio comprendidos en este sitio entre EL PROVEEDOR y " + AV18NombreComercial + ".<br><br>" ;
      AV15GeneralText += "CUALQUIER PERSONA QUE NO ACEPTE ESTOS T�RMINOS Y CONDICIONES GENERALES Y LAS POL�TICAS DE " ;
      AV15GeneralText += "PRIVACIDAD, LOS CUALES TIENEN UN CAR�CTER OBLIGATORIO Y VINCULANTE, DEBER� ABSTENERSE DE " ;
      AV15GeneralText += "UTILIZAR EL SITIO Y/O LOS SERVICIOS.<br><br>" ;
      AV15GeneralText += "EL PROVEEDOR declara leer, entender y aceptar todas las condiciones establecidas en los " ;
      AV15GeneralText += "T�rminos y Condiciones Generales y en las Pol�ticas de Privacidad de " + AV18NombreComercial + ", as� como en los " ;
      AV15GeneralText += "dem�s documentos incorporados a los mismos por referencia, previo a su registro como " ;
      AV15GeneralText += "Proveedor de la p�gina web app.thanitec.pe o en la aplicaci�n THANI quedando sujetos a lo se�alado " ;
      AV15GeneralText += "y dispuesto en los T�rminos y Condiciones.<br><br>" ;
      AV30TCProveedor.setgxTv_SdtSDTTermCondProveedor_Descripcion( AV15GeneralText );
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "1. Capacidad legal" );
      AV8CapLegal += "Los Servicios s�lo est�n disponibles para personas que tengan capacidad legal para contratar.<br><br>" ;
      AV8CapLegal += "EL PROVEEDOR que registre un Usuario como empresa afirmar� que (i) cuenta con capacidad para " ;
      AV8CapLegal += "contratar en representaci�n de tal entidad y de obligar a la misma en los t�rminos de este " ;
      AV8CapLegal += "Acuerdo, (ii) la direcci�n se�alada en el registro es el domicilio principal Legal y/o " ;
      AV8CapLegal += "Fiscal de dicha entidad, y (iii) cualquier otra informaci�n presentada a " + AV18NombreComercial + " es verdadera, " ;
      AV8CapLegal += "precisa, actualizada, completa y oportuna.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV8CapLegal );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "2. Registro y uso del Sitio" );
      AV27RegUsoSitio += "Es obligatorio completar el formulario de registro en todos sus campos con datos v�lidos y " ;
      AV27RegUsoSitio += "verdaderos para convertirse en Proveedor autorizado de THANI, de esta manera, podr� ofertar " ;
      AV27RegUsoSitio += "sus servicios de manera virtual y/o presencial. El futuro Proveedor deber� completar el " ;
      AV27RegUsoSitio += "formulario de registro con su informaci�n personal de manera exacta, precisa y verdadera " ;
      AV27RegUsoSitio += "(\"Datos Personales\") y asume el compromiso de actualizar los Datos Personales conforme " ;
      AV27RegUsoSitio += "resulte necesario. THANI podr� utilizar diversos medios para identificar a sus Miembros, " ;
      AV27RegUsoSitio += "pero NO se responsabiliza por la certeza de los Datos Personales provistos por los Usuarios " ;
      AV27RegUsoSitio += "que soliciten sus servicios. EL PROVEEDOR garantiza y responde, en cualquier caso, de la " ;
      AV27RegUsoSitio += "exactitud, veracidad, vigencia y autenticidad de los Datos Personales, profesionales, de " ;
      AV27RegUsoSitio += "especialidad y/o respecto a su experiencia que hayan sido ingresados. Por tanto, la " ;
      AV27RegUsoSitio += "declaraci�n realizada al momento de registrarse se entender� como una Declaraci�n Jurada. " ;
      AV27RegUsoSitio += "Este registro dar� origen a una cuenta que identifica a EL PROVEEDOR. <br><br>" ;
      AV27RegUsoSitio += "Si se verifica o sospecha alg�n uso fraudulento y/o malintencionado y/o contrario a estos " ;
      AV27RegUsoSitio += "T�rminos y Condiciones y/o contrarios a la buena fe o que incumpla alg�n tema normativo, " ;
      AV27RegUsoSitio += "THANI tendr� el derecho inapelable de dar por terminado el servicio, cancelar las " ;
      AV27RegUsoSitio += "transacciones en curso, dar de baja las cuentas y perseguir judicialmente a los infractores.<br><br>" ;
      AV27RegUsoSitio += "THANI podr� realizar los controles que crea convenientes para verificar la veracidad de la " ;
      AV27RegUsoSitio += "informaci�n brindada. En ese sentido, se reserva el derecho de solicitar alg�n comprobante y/" ;
      AV27RegUsoSitio += "o dato adicional a efectos de corroborar los Datos Personales, as� como de suspender " ;
      AV27RegUsoSitio += "temporal o definitivamente a aquellos Proveedores cuyos datos no hayan podido ser " ;
      AV27RegUsoSitio += "confirmados. En caso de suspensi�n temporal, THANI comunicar� a EL PROVEEDOR informando el " ;
      AV27RegUsoSitio += "tiempo de suspensi�n de la cuenta. En casos de inhabilitaci�n definitiva THANI podr� dar de " ;
      AV27RegUsoSitio += "baja la cuenta, sin que ello genere derecho alguno a resarcimiento, pago y/o indemnizaci�n.<br><br>" ;
      AV27RegUsoSitio += "EL PROVEEDOR, una vez registrado, dispondr� de su direcci�n de email y una clave secreta (en " ;
      AV27RegUsoSitio += "adelante \"Clave\") que le permitir� el acceso personalizado, confidencial y seguro. En caso " ;
      AV27RegUsoSitio += "de poseer estos datos, EL PROVEEDOR tendr� la posibilidad de cambiar la Clave de acceso para " ;
      AV27RegUsoSitio += "lo cual deber� sujetarse al procedimiento establecido en el sitio respectivo. EL PROVEEDOR " ;
      AV27RegUsoSitio += "se obliga a mantener la confidencialidad de su Clave de acceso, asumiendo totalmente la " ;
      AV27RegUsoSitio += "responsabilidad por el mantenimiento de la confidencialidad de su Clave secreta registrada " ;
      AV27RegUsoSitio += "en este sitio web, la cual le permite brindar los servicios que ofrece. Dicha Clave es de " ;
      AV27RegUsoSitio += "uso personal, y su entrega a terceros no involucra responsabilidad de THANI en caso de " ;
      AV27RegUsoSitio += "utilizaci�n indebida, negligente y/o incorrecta.<br><br>" ;
      AV27RegUsoSitio += "EL PROVEEDOR ser� responsable por la calidad e idoneidad del servicio ofertado y brindado, y " ;
      AV27RegUsoSitio += "de todas las operaciones efectuadas en y desde su Cuenta, pues el acceso a la misma est� " ;
      AV27RegUsoSitio += "restringido al ingreso y uso de una Clave secreta, de uso y conocimiento exclusivo de EL " ;
      AV27RegUsoSitio += "PROVEEDOR. EL PROVEEDOR se compromete a notificar a LA EMPRESA en forma inmediata y por " ;
      AV27RegUsoSitio += "medio id�neo y fehaciente, cualquier uso indebido o no autorizado de su Cuenta y/o Clave, " ;
      AV27RegUsoSitio += "as� como el ingreso por terceros no autorizados a la misma. Se aclara que est� prohibida la " ;
      AV27RegUsoSitio += "venta, cesi�n, pr�stamo o transferencia de la Clave y/o Cuenta bajo ning�n t�tulo.<br><br>" ;
      AV27RegUsoSitio += "THANI se reserva el derecho de rechazar cualquier solicitud de registro o de cancelar un " ;
      AV27RegUsoSitio += "registro previamente aceptado, sin que est� obligado a comunicar o exponer las razones de su " ;
      AV27RegUsoSitio += "decisi�n y sin que ello genere alg�n derecho a indemnizaci�n o resarcimiento.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV27RegUsoSitio );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "3. Modificaciones del acuerdo" );
      AV17ModifAcuerdo += "THANI podr� modificar los T�rminos y Condiciones Generales en cualquier momento, haciendo " ;
      AV17ModifAcuerdo += "p�blicos en el Sitio los t�rminos modificados. Todos los t�rminos modificados entrar�n en " ;
      AV17ModifAcuerdo += "vigencia a los 10 (diez) d�as h�biles despu�s de su publicaci�n. Dentro de los 5 (cinco) " ;
      AV17ModifAcuerdo += "d�as h�biles siguientes a la publicaci�n de las modificaciones introducidas, el Usuario se " ;
      AV17ModifAcuerdo += "deber� comunicar por e-mail a la siguiente direcci�n: soporte@thanitech.pe si no acepta las " ;
      AV17ModifAcuerdo += "mismas; en ese caso quedar� disuelto el v�nculo contractual y ser� inhabilitado como " ;
      AV17ModifAcuerdo += "Proveedor. Vencido este plazo, se considerar� que el Usuario acepta los nuevos t�rminos y el " ;
      AV17ModifAcuerdo += "contrato continuar� vinculando a ambas partes.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV17ModifAcuerdo );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "4. Procedimiento para uso del Sitio de internet y la APP" );
      AV25ProcInternetApp += "En los contratos ofrecidos por medio del Sitio, THANI informar�, de manera inequ�voca y " ;
      AV25ProcInternetApp += "f�cilmente accesible, los pasos que deber�n seguirse para celebrarlos, e informar�, cuando " ;
      AV25ProcInternetApp += "corresponda, si el documento electr�nico en que se formalice el contrato ser� archivado y si �ste ser� accesible a EL PROVEEDOR.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV25ProcInternetApp );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "5. Contraprestaci�n por el uso del Sitio web y APP" );
      AV10ContraprestacionAPP += "THANI y EL PROVEEDOR, acuerdan que por cada prestaci�n del servicio, solicitada a trav�s de " ;
      AV10ContraprestacionAPP += "LAS APLICACIONES, EL PROVEEDOR, deber� realizar el pago de S/ **.** (****** y 00/100 soles), " ;
      AV10ContraprestacionAPP += "la liquidaci�n ser� realizada de manera mensual. THANI enviar� una liquidaci�n a EL " ;
      AV10ContraprestacionAPP += "PROVEEDOR, respecto a los servicios que ha brindado en el mes materia de la liquidaci�n, " ;
      AV10ContraprestacionAPP += "para su revisi�n en el plazo de 3 d�as h�biles, vencido los cuales se entender� que existe " ;
      AV10ContraprestacionAPP += "conformidad y se proceder� al pago respectivo dentro de los 5 d�as �tiles siguientes. (Aqu� " ;
      AV10ContraprestacionAPP += "no sabemos si la tarifa es un porcentaje o un monto flat.)<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV10ContraprestacionAPP );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "6. Formaci�n del consentimiento en los contratos celebrados a trav�s de este Sitio" );
      AV14FormacionCon += "A trav�s del Sitio web y la aplicaci�n THANI EL PROVEEDOR y THANI, manifiestan estar de acuerdo con todas las cl�usulas aqu� establecidas.<br><br>" ;
      AV14FormacionCon += "Para informar a EL PROVEEDOR, el Sitio deber� enviar una confirmaci�n a la misma direcci�n " ;
      AV14FormacionCon += "electr�nica que haya registrado EL PROVEEDOR aceptante de la oferta. El consentimiento se " ;
      AV14FormacionCon += "entender� formado desde el momento en que se env�a esta confirmaci�n a EL PROVEEDOR.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV14FormacionCon );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "7. Plazo de validez de la tarifa" );
      AV21PlazoValidez += "Las tarifas y/o honorarios de los servicios disponibles en el Sitio, mientras aparezcan como " ;
      AV21PlazoValidez += "disponibles, solo tendr�n vigencia y aplicaci�n en �ste. Las tarifas de los servicios " ;
      AV21PlazoValidez += "ofrecidos en el Sitio deber�n estar expresados en Soles o su conversi�n en moneda extranjera " ;
      AV21PlazoValidez += "si fuera el caso. <br><br>" ;
      AV21PlazoValidez += "EL PROVEEDOR podr� modificar cualquier informaci�n de tarifa contenida en este Sitio, sin " ;
      AV21PlazoValidez += "embargo, se compromete a respectar la tarifa ofrecida para todos los servicios que fueron " ;
      AV21PlazoValidez += "solicitados previo a dicho cambio.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV21PlazoValidez );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "8. Prestaci�n del servicio" );
      AV22PrestacionServ += "THANI pone a disposici�n de EL PROVEEDOR debidamente registrado, la posibilidad de ofrecer sus servicios.<br><br>" ;
      AV22PrestacionServ += "EL PROVEEDOR podr� incluir promociones u ofertas, a fin de hacer m�s atractivo el servicio ofrecido.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV22PrestacionServ );
      AV33TCProveedorSubItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem(remoteHandle, context);
      AV23PrestacionServItem1 += "<font style=\"font-size: 2rem;font-weight: 900;\">�</font>" ;
      AV23PrestacionServItem1 += " Una vez solicitado el servicio y canceladas las tarifas correspondientes, se enviar� al " ;
      AV23PrestacionServItem1 += "correo electr�nico registrado por el usuario y al proveedor del servicio m�dico un link a " ;
      AV23PrestacionServItem1 += "trav�s del cual se realizar� la consulta m�dica.<br><br>" ;
      AV33TCProveedorSubItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion( AV23PrestacionServItem1 );
      AV31TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor().add(AV33TCProveedorSubItem, 0);
      AV33TCProveedorSubItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem(remoteHandle, context);
      AV24PrestacionServItem2 += "<font style=\"font-size: 2rem;font-weight: 900;\">�</font>" ;
      AV24PrestacionServItem2 += " THANI s�lo es responsable de brindar el link para que se lleve a cabo el servicio solicitado.<br><br>" ;
      AV33TCProveedorSubItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion( AV24PrestacionServItem2 );
      AV31TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor().add(AV33TCProveedorSubItem, 0);
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "9. Responsabilidad de THANI" );
      AV28ResponsabilidadThani += "THANI s�lo es responsable del correcto funcionamiento de la plataforma y APP mediante la " ;
      AV28ResponsabilidadThani += "cual se realiza el contacto para la prestaci�n del servicio al usuario final de parte de EL " ;
      AV28ResponsabilidadThani += "PROVEEDOR, y del env�o oportuno del link.<br><br>" ;
      AV28ResponsabilidadThani += "THANI har� lo posible dentro de sus capacidades para que la transmisi�n del Sitio sea " ;
      AV28ResponsabilidadThani += "ininterrumpida y libre de errores. Sin embargo, dada la naturaleza del servicio de Internet, " ;
      AV28ResponsabilidadThani += "dichas condiciones no pueden ser garantizadas. En el mismo sentido, el acceso puede ser " ;
      AV28ResponsabilidadThani += "ocasionalmente restringido o suspendido con el objeto de efectuar reparaciones, " ;
      AV28ResponsabilidadThani += "mantenimiento o introducir nuevos Servicios o Proveedores. THANI. no ser� responsable por " ;
      AV28ResponsabilidadThani += "p�rdidas (i) que no hayan sido causadas por el incumplimiento de sus obligaciones; (ii) " ;
      AV28ResponsabilidadThani += "lucro cesante; (iii) cualquier da�o indirecto.<br><br>" ;
      AV28ResponsabilidadThani += "THANI no es responsable por la calidad, idoneidad, seguridad, oportunidad, puntualidad, " ;
      AV28ResponsabilidadThani += "praxis, etc del servicio brindado por EL PROVEEDOR al usuario final. <br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV28ResponsabilidadThani );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "10. Comprobantes de Pago" );
      AV9ComprobantesPago += "Una vez realizado el pago del servicio, EL PROVEEDOR, remitir� de manera electr�nica a el " ;
      AV9ComprobantesPago += "usuario, el comprobante de pago respectivo a la direcci�n electr�nica registrada.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV9ComprobantesPago );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "11. Propiedad Intelectual" );
      AV26PropiedadInt += "THANI est� protegido por los derechos de propiedad de autor. Todos los derechos involucrados " ;
      AV26PropiedadInt += "como por ejemplo el contenido, el dise�o visual, logos y eslogan que forman parte del " ;
      AV26PropiedadInt += "contenido y servicios, pertenecen a THANI. En base a ello, se proh�be utilizar, codificar, " ;
      AV26PropiedadInt += "copiar, distribuir, transmitir o comercializar los derechos involucrados sin el permiso " ;
      AV26PropiedadInt += "expreso por escrito.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV26PropiedadInt );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "12. T�rminos de Ley" );
      AV34TerminosLey += "Este acuerdo ser� gobernado e interpretado de acuerdo con las leyes de Per�, sin dar efecto " ;
      AV34TerminosLey += "a cualquier principio de conflictos de ley. Si alguna disposici�n de estos T�rminos y " ;
      AV34TerminosLey += "Condiciones es declarada ilegal, o presenta un vac�o, o por cualquier raz�n resulta " ;
      AV34TerminosLey += "inaplicable, la misma deber� ser interpretada dentro del marco del mismo y en cualquier caso " ;
      AV34TerminosLey += "no afectar� la validez y la aplicabilidad de las cl�usulas restantes.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV34TerminosLey );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "13. Notificaciones" );
      AV20Notif += "Cualquier comentario, inquietud o reclamaci�n respecto de los anteriores T�rminos y " ;
      AV20Notif += "Condiciones, la Pol�tica de Privacidad, o la ejecuci�n de cualquiera de �stos, deber� ser notificada por escrito a THANI.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV20Notif );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV31TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo( "14. Jurisdicci�n y Ley Aplicable" );
      AV16Jurisdiccion += "Este acuerdo estar� regido en todos sus puntos por las leyes vigentes en la Rep�blica del Per�.<br><br>" ;
      AV16Jurisdiccion += "Cualquier controversia derivada del presente acuerdo, su existencia, validez, " ;
      AV16Jurisdiccion += "interpretaci�n, alcance o cumplimiento, ser� sometida a los tribunales competentes de la ciudad de Lima, Per�.<br><br>" ;
      AV31TCProveedorItem.setgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion( AV16Jurisdiccion );
      AV30TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().add(AV31TCProveedorItem, 0);
      AV32TCProveedorList.add(AV30TCProveedor, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcterminoscondicionesproveedor.this.AV32TCProveedorList;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32TCProveedorList = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>(com.projectthani.SdtSDTTermCondProveedor.class, "SDTTermCondProveedor", "ProjectThani", remoteHandle);
      AV35TituloDoc = "" ;
      AV19NombreEmpresa = "" ;
      AV18NombreComercial = "" ;
      AV29RucEmpresa = "" ;
      AV11DireccionEmpresa = "" ;
      AV12DominioPlataforma = "" ;
      AV13EmailEmpresa = "" ;
      AV30TCProveedor = new com.projectthani.SdtSDTTermCondProveedor(remoteHandle, context);
      AV15GeneralText = "" ;
      AV31TCProveedorItem = new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV8CapLegal = "" ;
      AV27RegUsoSitio = "" ;
      AV17ModifAcuerdo = "" ;
      AV25ProcInternetApp = "" ;
      AV10ContraprestacionAPP = "" ;
      AV14FormacionCon = "" ;
      AV21PlazoValidez = "" ;
      AV22PrestacionServ = "" ;
      AV33TCProveedorSubItem = new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem(remoteHandle, context);
      AV23PrestacionServItem1 = "" ;
      AV24PrestacionServItem2 = "" ;
      AV28ResponsabilidadThani = "" ;
      AV9ComprobantesPago = "" ;
      AV26PropiedadInt = "" ;
      AV34TerminosLey = "" ;
      AV20Notif = "" ;
      AV16Jurisdiccion = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV35TituloDoc ;
   private String AV19NombreEmpresa ;
   private String AV18NombreComercial ;
   private String AV29RucEmpresa ;
   private String AV11DireccionEmpresa ;
   private String AV12DominioPlataforma ;
   private String AV13EmailEmpresa ;
   private String AV15GeneralText ;
   private String AV8CapLegal ;
   private String AV27RegUsoSitio ;
   private String AV17ModifAcuerdo ;
   private String AV25ProcInternetApp ;
   private String AV10ContraprestacionAPP ;
   private String AV14FormacionCon ;
   private String AV21PlazoValidez ;
   private String AV22PrestacionServ ;
   private String AV23PrestacionServItem1 ;
   private String AV24PrestacionServItem2 ;
   private String AV28ResponsabilidadThani ;
   private String AV9ComprobantesPago ;
   private String AV26PropiedadInt ;
   private String AV34TerminosLey ;
   private String AV20Notif ;
   private String AV16Jurisdiccion ;
   private GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor> AV32TCProveedorList ;
   private com.projectthani.SdtSDTTermCondProveedor AV30TCProveedor ;
   private com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem AV31TCProveedorItem ;
   private com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem AV33TCProveedorSubItem ;
}

