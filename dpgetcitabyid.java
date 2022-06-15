package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgetcitabyid extends GXProcedure
{
   public dpgetcitabyid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgetcitabyid.class ), "" );
   }

   public dpgetcitabyid( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSDTCitaData executeUdp( int aP0 )
   {
      dpgetcitabyid.this.aP1 = new com.projectthani.SdtSDTCitaData[] {new com.projectthani.SdtSDTCitaData()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.projectthani.SdtSDTCitaData[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.projectthani.SdtSDTCitaData[] aP1 )
   {
      dpgetcitabyid.this.AV5CitaId = aP0;
      dpgetcitabyid.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = P000K2_A19CitaId[0] ;
         A64CitaCode = P000K2_A64CitaCode[0] ;
         A20PacienteId = P000K2_A20PacienteId[0] ;
         A103PacienteApellidoPaterno = P000K2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P000K2_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = P000K2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P000K2_A106PacienteNroDocumento[0] ;
         A65CitaTipoDiagnostico = P000K2_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = P000K2_n65CitaTipoDiagnostico[0] ;
         A21SGCitaDisponibilidadId = P000K2_A21SGCitaDisponibilidadId[0] ;
         A66SGCitaDisponibilidadFecha = P000K2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P000K2_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = P000K2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P000K2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = P000K2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P000K2_n387SGCitaDisponibilidadHoraFin[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P000K2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P000K2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A72SGCitaDisponibilidadSedeId = P000K2_A72SGCitaDisponibilidadSedeId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P000K2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P000K2_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P000K2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A81SGCitaDisponibilidadProfesionalId = P000K2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A87SGCitaDisponibilidadProCOP = P000K2_A87SGCitaDisponibilidadProCOP[0] ;
         A89CitaEstadoCita = P000K2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P000K2_n89CitaEstadoCita[0] ;
         A90CitaInforme = P000K2_A90CitaInforme[0] ;
         n90CitaInforme = P000K2_n90CitaInforme[0] ;
         A100CitaAntecedentes = P000K2_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = P000K2_n100CitaAntecedentes[0] ;
         A91CitaLink = P000K2_A91CitaLink[0] ;
         n91CitaLink = P000K2_n91CitaLink[0] ;
         A92CitaFechaReserva = P000K2_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = P000K2_n92CitaFechaReserva[0] ;
         A93CitaLog = P000K2_A93CitaLog[0] ;
         n93CitaLog = P000K2_n93CitaLog[0] ;
         A94CitaEmailGenLink = P000K2_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = P000K2_n94CitaEmailGenLink[0] ;
         A95CitaEstado = P000K2_A95CitaEstado[0] ;
         n95CitaEstado = P000K2_n95CitaEstado[0] ;
         A99CitaMotivoConsulta = P000K2_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = P000K2_n99CitaMotivoConsulta[0] ;
         A96CitaArchivoNombre = P000K2_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = P000K2_n96CitaArchivoNombre[0] ;
         A98CitaArchivo = P000K2_A98CitaArchivo[0] ;
         n98CitaArchivo = P000K2_n98CitaArchivo[0] ;
         A97CitaConsentimiento = P000K2_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = P000K2_n97CitaConsentimiento[0] ;
         A101CitaGestante = P000K2_A101CitaGestante[0] ;
         n101CitaGestante = P000K2_n101CitaGestante[0] ;
         A102CitaEstadoPago = P000K2_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P000K2_n102CitaEstadoPago[0] ;
         A306CitaPeso = P000K2_A306CitaPeso[0] ;
         n306CitaPeso = P000K2_n306CitaPeso[0] ;
         A307CitaEstatura = P000K2_A307CitaEstatura[0] ;
         n307CitaEstatura = P000K2_n307CitaEstatura[0] ;
         A86ProfesionalApellidoMaterno = P000K2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P000K2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P000K2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P000K2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P000K2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P000K2_n84ProfesionalNombres[0] ;
         A103PacienteApellidoPaterno = P000K2_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = P000K2_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = P000K2_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = P000K2_A106PacienteNroDocumento[0] ;
         A66SGCitaDisponibilidadFecha = P000K2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P000K2_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = P000K2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P000K2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = P000K2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P000K2_n387SGCitaDisponibilidadHoraFin[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P000K2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P000K2_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P000K2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P000K2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P000K2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P000K2_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P000K2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A87SGCitaDisponibilidadProCOP = P000K2_A87SGCitaDisponibilidadProCOP[0] ;
         A86ProfesionalApellidoMaterno = P000K2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P000K2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P000K2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P000K2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P000K2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P000K2_n84ProfesionalNombres[0] ;
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaid( A19CitaId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citacode( A64CitaCode );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Pacienteid( A20PacienteId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Pacienteapellidopaterno( A103PacienteApellidoPaterno );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Pacienteapellidomaterno( A104PacienteApellidoMaterno );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Pacientenombres( A105PacienteNombres );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Pacientenrodocumento( A106PacienteNroDocumento );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Diagnosticoid( A23DiagnosticoId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Diagnosticocodigo( A107DiagnosticoCodigo );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Diagnosticodescripcion( A108DiagnosticoDescripcion );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citatipodiagnostico( A65CitaTipoDiagnostico );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadid( A21SGCitaDisponibilidadId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadfecha( A66SGCitaDisponibilidadFecha );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorainicio( A68SGCitaDisponibilidadHoraInicio );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadhorafin( A387SGCitaDisponibilidadHoraFin );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadid( A70SGCitaDisponibilidadEspecialidadId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( A146SGCitaDisponibilidadEspecialidadNombre );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedeid( A72SGCitaDisponibilidadSedeId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadsedenombre( A73SGCitaDisponibilidadSedeNombre );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicaid( A76SGCitaDisponibilidadClinicaId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadclinicanombre( A78SGCitaDisponibilidadClinicaNombre );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofesionalid( A81SGCitaDisponibilidadProfesionalId );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprofullname( A82SGCitaDisponibilidadProFullName );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadprocop( A87SGCitaDisponibilidadProCOP );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaestadocita( A89CitaEstadoCita );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citainforme( A90CitaInforme );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaantecedentes( A100CitaAntecedentes );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citalink( A91CitaLink );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citafechareserva( A92CitaFechaReserva );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citalog( A93CitaLog );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaemailgenlink( A94CitaEmailGenLink );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaestado( A95CitaEstado );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citamotivoconsulta( A99CitaMotivoConsulta );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaarchivonombre( A96CitaArchivoNombre );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaarchivo( A98CitaArchivo );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaconsentimiento( A97CitaConsentimiento );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citagestante( A101CitaGestante );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaestadopago( A102CitaEstadoPago );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citapeso( A306CitaPeso );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaestatura( A307CitaEstatura );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citapesodescripcion( GXutil.str( A306CitaPeso, 6, 2)+" kg" );
         Gxm1sdtcitadata.setgxTv_SdtSDTCitaData_Citaestaturadescripcion( GXutil.str( A307CitaEstatura, 4, 2)+" m" );
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dpgetcitabyid.this.Gxm1sdtcitadata;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1sdtcitadata = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      scmdbuf = "" ;
      P000K2_A19CitaId = new int[1] ;
      P000K2_A64CitaCode = new String[] {""} ;
      P000K2_A20PacienteId = new int[1] ;
      P000K2_A103PacienteApellidoPaterno = new String[] {""} ;
      P000K2_A104PacienteApellidoMaterno = new String[] {""} ;
      P000K2_A105PacienteNombres = new String[] {""} ;
      P000K2_A106PacienteNroDocumento = new String[] {""} ;
      P000K2_A65CitaTipoDiagnostico = new String[] {""} ;
      P000K2_n65CitaTipoDiagnostico = new boolean[] {false} ;
      P000K2_A21SGCitaDisponibilidadId = new int[1] ;
      P000K2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P000K2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P000K2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P000K2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P000K2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P000K2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P000K2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P000K2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P000K2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P000K2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P000K2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P000K2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P000K2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P000K2_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      P000K2_A89CitaEstadoCita = new String[] {""} ;
      P000K2_n89CitaEstadoCita = new boolean[] {false} ;
      P000K2_A90CitaInforme = new String[] {""} ;
      P000K2_n90CitaInforme = new boolean[] {false} ;
      P000K2_A100CitaAntecedentes = new String[] {""} ;
      P000K2_n100CitaAntecedentes = new boolean[] {false} ;
      P000K2_A91CitaLink = new String[] {""} ;
      P000K2_n91CitaLink = new boolean[] {false} ;
      P000K2_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      P000K2_n92CitaFechaReserva = new boolean[] {false} ;
      P000K2_A93CitaLog = new String[] {""} ;
      P000K2_n93CitaLog = new boolean[] {false} ;
      P000K2_A94CitaEmailGenLink = new String[] {""} ;
      P000K2_n94CitaEmailGenLink = new boolean[] {false} ;
      P000K2_A95CitaEstado = new String[] {""} ;
      P000K2_n95CitaEstado = new boolean[] {false} ;
      P000K2_A99CitaMotivoConsulta = new String[] {""} ;
      P000K2_n99CitaMotivoConsulta = new boolean[] {false} ;
      P000K2_A96CitaArchivoNombre = new String[] {""} ;
      P000K2_n96CitaArchivoNombre = new boolean[] {false} ;
      P000K2_A98CitaArchivo = new String[] {""} ;
      P000K2_n98CitaArchivo = new boolean[] {false} ;
      P000K2_A97CitaConsentimiento = new boolean[] {false} ;
      P000K2_n97CitaConsentimiento = new boolean[] {false} ;
      P000K2_A101CitaGestante = new boolean[] {false} ;
      P000K2_n101CitaGestante = new boolean[] {false} ;
      P000K2_A102CitaEstadoPago = new String[] {""} ;
      P000K2_n102CitaEstadoPago = new boolean[] {false} ;
      P000K2_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P000K2_n306CitaPeso = new boolean[] {false} ;
      P000K2_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P000K2_n307CitaEstatura = new boolean[] {false} ;
      P000K2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P000K2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P000K2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P000K2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P000K2_A84ProfesionalNombres = new String[] {""} ;
      P000K2_n84ProfesionalNombres = new boolean[] {false} ;
      A64CitaCode = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A65CitaTipoDiagnostico = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A89CitaEstadoCita = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      A93CitaLog = "" ;
      A94CitaEmailGenLink = "" ;
      A95CitaEstado = "" ;
      A99CitaMotivoConsulta = "" ;
      A96CitaArchivoNombre = "" ;
      A98CitaArchivo = "" ;
      A102CitaEstadoPago = "" ;
      A306CitaPeso = DecimalUtil.ZERO ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A84ProfesionalNombres = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgetcitabyid__default(),
         new Object[] {
             new Object[] {
            P000K2_A19CitaId, P000K2_A64CitaCode, P000K2_A20PacienteId, P000K2_A103PacienteApellidoPaterno, P000K2_A104PacienteApellidoMaterno, P000K2_A105PacienteNombres, P000K2_A106PacienteNroDocumento, P000K2_A65CitaTipoDiagnostico, P000K2_n65CitaTipoDiagnostico, P000K2_A21SGCitaDisponibilidadId,
            P000K2_A66SGCitaDisponibilidadFecha, P000K2_n66SGCitaDisponibilidadFecha, P000K2_A68SGCitaDisponibilidadHoraInicio, P000K2_n68SGCitaDisponibilidadHoraInicio, P000K2_A387SGCitaDisponibilidadHoraFin, P000K2_n387SGCitaDisponibilidadHoraFin, P000K2_A70SGCitaDisponibilidadEspecialidadId, P000K2_A146SGCitaDisponibilidadEspecialidadNombre, P000K2_A72SGCitaDisponibilidadSedeId, P000K2_A73SGCitaDisponibilidadSedeNombre,
            P000K2_A76SGCitaDisponibilidadClinicaId, P000K2_A78SGCitaDisponibilidadClinicaNombre, P000K2_A81SGCitaDisponibilidadProfesionalId, P000K2_A87SGCitaDisponibilidadProCOP, P000K2_A89CitaEstadoCita, P000K2_n89CitaEstadoCita, P000K2_A90CitaInforme, P000K2_n90CitaInforme, P000K2_A100CitaAntecedentes, P000K2_n100CitaAntecedentes,
            P000K2_A91CitaLink, P000K2_n91CitaLink, P000K2_A92CitaFechaReserva, P000K2_n92CitaFechaReserva, P000K2_A93CitaLog, P000K2_n93CitaLog, P000K2_A94CitaEmailGenLink, P000K2_n94CitaEmailGenLink, P000K2_A95CitaEstado, P000K2_n95CitaEstado,
            P000K2_A99CitaMotivoConsulta, P000K2_n99CitaMotivoConsulta, P000K2_A96CitaArchivoNombre, P000K2_n96CitaArchivoNombre, P000K2_A98CitaArchivo, P000K2_n98CitaArchivo, P000K2_A97CitaConsentimiento, P000K2_n97CitaConsentimiento, P000K2_A101CitaGestante, P000K2_n101CitaGestante,
            P000K2_A102CitaEstadoPago, P000K2_n102CitaEstadoPago, P000K2_A306CitaPeso, P000K2_n306CitaPeso, P000K2_A307CitaEstatura, P000K2_n307CitaEstatura, P000K2_A86ProfesionalApellidoMaterno, P000K2_n86ProfesionalApellidoMaterno, P000K2_A85ProfesionalApellidoPaterno, P000K2_n85ProfesionalApellidoPaterno,
            P000K2_A84ProfesionalNombres, P000K2_n84ProfesionalNombres
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short Gx_err ;
   private int AV5CitaId ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A23DiagnosticoId ;
   private java.math.BigDecimal A306CitaPeso ;
   private java.math.BigDecimal A307CitaEstatura ;
   private String scmdbuf ;
   private String A89CitaEstadoCita ;
   private String A95CitaEstado ;
   private String A102CitaEstadoPago ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A92CitaFechaReserva ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n89CitaEstadoCita ;
   private boolean n90CitaInforme ;
   private boolean n100CitaAntecedentes ;
   private boolean n91CitaLink ;
   private boolean n92CitaFechaReserva ;
   private boolean n93CitaLog ;
   private boolean n94CitaEmailGenLink ;
   private boolean n95CitaEstado ;
   private boolean n99CitaMotivoConsulta ;
   private boolean n96CitaArchivoNombre ;
   private boolean n98CitaArchivo ;
   private boolean A97CitaConsentimiento ;
   private boolean n97CitaConsentimiento ;
   private boolean A101CitaGestante ;
   private boolean n101CitaGestante ;
   private boolean n102CitaEstadoPago ;
   private boolean n306CitaPeso ;
   private boolean n307CitaEstatura ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String A99CitaMotivoConsulta ;
   private String A98CitaArchivo ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A65CitaTipoDiagnostico ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A91CitaLink ;
   private String A93CitaLog ;
   private String A94CitaEmailGenLink ;
   private String A96CitaArchivoNombre ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A84ProfesionalNombres ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private com.projectthani.SdtSDTCitaData[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P000K2_A19CitaId ;
   private String[] P000K2_A64CitaCode ;
   private int[] P000K2_A20PacienteId ;
   private String[] P000K2_A103PacienteApellidoPaterno ;
   private String[] P000K2_A104PacienteApellidoMaterno ;
   private String[] P000K2_A105PacienteNombres ;
   private String[] P000K2_A106PacienteNroDocumento ;
   private String[] P000K2_A65CitaTipoDiagnostico ;
   private boolean[] P000K2_n65CitaTipoDiagnostico ;
   private int[] P000K2_A21SGCitaDisponibilidadId ;
   private java.util.Date[] P000K2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P000K2_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] P000K2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P000K2_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P000K2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P000K2_n387SGCitaDisponibilidadHoraFin ;
   private short[] P000K2_A70SGCitaDisponibilidadEspecialidadId ;
   private String[] P000K2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] P000K2_A72SGCitaDisponibilidadSedeId ;
   private String[] P000K2_A73SGCitaDisponibilidadSedeNombre ;
   private short[] P000K2_A76SGCitaDisponibilidadClinicaId ;
   private String[] P000K2_A78SGCitaDisponibilidadClinicaNombre ;
   private int[] P000K2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P000K2_A87SGCitaDisponibilidadProCOP ;
   private String[] P000K2_A89CitaEstadoCita ;
   private boolean[] P000K2_n89CitaEstadoCita ;
   private String[] P000K2_A90CitaInforme ;
   private boolean[] P000K2_n90CitaInforme ;
   private String[] P000K2_A100CitaAntecedentes ;
   private boolean[] P000K2_n100CitaAntecedentes ;
   private String[] P000K2_A91CitaLink ;
   private boolean[] P000K2_n91CitaLink ;
   private java.util.Date[] P000K2_A92CitaFechaReserva ;
   private boolean[] P000K2_n92CitaFechaReserva ;
   private String[] P000K2_A93CitaLog ;
   private boolean[] P000K2_n93CitaLog ;
   private String[] P000K2_A94CitaEmailGenLink ;
   private boolean[] P000K2_n94CitaEmailGenLink ;
   private String[] P000K2_A95CitaEstado ;
   private boolean[] P000K2_n95CitaEstado ;
   private String[] P000K2_A99CitaMotivoConsulta ;
   private boolean[] P000K2_n99CitaMotivoConsulta ;
   private String[] P000K2_A96CitaArchivoNombre ;
   private boolean[] P000K2_n96CitaArchivoNombre ;
   private String[] P000K2_A98CitaArchivo ;
   private boolean[] P000K2_n98CitaArchivo ;
   private boolean[] P000K2_A97CitaConsentimiento ;
   private boolean[] P000K2_n97CitaConsentimiento ;
   private boolean[] P000K2_A101CitaGestante ;
   private boolean[] P000K2_n101CitaGestante ;
   private String[] P000K2_A102CitaEstadoPago ;
   private boolean[] P000K2_n102CitaEstadoPago ;
   private java.math.BigDecimal[] P000K2_A306CitaPeso ;
   private boolean[] P000K2_n306CitaPeso ;
   private java.math.BigDecimal[] P000K2_A307CitaEstatura ;
   private boolean[] P000K2_n307CitaEstatura ;
   private String[] P000K2_A86ProfesionalApellidoMaterno ;
   private boolean[] P000K2_n86ProfesionalApellidoMaterno ;
   private String[] P000K2_A85ProfesionalApellidoPaterno ;
   private boolean[] P000K2_n85ProfesionalApellidoPaterno ;
   private String[] P000K2_A84ProfesionalNombres ;
   private boolean[] P000K2_n84ProfesionalNombres ;
   private com.projectthani.SdtSDTCitaData Gxm1sdtcitadata ;
}

final  class dpgetcitabyid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000K2", "SELECT T1.[CitaId], T1.[CitaCode], T1.[PacienteId], T2.[PacienteApellidoPaterno], T2.[PacienteApellidoMaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], T1.[CitaTipoDiagnostico], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T7.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, T1.[CitaEstadoCita], T1.[CitaInforme], T1.[CitaAntecedentes], T1.[CitaLink], T1.[CitaFechaReserva], T1.[CitaLog], T1.[CitaEmailGenLink], T1.[CitaEstado], T1.[CitaMotivoConsulta], T1.[CitaArchivoNombre], T1.[CitaArchivo], T1.[CitaConsentimiento], T1.[CitaGestante], T1.[CitaEstadoPago], T1.[CitaPeso], T1.[CitaEstatura], T7.[ProfesionalApellidoMaterno], T7.[ProfesionalApellidoPaterno], T7.[ProfesionalNombres] FROM (((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Profesional] T7 ON T7.[ProfesionalId] = T3.[ProfesionalId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(11));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[14])[0] = GXutil.resetDate(rslt.getGXDateTime(12));
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((short[]) buf[16])[0] = rslt.getShort(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((short[]) buf[18])[0] = rslt.getShort(15);
               ((String[]) buf[19])[0] = rslt.getVarchar(16);
               ((short[]) buf[20])[0] = rslt.getShort(17);
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((int[]) buf[22])[0] = rslt.getInt(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               ((String[]) buf[24])[0] = rslt.getString(21, 1);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getLongVarchar(23);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(25);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getString(28, 1);
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getLongVarchar(29);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((String[]) buf[42])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((String[]) buf[44])[0] = rslt.getBLOBFile(31, "tmp", "");
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((boolean[]) buf[46])[0] = rslt.getBoolean(32);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((boolean[]) buf[48])[0] = rslt.getBoolean(33);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((String[]) buf[50])[0] = rslt.getString(34, 1);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[52])[0] = rslt.getBigDecimal(35,2);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[54])[0] = rslt.getBigDecimal(36,2);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(37);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((String[]) buf[58])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
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
      }
   }

}

