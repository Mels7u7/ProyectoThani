package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpprofesionaldisponibilidad extends GXProcedure
{
   public dpprofesionaldisponibilidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpprofesionaldisponibilidad.class ), "" );
   }

   public dpprofesionaldisponibilidad( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesional> executeUdp( short aP0 )
   {
      dpprofesionaldisponibilidad.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesional>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesional>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesional>[] aP1 )
   {
      dpprofesionaldisponibilidad.this.AV6ClinicaId = aP0;
      dpprofesionaldisponibilidad.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000F2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV6ClinicaId), Short.valueOf(AV6ClinicaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk0F2 = false ;
         A54SedeTipoConsulta = P000F2_A54SedeTipoConsulta[0] ;
         A30SedeId = P000F2_A30SedeId[0] ;
         A31ProfesionalId = P000F2_A31ProfesionalId[0] ;
         A32EspecialidadId = P000F2_A32EspecialidadId[0] ;
         A140EspecialidadCodigo = P000F2_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P000F2_A71EspecialidadNombre[0] ;
         A28ClinicaId = P000F2_A28ClinicaId[0] ;
         A198ProfesionalEstado = P000F2_A198ProfesionalEstado[0] ;
         A40000ProfesionalFoto_GXI = P000F2_A40000ProfesionalFoto_GXI[0] ;
         A173ProfesionalTipoDocumento = P000F2_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = P000F2_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = P000F2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P000F2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P000F2_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = P000F2_A176ProfesionalFechaNacimiento[0] ;
         A179ProfesionalCorreo = P000F2_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = P000F2_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = P000F2_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = P000F2_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = P000F2_A182ProfesionalTiempoCita[0] ;
         A189ProfesionalFoto = P000F2_A189ProfesionalFoto[0] ;
         A28ClinicaId = P000F2_A28ClinicaId[0] ;
         A198ProfesionalEstado = P000F2_A198ProfesionalEstado[0] ;
         A40000ProfesionalFoto_GXI = P000F2_A40000ProfesionalFoto_GXI[0] ;
         A173ProfesionalTipoDocumento = P000F2_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = P000F2_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = P000F2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P000F2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P000F2_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = P000F2_A176ProfesionalFechaNacimiento[0] ;
         A179ProfesionalCorreo = P000F2_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = P000F2_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = P000F2_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = P000F2_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = P000F2_A182ProfesionalTiempoCita[0] ;
         A189ProfesionalFoto = P000F2_A189ProfesionalFoto[0] ;
         A140EspecialidadCodigo = P000F2_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P000F2_A71EspecialidadNombre[0] ;
         Gxm1sdtprofesional = (com.projectthani.SdtSDTProfesional)new com.projectthani.SdtSDTProfesional(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtprofesional, 0);
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalid( A31ProfesionalId );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionaltipodocumento( A173ProfesionalTipoDocumento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalnrodocumento( A174ProfesionalNroDocumento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalnombres( A84ProfesionalNombres );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfullname( A85ProfesionalApellidoPaterno+" "+A86ProfesionalApellidoMaterno+", "+A84ProfesionalNombres );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfechanacimiento( A176ProfesionalFechaNacimiento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcorreo( A179ProfesionalCorreo );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcop( A88ProfesionalCOP );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcolordisponible( A180ProfesionalColorDisponible );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcolorcita( A181ProfesionalColorCita );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionaltiempocita( A182ProfesionalTiempoCita );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalestado( A198ProfesionalEstado );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfoto( A189ProfesionalFoto );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfoto_gxi( A40000ProfesionalFoto_GXI );
         while ( (pr_default.getStatus(0) != 101) && ( P000F2_A31ProfesionalId[0] == A31ProfesionalId ) && ( P000F2_A32EspecialidadId[0] == A32EspecialidadId ) && ( P000F2_A30SedeId[0] == A30SedeId ) && ( GXutil.strcmp(P000F2_A54SedeTipoConsulta[0], A54SedeTipoConsulta) == 0 ) )
         {
            brk0F2 = false ;
            A140EspecialidadCodigo = P000F2_A140EspecialidadCodigo[0] ;
            A71EspecialidadNombre = P000F2_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = P000F2_A140EspecialidadCodigo[0] ;
            A71EspecialidadNombre = P000F2_A71EspecialidadNombre[0] ;
            Gxm3sdtprofesional_especialidad = (com.projectthani.SdtSDTProfesional_EspecialidadItem)new com.projectthani.SdtSDTProfesional_EspecialidadItem(remoteHandle, context);
            Gxm1sdtprofesional.getgxTv_SdtSDTProfesional_Especialidad().add(Gxm3sdtprofesional_especialidad, 0);
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid( A32EspecialidadId );
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo( A140EspecialidadCodigo );
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre( A71EspecialidadNombre );
            brk0F2 = true ;
            pr_default.readNext(0);
         }
         if ( ! brk0F2 )
         {
            brk0F2 = true ;
            pr_default.readNext(0);
         }
      }
      /* Using cursor P000F3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV6ClinicaId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A31ProfesionalId = P000F3_A31ProfesionalId[0] ;
         A198ProfesionalEstado = P000F3_A198ProfesionalEstado[0] ;
         A40000ProfesionalFoto_GXI = P000F3_A40000ProfesionalFoto_GXI[0] ;
         A173ProfesionalTipoDocumento = P000F3_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = P000F3_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = P000F3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P000F3_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P000F3_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = P000F3_A176ProfesionalFechaNacimiento[0] ;
         A179ProfesionalCorreo = P000F3_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = P000F3_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = P000F3_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = P000F3_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = P000F3_A182ProfesionalTiempoCita[0] ;
         A189ProfesionalFoto = P000F3_A189ProfesionalFoto[0] ;
         Gxm1sdtprofesional = (com.projectthani.SdtSDTProfesional)new com.projectthani.SdtSDTProfesional(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtprofesional, 0);
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalid( A31ProfesionalId );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionaltipodocumento( A173ProfesionalTipoDocumento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalnrodocumento( A174ProfesionalNroDocumento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalnombres( A84ProfesionalNombres );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfullname( A85ProfesionalApellidoPaterno+" "+A86ProfesionalApellidoMaterno+", "+A84ProfesionalNombres );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfechanacimiento( A176ProfesionalFechaNacimiento );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcorreo( A179ProfesionalCorreo );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcop( A88ProfesionalCOP );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcolordisponible( A180ProfesionalColorDisponible );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalcolorcita( A181ProfesionalColorCita );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionaltiempocita( A182ProfesionalTiempoCita );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalestado( A198ProfesionalEstado );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfoto( A189ProfesionalFoto );
         Gxm1sdtprofesional.setgxTv_SdtSDTProfesional_Profesionalfoto_gxi( A40000ProfesionalFoto_GXI );
         /* Using cursor P000F4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A32EspecialidadId = P000F4_A32EspecialidadId[0] ;
            A140EspecialidadCodigo = P000F4_A140EspecialidadCodigo[0] ;
            A71EspecialidadNombre = P000F4_A71EspecialidadNombre[0] ;
            A140EspecialidadCodigo = P000F4_A140EspecialidadCodigo[0] ;
            A71EspecialidadNombre = P000F4_A71EspecialidadNombre[0] ;
            Gxm3sdtprofesional_especialidad = (com.projectthani.SdtSDTProfesional_EspecialidadItem)new com.projectthani.SdtSDTProfesional_EspecialidadItem(remoteHandle, context);
            Gxm1sdtprofesional.getgxTv_SdtSDTProfesional_Especialidad().add(Gxm3sdtprofesional_especialidad, 0);
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadid( A32EspecialidadId );
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadcodigo( A140EspecialidadCodigo );
            Gxm3sdtprofesional_especialidad.setgxTv_SdtSDTProfesional_EspecialidadItem_Especialidadnombre( A71EspecialidadNombre );
            pr_default.readNext(2);
         }
         pr_default.close(2);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dpprofesionaldisponibilidad.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(0);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTProfesional>(com.projectthani.SdtSDTProfesional.class, "SDTProfesional", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000F2_A54SedeTipoConsulta = new String[] {""} ;
      P000F2_A30SedeId = new short[1] ;
      P000F2_A31ProfesionalId = new int[1] ;
      P000F2_A32EspecialidadId = new short[1] ;
      P000F2_A140EspecialidadCodigo = new String[] {""} ;
      P000F2_A71EspecialidadNombre = new String[] {""} ;
      P000F2_A28ClinicaId = new short[1] ;
      P000F2_A198ProfesionalEstado = new String[] {""} ;
      P000F2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P000F2_A173ProfesionalTipoDocumento = new String[] {""} ;
      P000F2_A174ProfesionalNroDocumento = new String[] {""} ;
      P000F2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P000F2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P000F2_A84ProfesionalNombres = new String[] {""} ;
      P000F2_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P000F2_A179ProfesionalCorreo = new String[] {""} ;
      P000F2_A88ProfesionalCOP = new String[] {""} ;
      P000F2_A180ProfesionalColorDisponible = new String[] {""} ;
      P000F2_A181ProfesionalColorCita = new String[] {""} ;
      P000F2_A182ProfesionalTiempoCita = new byte[1] ;
      P000F2_A189ProfesionalFoto = new String[] {""} ;
      A54SedeTipoConsulta = "" ;
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A198ProfesionalEstado = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A189ProfesionalFoto = "" ;
      Gxm1sdtprofesional = new com.projectthani.SdtSDTProfesional(remoteHandle, context);
      Gxm3sdtprofesional_especialidad = new com.projectthani.SdtSDTProfesional_EspecialidadItem(remoteHandle, context);
      P000F3_A31ProfesionalId = new int[1] ;
      P000F3_A198ProfesionalEstado = new String[] {""} ;
      P000F3_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P000F3_A173ProfesionalTipoDocumento = new String[] {""} ;
      P000F3_A174ProfesionalNroDocumento = new String[] {""} ;
      P000F3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P000F3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P000F3_A84ProfesionalNombres = new String[] {""} ;
      P000F3_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P000F3_A179ProfesionalCorreo = new String[] {""} ;
      P000F3_A88ProfesionalCOP = new String[] {""} ;
      P000F3_A180ProfesionalColorDisponible = new String[] {""} ;
      P000F3_A181ProfesionalColorCita = new String[] {""} ;
      P000F3_A182ProfesionalTiempoCita = new byte[1] ;
      P000F3_A189ProfesionalFoto = new String[] {""} ;
      P000F4_A31ProfesionalId = new int[1] ;
      P000F4_A32EspecialidadId = new short[1] ;
      P000F4_A140EspecialidadCodigo = new String[] {""} ;
      P000F4_A71EspecialidadNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpprofesionaldisponibilidad__default(),
         new Object[] {
             new Object[] {
            P000F2_A54SedeTipoConsulta, P000F2_A30SedeId, P000F2_A31ProfesionalId, P000F2_A32EspecialidadId, P000F2_A140EspecialidadCodigo, P000F2_A71EspecialidadNombre, P000F2_A28ClinicaId, P000F2_A198ProfesionalEstado, P000F2_A40000ProfesionalFoto_GXI, P000F2_A173ProfesionalTipoDocumento,
            P000F2_A174ProfesionalNroDocumento, P000F2_A85ProfesionalApellidoPaterno, P000F2_A86ProfesionalApellidoMaterno, P000F2_A84ProfesionalNombres, P000F2_A176ProfesionalFechaNacimiento, P000F2_A179ProfesionalCorreo, P000F2_A88ProfesionalCOP, P000F2_A180ProfesionalColorDisponible, P000F2_A181ProfesionalColorCita, P000F2_A182ProfesionalTiempoCita,
            P000F2_A189ProfesionalFoto
            }
            , new Object[] {
            P000F3_A31ProfesionalId, P000F3_A198ProfesionalEstado, P000F3_A40000ProfesionalFoto_GXI, P000F3_A173ProfesionalTipoDocumento, P000F3_A174ProfesionalNroDocumento, P000F3_A85ProfesionalApellidoPaterno, P000F3_A86ProfesionalApellidoMaterno, P000F3_A84ProfesionalNombres, P000F3_A176ProfesionalFechaNacimiento, P000F3_A179ProfesionalCorreo,
            P000F3_A88ProfesionalCOP, P000F3_A180ProfesionalColorDisponible, P000F3_A181ProfesionalColorCita, P000F3_A182ProfesionalTiempoCita, P000F3_A189ProfesionalFoto
            }
            , new Object[] {
            P000F4_A31ProfesionalId, P000F4_A32EspecialidadId, P000F4_A140EspecialidadCodigo, P000F4_A71EspecialidadNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A182ProfesionalTiempoCita ;
   private short AV6ClinicaId ;
   private short A30SedeId ;
   private short A32EspecialidadId ;
   private short A28ClinicaId ;
   private short Gx_err ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A54SedeTipoConsulta ;
   private String A198ProfesionalEstado ;
   private String A173ProfesionalTipoDocumento ;
   private String A180ProfesionalColorDisponible ;
   private String A181ProfesionalColorCita ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private boolean brk0F2 ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A40000ProfesionalFoto_GXI ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A189ProfesionalFoto ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesional>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P000F2_A54SedeTipoConsulta ;
   private short[] P000F2_A30SedeId ;
   private int[] P000F2_A31ProfesionalId ;
   private short[] P000F2_A32EspecialidadId ;
   private String[] P000F2_A140EspecialidadCodigo ;
   private String[] P000F2_A71EspecialidadNombre ;
   private short[] P000F2_A28ClinicaId ;
   private String[] P000F2_A198ProfesionalEstado ;
   private String[] P000F2_A40000ProfesionalFoto_GXI ;
   private String[] P000F2_A173ProfesionalTipoDocumento ;
   private String[] P000F2_A174ProfesionalNroDocumento ;
   private String[] P000F2_A85ProfesionalApellidoPaterno ;
   private String[] P000F2_A86ProfesionalApellidoMaterno ;
   private String[] P000F2_A84ProfesionalNombres ;
   private java.util.Date[] P000F2_A176ProfesionalFechaNacimiento ;
   private String[] P000F2_A179ProfesionalCorreo ;
   private String[] P000F2_A88ProfesionalCOP ;
   private String[] P000F2_A180ProfesionalColorDisponible ;
   private String[] P000F2_A181ProfesionalColorCita ;
   private byte[] P000F2_A182ProfesionalTiempoCita ;
   private String[] P000F2_A189ProfesionalFoto ;
   private int[] P000F3_A31ProfesionalId ;
   private String[] P000F3_A198ProfesionalEstado ;
   private String[] P000F3_A40000ProfesionalFoto_GXI ;
   private String[] P000F3_A173ProfesionalTipoDocumento ;
   private String[] P000F3_A174ProfesionalNroDocumento ;
   private String[] P000F3_A85ProfesionalApellidoPaterno ;
   private String[] P000F3_A86ProfesionalApellidoMaterno ;
   private String[] P000F3_A84ProfesionalNombres ;
   private java.util.Date[] P000F3_A176ProfesionalFechaNacimiento ;
   private String[] P000F3_A179ProfesionalCorreo ;
   private String[] P000F3_A88ProfesionalCOP ;
   private String[] P000F3_A180ProfesionalColorDisponible ;
   private String[] P000F3_A181ProfesionalColorCita ;
   private byte[] P000F3_A182ProfesionalTiempoCita ;
   private String[] P000F3_A189ProfesionalFoto ;
   private int[] P000F4_A31ProfesionalId ;
   private short[] P000F4_A32EspecialidadId ;
   private String[] P000F4_A140EspecialidadCodigo ;
   private String[] P000F4_A71EspecialidadNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesional> Gxm2rootcol ;
   private com.projectthani.SdtSDTProfesional Gxm1sdtprofesional ;
   private com.projectthani.SdtSDTProfesional_EspecialidadItem Gxm3sdtprofesional_especialidad ;
}

final  class dpprofesionaldisponibilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000F2", "SELECT T1.[SedeTipoConsulta], T1.[SedeId], T1.[ProfesionalId], T1.[EspecialidadId], T4.[EspecialidadCodigo], T4.[EspecialidadNombre], T2.[ClinicaId], T3.[ProfesionalEstado], T3.[ProfesionalFoto_GXI], T3.[ProfesionalTipoDocumento], T3.[ProfesionalNroDocumento], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno], T3.[ProfesionalNombres], T3.[ProfesionalFechaNacimiento], T3.[ProfesionalCorreo], T3.[ProfesionalCOP], T3.[ProfesionalColorDisponible], T3.[ProfesionalColorCita], T3.[ProfesionalTiempoCita], T3.[ProfesionalFoto] FROM ((([ProfesionalEspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SedeId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T1.[EspecialidadId]) WHERE (? > 0) AND (T3.[ProfesionalEstado] = 'A') AND (T2.[ClinicaId] = ?) ORDER BY T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeId], T1.[SedeTipoConsulta] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000F3", "SELECT [ProfesionalId], [ProfesionalEstado], [ProfesionalFoto_GXI], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalFoto] FROM [Profesional] WHERE (? = 0) AND ([ProfesionalEstado] = 'A') ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P000F4", "SELECT T1.[ProfesionalId], T1.[EspecialidadId], T2.[EspecialidadCodigo], T2.[EspecialidadNombre] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((byte[]) buf[19])[0] = rslt.getByte(20);
               ((String[]) buf[20])[0] = rslt.getMultimediaFile(21, rslt.getVarchar(9));
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getMultimediaFile(15, rslt.getVarchar(3));
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

