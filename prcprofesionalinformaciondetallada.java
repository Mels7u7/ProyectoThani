package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcprofesionalinformaciondetallada extends GXProcedure
{
   public prcprofesionalinformaciondetallada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcprofesionalinformaciondetallada.class ), "" );
   }

   public prcprofesionalinformaciondetallada( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> executeUdp( int aP0 ,
                                                                                    GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>[] aP1 ,
                                                                                    GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>[] aP2 ,
                                                                                    GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>[] aP3 ,
                                                                                    GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>[] aP4 ,
                                                                                    GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>[] aP5 )
   {
      prcprofesionalinformaciondetallada.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>[] aP1 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>[] aP2 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>[] aP3 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>[] aP4 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>[] aP5 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>[] aP1 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>[] aP2 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>[] aP3 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>[] aP4 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>[] aP5 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>[] aP6 )
   {
      prcprofesionalinformaciondetallada.this.AV15ProfesionalId = aP0;
      prcprofesionalinformaciondetallada.this.aP1 = aP1;
      prcprofesionalinformaciondetallada.this.aP2 = aP2;
      prcprofesionalinformaciondetallada.this.aP3 = aP3;
      prcprofesionalinformaciondetallada.this.aP4 = aP4;
      prcprofesionalinformaciondetallada.this.aP5 = aP5;
      prcprofesionalinformaciondetallada.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A43PaisId = P005Y2_A43PaisId[0] ;
         A31ProfesionalId = P005Y2_A31ProfesionalId[0] ;
         A40000ProfesionalFoto_GXI = P005Y2_A40000ProfesionalFoto_GXI[0] ;
         A173ProfesionalTipoDocumento = P005Y2_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = P005Y2_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = P005Y2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P005Y2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P005Y2_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = P005Y2_A176ProfesionalFechaNacimiento[0] ;
         A177ProfesionalSexo = P005Y2_A177ProfesionalSexo[0] ;
         A178ProfesionalDescripcion = P005Y2_A178ProfesionalDescripcion[0] ;
         A179ProfesionalCorreo = P005Y2_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = P005Y2_A88ProfesionalCOP[0] ;
         A182ProfesionalTiempoCita = P005Y2_A182ProfesionalTiempoCita[0] ;
         A183ProfesionalDireccion = P005Y2_A183ProfesionalDireccion[0] ;
         A184PaisDescripcion = P005Y2_A184PaisDescripcion[0] ;
         A189ProfesionalFoto = P005Y2_A189ProfesionalFoto[0] ;
         A190ProfesionalTwitter = P005Y2_A190ProfesionalTwitter[0] ;
         A191ProfesionalFacebook = P005Y2_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = P005Y2_A192ProfesionalInstagram[0] ;
         A193ProfesionalLinkedin = P005Y2_A193ProfesionalLinkedin[0] ;
         A194ProfesionalTelefono = P005Y2_A194ProfesionalTelefono[0] ;
         A195ProfesionalFechaRegistro = P005Y2_A195ProfesionalFechaRegistro[0] ;
         A197ProfesionalEstadoCuenta = P005Y2_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = P005Y2_A198ProfesionalEstado[0] ;
         A44UbigeoCode = P005Y2_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P005Y2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P005Y2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P005Y2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P005Y2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P005Y2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P005Y2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P005Y2_A186UbigeoDepartamento[0] ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV16ProfesionalItem = (com.projectthani.SdtSDTProfesionalInformacionGeneral)new com.projectthani.SdtSDTProfesionalInformacionGeneral(remoteHandle, context);
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalid( A31ProfesionalId );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento( A173ProfesionalTipoDocumento );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento( A174ProfesionalNroDocumento );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres( A84ProfesionalNombres );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento( A176ProfesionalFechaNacimiento );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo( A177ProfesionalSexo );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion( A178ProfesionalDescripcion );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo( A179ProfesionalCorreo );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop( A88ProfesionalCOP );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita( A182ProfesionalTiempoCita );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion( A183ProfesionalDireccion );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion( A184PaisDescripcion );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeocode( A44UbigeoCode );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeonombre( A185UbigeoNombre );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto( A189ProfesionalFoto );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto_gxi( A40000ProfesionalFoto_GXI );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter( A190ProfesionalTwitter );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook( A191ProfesionalFacebook );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram( A192ProfesionalInstagram );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin( A193ProfesionalLinkedin );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono( A194ProfesionalTelefono );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro( A195ProfesionalFechaRegistro );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestadocuenta( A197ProfesionalEstadoCuenta );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado( A198ProfesionalEstado );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento( A186UbigeoDepartamento );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamentocode( A295UbigeoDepartamentoCode );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia( A187UbigeoProvincia );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovinciacode( A296UbigeoProvinciaCode );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito( A188UbigeoDistrito );
         AV16ProfesionalItem.setgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistritocode( A297UbigeoDistritoCode );
         AV17ProfesionalListItem.add(AV16ProfesionalItem, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P005Y3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A31ProfesionalId = P005Y3_A31ProfesionalId[0] ;
         A32EspecialidadId = P005Y3_A32EspecialidadId[0] ;
         A140EspecialidadCodigo = P005Y3_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P005Y3_A71EspecialidadNombre[0] ;
         A199CostoConsulta = P005Y3_A199CostoConsulta[0] ;
         A54SedeTipoConsulta = P005Y3_A54SedeTipoConsulta[0] ;
         A30SedeId = P005Y3_A30SedeId[0] ;
         A75SedeNombre = P005Y3_A75SedeNombre[0] ;
         A140EspecialidadCodigo = P005Y3_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P005Y3_A71EspecialidadNombre[0] ;
         A199CostoConsulta = P005Y3_A199CostoConsulta[0] ;
         A54SedeTipoConsulta = P005Y3_A54SedeTipoConsulta[0] ;
         A30SedeId = P005Y3_A30SedeId[0] ;
         A75SedeNombre = P005Y3_A75SedeNombre[0] ;
         AV10EspecialidadItem = (com.projectthani.SdtSDTProfesionalEspecialidadSede)new com.projectthani.SdtSDTProfesionalEspecialidadSede(remoteHandle, context);
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid( A32EspecialidadId );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo( A140EspecialidadCodigo );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre( A71EspecialidadNombre );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta( A199CostoConsulta );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( A54SedeTipoConsulta );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Sedeid( A30SedeId );
         AV10EspecialidadItem.setgxTv_SdtSDTProfesionalEspecialidadSede_Sedenombre( A75SedeNombre );
         AV20EspecialidadListItem.add(AV10EspecialidadItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      /* Using cursor P005Y4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A31ProfesionalId = P005Y4_A31ProfesionalId[0] ;
         A55EducacionId = P005Y4_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = P005Y4_A200EducacionNombreInstitucion[0] ;
         A203EducacionPaisDescripcion = P005Y4_A203EducacionPaisDescripcion[0] ;
         A201EducacionDesde = P005Y4_A201EducacionDesde[0] ;
         A202EducacionHasta = P005Y4_A202EducacionHasta[0] ;
         AV8EducacionItem = (com.projectthani.SdtSDTProfesionalEducacion)new com.projectthani.SdtSDTProfesionalEducacion(remoteHandle, context);
         AV8EducacionItem.setgxTv_SdtSDTProfesionalEducacion_Educacionid( A55EducacionId );
         AV8EducacionItem.setgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion( A200EducacionNombreInstitucion );
         AV8EducacionItem.setgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion( A203EducacionPaisDescripcion );
         AV8EducacionItem.setgxTv_SdtSDTProfesionalEducacion_Educaciondesde( A201EducacionDesde );
         AV8EducacionItem.setgxTv_SdtSDTProfesionalEducacion_Educacionhasta( A202EducacionHasta );
         AV9EducacionListItem.add(AV8EducacionItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /* Using cursor P005Y5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A31ProfesionalId = P005Y5_A31ProfesionalId[0] ;
         A56ExperienciaLaboralId = P005Y5_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = P005Y5_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = P005Y5_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = P005Y5_A206ExperienciaLaboralHasta[0] ;
         AV11ExperienciaLaboralItem = (com.projectthani.SdtSDTProfesionalExperienciaLaboral)new com.projectthani.SdtSDTProfesionalExperienciaLaboral(remoteHandle, context);
         AV11ExperienciaLaboralItem.setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid( A56ExperienciaLaboralId );
         AV11ExperienciaLaboralItem.setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre( A204ExperienciaLaboralEmpresaNombre );
         AV11ExperienciaLaboralItem.setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde( A205ExperienciaLaboralDesde );
         AV11ExperienciaLaboralItem.setgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta( A206ExperienciaLaboralHasta );
         AV12ExperienciaLaboralListItem.add(AV11ExperienciaLaboralItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      /* Using cursor P005Y6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A31ProfesionalId = P005Y6_A31ProfesionalId[0] ;
         A57PremiosId = P005Y6_A57PremiosId[0] ;
         A207PremiosNombre = P005Y6_A207PremiosNombre[0] ;
         A209PremiosDescripcion = P005Y6_A209PremiosDescripcion[0] ;
         A208PremiosFecha = P005Y6_A208PremiosFecha[0] ;
         AV13PremiosItem = (com.projectthani.SdtSDTProfesionalPremios)new com.projectthani.SdtSDTProfesionalPremios(remoteHandle, context);
         AV13PremiosItem.setgxTv_SdtSDTProfesionalPremios_Premiosid( A57PremiosId );
         AV13PremiosItem.setgxTv_SdtSDTProfesionalPremios_Premiosnombre( A207PremiosNombre );
         AV13PremiosItem.setgxTv_SdtSDTProfesionalPremios_Premiosdescripcion( A209PremiosDescripcion );
         AV13PremiosItem.setgxTv_SdtSDTProfesionalPremios_Premiosfecha( A208PremiosFecha );
         AV14PremiosListItem.add(AV13PremiosItem, 0);
         pr_default.readNext(4);
      }
      pr_default.close(4);
      /* Using cursor P005Y7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV15ProfesionalId)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A31ProfesionalId = P005Y7_A31ProfesionalId[0] ;
         A58ServiciosId = P005Y7_A58ServiciosId[0] ;
         A210ServiciosNombre = P005Y7_A210ServiciosNombre[0] ;
         AV18ServiciosItem = (com.projectthani.SdtSDTProfesionalServicios)new com.projectthani.SdtSDTProfesionalServicios(remoteHandle, context);
         AV18ServiciosItem.setgxTv_SdtSDTProfesionalServicios_Serviciosid( A58ServiciosId );
         AV18ServiciosItem.setgxTv_SdtSDTProfesionalServicios_Serviciosnombre( A210ServiciosNombre );
         AV19ServiciosListItem.add(AV18ServiciosItem, 0);
         pr_default.readNext(5);
      }
      pr_default.close(5);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcprofesionalinformaciondetallada.this.AV20EspecialidadListItem;
      this.aP2[0] = prcprofesionalinformaciondetallada.this.AV17ProfesionalListItem;
      this.aP3[0] = prcprofesionalinformaciondetallada.this.AV9EducacionListItem;
      this.aP4[0] = prcprofesionalinformaciondetallada.this.AV12ExperienciaLaboralListItem;
      this.aP5[0] = prcprofesionalinformaciondetallada.this.AV14PremiosListItem;
      this.aP6[0] = prcprofesionalinformaciondetallada.this.AV19ServiciosListItem;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20EspecialidadListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>(com.projectthani.SdtSDTProfesionalEspecialidadSede.class, "SDTProfesionalEspecialidadSede", "ProjectThani", remoteHandle);
      AV17ProfesionalListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>(com.projectthani.SdtSDTProfesionalInformacionGeneral.class, "SDTProfesionalInformacionGeneral", "ProjectThani", remoteHandle);
      AV9EducacionListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>(com.projectthani.SdtSDTProfesionalEducacion.class, "SDTProfesionalEducacion", "ProjectThani", remoteHandle);
      AV12ExperienciaLaboralListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>(com.projectthani.SdtSDTProfesionalExperienciaLaboral.class, "SDTProfesionalExperienciaLaboral", "ProjectThani", remoteHandle);
      AV14PremiosListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>(com.projectthani.SdtSDTProfesionalPremios.class, "SDTProfesionalPremios", "ProjectThani", remoteHandle);
      AV19ServiciosListItem = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>(com.projectthani.SdtSDTProfesionalServicios.class, "SDTProfesionalServicios", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005Y2_A43PaisId = new short[1] ;
      P005Y2_A31ProfesionalId = new int[1] ;
      P005Y2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P005Y2_A173ProfesionalTipoDocumento = new String[] {""} ;
      P005Y2_A174ProfesionalNroDocumento = new String[] {""} ;
      P005Y2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P005Y2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P005Y2_A84ProfesionalNombres = new String[] {""} ;
      P005Y2_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P005Y2_A177ProfesionalSexo = new String[] {""} ;
      P005Y2_A178ProfesionalDescripcion = new String[] {""} ;
      P005Y2_A179ProfesionalCorreo = new String[] {""} ;
      P005Y2_A88ProfesionalCOP = new String[] {""} ;
      P005Y2_A182ProfesionalTiempoCita = new byte[1] ;
      P005Y2_A183ProfesionalDireccion = new String[] {""} ;
      P005Y2_A184PaisDescripcion = new String[] {""} ;
      P005Y2_A189ProfesionalFoto = new String[] {""} ;
      P005Y2_A190ProfesionalTwitter = new String[] {""} ;
      P005Y2_A191ProfesionalFacebook = new String[] {""} ;
      P005Y2_A192ProfesionalInstagram = new String[] {""} ;
      P005Y2_A193ProfesionalLinkedin = new String[] {""} ;
      P005Y2_A194ProfesionalTelefono = new String[] {""} ;
      P005Y2_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P005Y2_A197ProfesionalEstadoCuenta = new String[] {""} ;
      P005Y2_A198ProfesionalEstado = new String[] {""} ;
      P005Y2_A44UbigeoCode = new String[] {""} ;
      P005Y2_A188UbigeoDistrito = new String[] {""} ;
      P005Y2_A187UbigeoProvincia = new String[] {""} ;
      P005Y2_A186UbigeoDepartamento = new String[] {""} ;
      A40000ProfesionalFoto_GXI = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A177ProfesionalSexo = "" ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A183ProfesionalDireccion = "" ;
      A184PaisDescripcion = "" ;
      A189ProfesionalFoto = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      A194ProfesionalTelefono = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      A44UbigeoCode = "" ;
      A188UbigeoDistrito = "" ;
      A187UbigeoProvincia = "" ;
      A186UbigeoDepartamento = "" ;
      A297UbigeoDistritoCode = "" ;
      A296UbigeoProvinciaCode = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A185UbigeoNombre = "" ;
      AV16ProfesionalItem = new com.projectthani.SdtSDTProfesionalInformacionGeneral(remoteHandle, context);
      P005Y3_A31ProfesionalId = new int[1] ;
      P005Y3_A32EspecialidadId = new short[1] ;
      P005Y3_A140EspecialidadCodigo = new String[] {""} ;
      P005Y3_A71EspecialidadNombre = new String[] {""} ;
      P005Y3_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P005Y3_A54SedeTipoConsulta = new String[] {""} ;
      P005Y3_A30SedeId = new short[1] ;
      P005Y3_A75SedeNombre = new String[] {""} ;
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      A54SedeTipoConsulta = "" ;
      A75SedeNombre = "" ;
      AV10EspecialidadItem = new com.projectthani.SdtSDTProfesionalEspecialidadSede(remoteHandle, context);
      P005Y4_A31ProfesionalId = new int[1] ;
      P005Y4_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P005Y4_A200EducacionNombreInstitucion = new String[] {""} ;
      P005Y4_A203EducacionPaisDescripcion = new String[] {""} ;
      P005Y4_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      P005Y4_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A200EducacionNombreInstitucion = "" ;
      A203EducacionPaisDescripcion = "" ;
      A201EducacionDesde = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      AV8EducacionItem = new com.projectthani.SdtSDTProfesionalEducacion(remoteHandle, context);
      P005Y5_A31ProfesionalId = new int[1] ;
      P005Y5_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P005Y5_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      P005Y5_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      P005Y5_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A204ExperienciaLaboralEmpresaNombre = "" ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      AV11ExperienciaLaboralItem = new com.projectthani.SdtSDTProfesionalExperienciaLaboral(remoteHandle, context);
      P005Y6_A31ProfesionalId = new int[1] ;
      P005Y6_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P005Y6_A207PremiosNombre = new String[] {""} ;
      P005Y6_A209PremiosDescripcion = new String[] {""} ;
      P005Y6_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A207PremiosNombre = "" ;
      A209PremiosDescripcion = "" ;
      A208PremiosFecha = GXutil.nullDate() ;
      AV13PremiosItem = new com.projectthani.SdtSDTProfesionalPremios(remoteHandle, context);
      P005Y7_A31ProfesionalId = new int[1] ;
      P005Y7_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P005Y7_A210ServiciosNombre = new String[] {""} ;
      A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A210ServiciosNombre = "" ;
      AV18ServiciosItem = new com.projectthani.SdtSDTProfesionalServicios(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcprofesionalinformaciondetallada__default(),
         new Object[] {
             new Object[] {
            P005Y2_A43PaisId, P005Y2_A31ProfesionalId, P005Y2_A40000ProfesionalFoto_GXI, P005Y2_A173ProfesionalTipoDocumento, P005Y2_A174ProfesionalNroDocumento, P005Y2_A85ProfesionalApellidoPaterno, P005Y2_A86ProfesionalApellidoMaterno, P005Y2_A84ProfesionalNombres, P005Y2_A176ProfesionalFechaNacimiento, P005Y2_A177ProfesionalSexo,
            P005Y2_A178ProfesionalDescripcion, P005Y2_A179ProfesionalCorreo, P005Y2_A88ProfesionalCOP, P005Y2_A182ProfesionalTiempoCita, P005Y2_A183ProfesionalDireccion, P005Y2_A184PaisDescripcion, P005Y2_A189ProfesionalFoto, P005Y2_A190ProfesionalTwitter, P005Y2_A191ProfesionalFacebook, P005Y2_A192ProfesionalInstagram,
            P005Y2_A193ProfesionalLinkedin, P005Y2_A194ProfesionalTelefono, P005Y2_A195ProfesionalFechaRegistro, P005Y2_A197ProfesionalEstadoCuenta, P005Y2_A198ProfesionalEstado, P005Y2_A44UbigeoCode, P005Y2_A188UbigeoDistrito, P005Y2_A187UbigeoProvincia, P005Y2_A186UbigeoDepartamento
            }
            , new Object[] {
            P005Y3_A31ProfesionalId, P005Y3_A32EspecialidadId, P005Y3_A140EspecialidadCodigo, P005Y3_A71EspecialidadNombre, P005Y3_A199CostoConsulta, P005Y3_A54SedeTipoConsulta, P005Y3_A30SedeId, P005Y3_A75SedeNombre
            }
            , new Object[] {
            P005Y4_A31ProfesionalId, P005Y4_A55EducacionId, P005Y4_A200EducacionNombreInstitucion, P005Y4_A203EducacionPaisDescripcion, P005Y4_A201EducacionDesde, P005Y4_A202EducacionHasta
            }
            , new Object[] {
            P005Y5_A31ProfesionalId, P005Y5_A56ExperienciaLaboralId, P005Y5_A204ExperienciaLaboralEmpresaNombre, P005Y5_A205ExperienciaLaboralDesde, P005Y5_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            P005Y6_A31ProfesionalId, P005Y6_A57PremiosId, P005Y6_A207PremiosNombre, P005Y6_A209PremiosDescripcion, P005Y6_A208PremiosFecha
            }
            , new Object[] {
            P005Y7_A31ProfesionalId, P005Y7_A58ServiciosId, P005Y7_A210ServiciosNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A182ProfesionalTiempoCita ;
   private short A43PaisId ;
   private short A32EspecialidadId ;
   private short A30SedeId ;
   private short Gx_err ;
   private int AV15ProfesionalId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal A199CostoConsulta ;
   private String scmdbuf ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A194ProfesionalTelefono ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
   private String A44UbigeoCode ;
   private String A54SedeTipoConsulta ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date A201EducacionDesde ;
   private java.util.Date A202EducacionHasta ;
   private java.util.Date A205ExperienciaLaboralDesde ;
   private java.util.Date A206ExperienciaLaboralHasta ;
   private java.util.Date A208PremiosFecha ;
   private String A209PremiosDescripcion ;
   private String A40000ProfesionalFoto_GXI ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A178ProfesionalDescripcion ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A183ProfesionalDireccion ;
   private String A184PaisDescripcion ;
   private String A190ProfesionalTwitter ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A193ProfesionalLinkedin ;
   private String A188UbigeoDistrito ;
   private String A187UbigeoProvincia ;
   private String A186UbigeoDepartamento ;
   private String A297UbigeoDistritoCode ;
   private String A296UbigeoProvinciaCode ;
   private String A295UbigeoDepartamentoCode ;
   private String A185UbigeoNombre ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A75SedeNombre ;
   private String A200EducacionNombreInstitucion ;
   private String A203EducacionPaisDescripcion ;
   private String A204ExperienciaLaboralEmpresaNombre ;
   private String A207PremiosNombre ;
   private String A210ServiciosNombre ;
   private String A189ProfesionalFoto ;
   private java.util.UUID A55EducacionId ;
   private java.util.UUID A56ExperienciaLaboralId ;
   private java.util.UUID A57PremiosId ;
   private java.util.UUID A58ServiciosId ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>[] aP6 ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>[] aP1 ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>[] aP2 ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>[] aP3 ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>[] aP4 ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P005Y2_A43PaisId ;
   private int[] P005Y2_A31ProfesionalId ;
   private String[] P005Y2_A40000ProfesionalFoto_GXI ;
   private String[] P005Y2_A173ProfesionalTipoDocumento ;
   private String[] P005Y2_A174ProfesionalNroDocumento ;
   private String[] P005Y2_A85ProfesionalApellidoPaterno ;
   private String[] P005Y2_A86ProfesionalApellidoMaterno ;
   private String[] P005Y2_A84ProfesionalNombres ;
   private java.util.Date[] P005Y2_A176ProfesionalFechaNacimiento ;
   private String[] P005Y2_A177ProfesionalSexo ;
   private String[] P005Y2_A178ProfesionalDescripcion ;
   private String[] P005Y2_A179ProfesionalCorreo ;
   private String[] P005Y2_A88ProfesionalCOP ;
   private byte[] P005Y2_A182ProfesionalTiempoCita ;
   private String[] P005Y2_A183ProfesionalDireccion ;
   private String[] P005Y2_A184PaisDescripcion ;
   private String[] P005Y2_A189ProfesionalFoto ;
   private String[] P005Y2_A190ProfesionalTwitter ;
   private String[] P005Y2_A191ProfesionalFacebook ;
   private String[] P005Y2_A192ProfesionalInstagram ;
   private String[] P005Y2_A193ProfesionalLinkedin ;
   private String[] P005Y2_A194ProfesionalTelefono ;
   private java.util.Date[] P005Y2_A195ProfesionalFechaRegistro ;
   private String[] P005Y2_A197ProfesionalEstadoCuenta ;
   private String[] P005Y2_A198ProfesionalEstado ;
   private String[] P005Y2_A44UbigeoCode ;
   private String[] P005Y2_A188UbigeoDistrito ;
   private String[] P005Y2_A187UbigeoProvincia ;
   private String[] P005Y2_A186UbigeoDepartamento ;
   private int[] P005Y3_A31ProfesionalId ;
   private short[] P005Y3_A32EspecialidadId ;
   private String[] P005Y3_A140EspecialidadCodigo ;
   private String[] P005Y3_A71EspecialidadNombre ;
   private java.math.BigDecimal[] P005Y3_A199CostoConsulta ;
   private String[] P005Y3_A54SedeTipoConsulta ;
   private short[] P005Y3_A30SedeId ;
   private String[] P005Y3_A75SedeNombre ;
   private int[] P005Y4_A31ProfesionalId ;
   private java.util.UUID[] P005Y4_A55EducacionId ;
   private String[] P005Y4_A200EducacionNombreInstitucion ;
   private String[] P005Y4_A203EducacionPaisDescripcion ;
   private java.util.Date[] P005Y4_A201EducacionDesde ;
   private java.util.Date[] P005Y4_A202EducacionHasta ;
   private int[] P005Y5_A31ProfesionalId ;
   private java.util.UUID[] P005Y5_A56ExperienciaLaboralId ;
   private String[] P005Y5_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] P005Y5_A205ExperienciaLaboralDesde ;
   private java.util.Date[] P005Y5_A206ExperienciaLaboralHasta ;
   private int[] P005Y6_A31ProfesionalId ;
   private java.util.UUID[] P005Y6_A57PremiosId ;
   private String[] P005Y6_A207PremiosNombre ;
   private String[] P005Y6_A209PremiosDescripcion ;
   private java.util.Date[] P005Y6_A208PremiosFecha ;
   private int[] P005Y7_A31ProfesionalId ;
   private java.util.UUID[] P005Y7_A58ServiciosId ;
   private String[] P005Y7_A210ServiciosNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> AV9EducacionListItem ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> AV20EspecialidadListItem ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> AV12ExperienciaLaboralListItem ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> AV14PremiosListItem ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral> AV17ProfesionalListItem ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> AV19ServiciosListItem ;
   private com.projectthani.SdtSDTProfesionalEducacion AV8EducacionItem ;
   private com.projectthani.SdtSDTProfesionalEspecialidadSede AV10EspecialidadItem ;
   private com.projectthani.SdtSDTProfesionalExperienciaLaboral AV11ExperienciaLaboralItem ;
   private com.projectthani.SdtSDTProfesionalPremios AV13PremiosItem ;
   private com.projectthani.SdtSDTProfesionalInformacionGeneral AV16ProfesionalItem ;
   private com.projectthani.SdtSDTProfesionalServicios AV18ServiciosItem ;
}

final  class prcprofesionalinformaciondetallada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005Y2", "SELECT T1.[PaisId], T1.[ProfesionalId], T1.[ProfesionalFoto_GXI], T1.[ProfesionalTipoDocumento], T1.[ProfesionalNroDocumento], T1.[ProfesionalApellidoPaterno], T1.[ProfesionalApellidoMaterno], T1.[ProfesionalNombres], T1.[ProfesionalFechaNacimiento], T1.[ProfesionalSexo], T1.[ProfesionalDescripcion], T1.[ProfesionalCorreo], T1.[ProfesionalCOP], T1.[ProfesionalTiempoCita], T1.[ProfesionalDireccion], T2.[PaisDescripcion], T1.[ProfesionalFoto], T1.[ProfesionalTwitter], T1.[ProfesionalFacebook], T1.[ProfesionalInstagram], T1.[ProfesionalLinkedin], T1.[ProfesionalTelefono], T1.[ProfesionalFechaRegistro], T1.[ProfesionalEstadoCuenta], T1.[ProfesionalEstado], T1.[UbigeoCode], T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Profesional] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = T1.[UbigeoCode]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P005Y3", "SELECT T1.[ProfesionalId], T1.[EspecialidadId], T2.[EspecialidadCodigo], T2.[EspecialidadNombre], T3.[CostoConsulta], T3.[SedeTipoConsulta], T3.[SedeId], T4.[SedeNombre] FROM ((([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [ProfesionalEspecialidadSede] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId] AND T3.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T3.[SedeId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Y4", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionPaisDescripcion], [EducacionDesde], [EducacionHasta] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Y5", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Y6", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosDescripcion], [PremiosFecha] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Y7", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(3));
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((String[]) buf[23])[0] = rslt.getString(24, 2);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 10);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

