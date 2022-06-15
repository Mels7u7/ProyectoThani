package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cita_bc extends GXWebPanel implements IGxSilentTrn
{
   public cita_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cita_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cita_bc.class ));
   }

   public cita_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0A17( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0A17( ) ;
      standaloneModal( ) ;
      addRow0A17( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z19CitaId = A19CitaId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0A0( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0A17( ) ;
         }
         else
         {
            checkExtendedTable0A17( ) ;
            if ( AnyError == 0 )
            {
               zm0A17( 12) ;
               zm0A17( 13) ;
               zm0A17( 14) ;
               zm0A17( 15) ;
               zm0A17( 16) ;
               zm0A17( 17) ;
            }
            closeExtendedTableCursors0A17( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Insert", GXv_boolean3) ;
         cita_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Update", GXv_boolean3) ;
         cita_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Delete", GXv_boolean3) ;
         cita_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PacienteId") == 0 )
            {
               AV12Insert_PacienteId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SGCitaDisponibilidadId") == 0 )
            {
               AV13Insert_SGCitaDisponibilidadId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
         }
      }
   }

   public void e110A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0A17( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z64CitaCode = A64CitaCode ;
         Z65CitaTipoDiagnostico = A65CitaTipoDiagnostico ;
         Z89CitaEstadoCita = A89CitaEstadoCita ;
         Z91CitaLink = A91CitaLink ;
         Z92CitaFechaReserva = A92CitaFechaReserva ;
         Z93CitaLog = A93CitaLog ;
         Z94CitaEmailGenLink = A94CitaEmailGenLink ;
         Z95CitaEstado = A95CitaEstado ;
         Z96CitaArchivoNombre = A96CitaArchivoNombre ;
         Z333CitaArchivoExtencion = A333CitaArchivoExtencion ;
         Z97CitaConsentimiento = A97CitaConsentimiento ;
         Z101CitaGestante = A101CitaGestante ;
         Z102CitaEstadoPago = A102CitaEstadoPago ;
         Z306CitaPeso = A306CitaPeso ;
         Z307CitaEstatura = A307CitaEstatura ;
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z68SGCitaDisponibilidadHoraInicio = A68SGCitaDisponibilidadHoraInicio ;
         Z387SGCitaDisponibilidadHoraFin = A387SGCitaDisponibilidadHoraFin ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z87SGCitaDisponibilidadProCOP = A87SGCitaDisponibilidadProCOP ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z73SGCitaDisponibilidadSedeNombre = A73SGCitaDisponibilidadSedeNombre ;
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( GX_JID == -11 )
      {
         Z19CitaId = A19CitaId ;
         Z64CitaCode = A64CitaCode ;
         Z65CitaTipoDiagnostico = A65CitaTipoDiagnostico ;
         Z89CitaEstadoCita = A89CitaEstadoCita ;
         Z90CitaInforme = A90CitaInforme ;
         Z100CitaAntecedentes = A100CitaAntecedentes ;
         Z91CitaLink = A91CitaLink ;
         Z92CitaFechaReserva = A92CitaFechaReserva ;
         Z93CitaLog = A93CitaLog ;
         Z94CitaEmailGenLink = A94CitaEmailGenLink ;
         Z95CitaEstado = A95CitaEstado ;
         Z99CitaMotivoConsulta = A99CitaMotivoConsulta ;
         Z96CitaArchivoNombre = A96CitaArchivoNombre ;
         Z98CitaArchivo = A98CitaArchivo ;
         Z333CitaArchivoExtencion = A333CitaArchivoExtencion ;
         Z97CitaConsentimiento = A97CitaConsentimiento ;
         Z101CitaGestante = A101CitaGestante ;
         Z102CitaEstadoPago = A102CitaEstadoPago ;
         Z306CitaPeso = A306CitaPeso ;
         Z307CitaEstatura = A307CitaEstatura ;
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z68SGCitaDisponibilidadHoraInicio = A68SGCitaDisponibilidadHoraInicio ;
         Z387SGCitaDisponibilidadHoraFin = A387SGCitaDisponibilidadHoraFin ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z87SGCitaDisponibilidadProCOP = A87SGCitaDisponibilidadProCOP ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         Z73SGCitaDisponibilidadSedeNombre = A73SGCitaDisponibilidadSedeNombre ;
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0A17( )
   {
      /* Using cursor BC000A10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A64CitaCode = BC000A10_A64CitaCode[0] ;
         A103PacienteApellidoPaterno = BC000A10_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000A10_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000A10_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = BC000A10_A106PacienteNroDocumento[0] ;
         A65CitaTipoDiagnostico = BC000A10_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = BC000A10_n65CitaTipoDiagnostico[0] ;
         A66SGCitaDisponibilidadFecha = BC000A10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000A10_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = BC000A10_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = BC000A10_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = BC000A10_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = BC000A10_n387SGCitaDisponibilidadHoraFin[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000A10_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = BC000A10_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000A10_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A87SGCitaDisponibilidadProCOP = BC000A10_A87SGCitaDisponibilidadProCOP[0] ;
         A89CitaEstadoCita = BC000A10_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = BC000A10_n89CitaEstadoCita[0] ;
         A90CitaInforme = BC000A10_A90CitaInforme[0] ;
         n90CitaInforme = BC000A10_n90CitaInforme[0] ;
         A100CitaAntecedentes = BC000A10_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = BC000A10_n100CitaAntecedentes[0] ;
         A91CitaLink = BC000A10_A91CitaLink[0] ;
         n91CitaLink = BC000A10_n91CitaLink[0] ;
         A92CitaFechaReserva = BC000A10_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = BC000A10_n92CitaFechaReserva[0] ;
         A93CitaLog = BC000A10_A93CitaLog[0] ;
         n93CitaLog = BC000A10_n93CitaLog[0] ;
         A94CitaEmailGenLink = BC000A10_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = BC000A10_n94CitaEmailGenLink[0] ;
         A95CitaEstado = BC000A10_A95CitaEstado[0] ;
         n95CitaEstado = BC000A10_n95CitaEstado[0] ;
         A99CitaMotivoConsulta = BC000A10_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = BC000A10_n99CitaMotivoConsulta[0] ;
         A96CitaArchivoNombre = BC000A10_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = BC000A10_n96CitaArchivoNombre[0] ;
         A98CitaArchivo = BC000A10_A98CitaArchivo[0] ;
         n98CitaArchivo = BC000A10_n98CitaArchivo[0] ;
         A333CitaArchivoExtencion = BC000A10_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = BC000A10_n333CitaArchivoExtencion[0] ;
         A97CitaConsentimiento = BC000A10_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = BC000A10_n97CitaConsentimiento[0] ;
         A101CitaGestante = BC000A10_A101CitaGestante[0] ;
         n101CitaGestante = BC000A10_n101CitaGestante[0] ;
         A102CitaEstadoPago = BC000A10_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = BC000A10_n102CitaEstadoPago[0] ;
         A306CitaPeso = BC000A10_A306CitaPeso[0] ;
         n306CitaPeso = BC000A10_n306CitaPeso[0] ;
         A307CitaEstatura = BC000A10_A307CitaEstatura[0] ;
         n307CitaEstatura = BC000A10_n307CitaEstatura[0] ;
         A84ProfesionalNombres = BC000A10_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000A10_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000A10_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000A10_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000A10_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000A10_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = BC000A10_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000A10_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000A10_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000A10_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = BC000A10_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000A10_A76SGCitaDisponibilidadClinicaId[0] ;
         zm0A17( -11) ;
      }
      pr_default.close(8);
      onLoadActions0A17( ) ;
   }

   public void onLoadActions0A17( )
   {
      AV29Pgmname = "Cita_BC" ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
   }

   public void checkExtendedTable0A17( )
   {
      nIsDirty_17 = (short)(0) ;
      standaloneModal( ) ;
      AV29Pgmname = "Cita_BC" ;
      /* Using cursor BC000A11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      A103PacienteApellidoPaterno = BC000A11_A103PacienteApellidoPaterno[0] ;
      A104PacienteApellidoMaterno = BC000A11_A104PacienteApellidoMaterno[0] ;
      A105PacienteNombres = BC000A11_A105PacienteNombres[0] ;
      A106PacienteNroDocumento = BC000A11_A106PacienteNroDocumento[0] ;
      pr_default.close(9);
      if ( ! ( ( GXutil.strcmp(A65CitaTipoDiagnostico, "Prensuntivo") == 0 ) || ( GXutil.strcmp(A65CitaTipoDiagnostico, "Definitivo") == 0 ) || ( GXutil.strcmp(A65CitaTipoDiagnostico, "Repetitivo") == 0 ) || (GXutil.strcmp("", A65CitaTipoDiagnostico)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Tipo Diagnostico fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000A12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
      }
      A66SGCitaDisponibilidadFecha = BC000A12_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = BC000A12_n66SGCitaDisponibilidadFecha[0] ;
      A68SGCitaDisponibilidadHoraInicio = BC000A12_A68SGCitaDisponibilidadHoraInicio[0] ;
      n68SGCitaDisponibilidadHoraInicio = BC000A12_n68SGCitaDisponibilidadHoraInicio[0] ;
      A387SGCitaDisponibilidadHoraFin = BC000A12_A387SGCitaDisponibilidadHoraFin[0] ;
      n387SGCitaDisponibilidadHoraFin = BC000A12_n387SGCitaDisponibilidadHoraFin[0] ;
      A81SGCitaDisponibilidadProfesionalId = BC000A12_A81SGCitaDisponibilidadProfesionalId[0] ;
      A70SGCitaDisponibilidadEspecialidadId = BC000A12_A70SGCitaDisponibilidadEspecialidadId[0] ;
      A72SGCitaDisponibilidadSedeId = BC000A12_A72SGCitaDisponibilidadSedeId[0] ;
      pr_default.close(10);
      /* Using cursor BC000A13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A87SGCitaDisponibilidadProCOP = BC000A13_A87SGCitaDisponibilidadProCOP[0] ;
      A84ProfesionalNombres = BC000A13_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = BC000A13_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = BC000A13_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = BC000A13_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = BC000A13_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = BC000A13_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(11);
      nIsDirty_17 = (short)(1) ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      /* Using cursor BC000A14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = BC000A14_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      pr_default.close(12);
      /* Using cursor BC000A15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A73SGCitaDisponibilidadSedeNombre = BC000A15_A73SGCitaDisponibilidadSedeNombre[0] ;
      A76SGCitaDisponibilidadClinicaId = BC000A15_A76SGCitaDisponibilidadClinicaId[0] ;
      pr_default.close(13);
      /* Using cursor BC000A16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = BC000A16_A78SGCitaDisponibilidadClinicaNombre[0] ;
      pr_default.close(14);
      if ( ! ( ( GXutil.strcmp(A89CitaEstadoCita, "R") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "C") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "A") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "F") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "X") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "N") == 0 ) || (GXutil.strcmp("", A89CitaEstadoCita)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado Cita fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A91CitaLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") || (GXutil.strcmp("", A91CitaLink)==0) ) )
      {
         httpContext.GX_msglist.addItem("El valor de Cita Link no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A92CitaFechaReserva) || (( A92CitaFechaReserva.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A92CitaFechaReserva, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Fecha Reserva fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A94CitaEmailGenLink,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") || (GXutil.strcmp("", A94CitaEmailGenLink)==0) ) )
      {
         httpContext.GX_msglist.addItem("El valor de Cita Email Gen Link no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A95CitaEstado, "A") == 0 ) || ( GXutil.strcmp(A95CitaEstado, "I") == 0 ) || (GXutil.strcmp("", A95CitaEstado)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A102CitaEstadoPago, "S") == 0 ) || ( GXutil.strcmp(A102CitaEstadoPago, "P") == 0 ) || ( GXutil.strcmp(A102CitaEstadoPago, "G") == 0 ) || (GXutil.strcmp("", A102CitaEstadoPago)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado Pago fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0A17( )
   {
      pr_default.close(9);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
   }

   public void enableDisable( )
   {
   }

   public void getKey0A17( )
   {
      /* Using cursor BC000A17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound17 = (short)(1) ;
      }
      else
      {
         RcdFound17 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000A18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         zm0A17( 11) ;
         RcdFound17 = (short)(1) ;
         A19CitaId = BC000A18_A19CitaId[0] ;
         n19CitaId = BC000A18_n19CitaId[0] ;
         A64CitaCode = BC000A18_A64CitaCode[0] ;
         A65CitaTipoDiagnostico = BC000A18_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = BC000A18_n65CitaTipoDiagnostico[0] ;
         A89CitaEstadoCita = BC000A18_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = BC000A18_n89CitaEstadoCita[0] ;
         A90CitaInforme = BC000A18_A90CitaInforme[0] ;
         n90CitaInforme = BC000A18_n90CitaInforme[0] ;
         A100CitaAntecedentes = BC000A18_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = BC000A18_n100CitaAntecedentes[0] ;
         A91CitaLink = BC000A18_A91CitaLink[0] ;
         n91CitaLink = BC000A18_n91CitaLink[0] ;
         A92CitaFechaReserva = BC000A18_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = BC000A18_n92CitaFechaReserva[0] ;
         A93CitaLog = BC000A18_A93CitaLog[0] ;
         n93CitaLog = BC000A18_n93CitaLog[0] ;
         A94CitaEmailGenLink = BC000A18_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = BC000A18_n94CitaEmailGenLink[0] ;
         A95CitaEstado = BC000A18_A95CitaEstado[0] ;
         n95CitaEstado = BC000A18_n95CitaEstado[0] ;
         A99CitaMotivoConsulta = BC000A18_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = BC000A18_n99CitaMotivoConsulta[0] ;
         A96CitaArchivoNombre = BC000A18_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = BC000A18_n96CitaArchivoNombre[0] ;
         A98CitaArchivo = BC000A18_A98CitaArchivo[0] ;
         n98CitaArchivo = BC000A18_n98CitaArchivo[0] ;
         A333CitaArchivoExtencion = BC000A18_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = BC000A18_n333CitaArchivoExtencion[0] ;
         A97CitaConsentimiento = BC000A18_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = BC000A18_n97CitaConsentimiento[0] ;
         A101CitaGestante = BC000A18_A101CitaGestante[0] ;
         n101CitaGestante = BC000A18_n101CitaGestante[0] ;
         A102CitaEstadoPago = BC000A18_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = BC000A18_n102CitaEstadoPago[0] ;
         A306CitaPeso = BC000A18_A306CitaPeso[0] ;
         n306CitaPeso = BC000A18_n306CitaPeso[0] ;
         A307CitaEstatura = BC000A18_A307CitaEstatura[0] ;
         n307CitaEstatura = BC000A18_n307CitaEstatura[0] ;
         A20PacienteId = BC000A18_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000A18_A21SGCitaDisponibilidadId[0] ;
         Z19CitaId = A19CitaId ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0A17( ) ;
         if ( AnyError == 1 )
         {
            RcdFound17 = (short)(0) ;
            initializeNonKey0A17( ) ;
         }
         Gx_mode = sMode17 ;
      }
      else
      {
         RcdFound17 = (short)(0) ;
         initializeNonKey0A17( ) ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode17 ;
      }
      pr_default.close(16);
   }

   public void getEqualNoModal( )
   {
      getKey0A17( ) ;
      if ( RcdFound17 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0A0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0A17( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000A19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(17) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cita"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(17) == 101) || ( GXutil.strcmp(Z64CitaCode, BC000A19_A64CitaCode[0]) != 0 ) || ( GXutil.strcmp(Z65CitaTipoDiagnostico, BC000A19_A65CitaTipoDiagnostico[0]) != 0 ) || ( GXutil.strcmp(Z89CitaEstadoCita, BC000A19_A89CitaEstadoCita[0]) != 0 ) || ( GXutil.strcmp(Z91CitaLink, BC000A19_A91CitaLink[0]) != 0 ) || !( GXutil.dateCompare(Z92CitaFechaReserva, BC000A19_A92CitaFechaReserva[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z93CitaLog, BC000A19_A93CitaLog[0]) != 0 ) || ( GXutil.strcmp(Z94CitaEmailGenLink, BC000A19_A94CitaEmailGenLink[0]) != 0 ) || ( GXutil.strcmp(Z95CitaEstado, BC000A19_A95CitaEstado[0]) != 0 ) || ( GXutil.strcmp(Z96CitaArchivoNombre, BC000A19_A96CitaArchivoNombre[0]) != 0 ) || ( GXutil.strcmp(Z333CitaArchivoExtencion, BC000A19_A333CitaArchivoExtencion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z97CitaConsentimiento != BC000A19_A97CitaConsentimiento[0] ) || ( Z101CitaGestante != BC000A19_A101CitaGestante[0] ) || ( GXutil.strcmp(Z102CitaEstadoPago, BC000A19_A102CitaEstadoPago[0]) != 0 ) || ( DecimalUtil.compareTo(Z306CitaPeso, BC000A19_A306CitaPeso[0]) != 0 ) || ( DecimalUtil.compareTo(Z307CitaEstatura, BC000A19_A307CitaEstatura[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z20PacienteId != BC000A19_A20PacienteId[0] ) || ( Z21SGCitaDisponibilidadId != BC000A19_A21SGCitaDisponibilidadId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cita"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A17( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A17( 0) ;
         checkOptimisticConcurrency0A17( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A17( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A20 */
                  pr_default.execute(18, new Object[] {A64CitaCode, Boolean.valueOf(n65CitaTipoDiagnostico), A65CitaTipoDiagnostico, Boolean.valueOf(n89CitaEstadoCita), A89CitaEstadoCita, Boolean.valueOf(n90CitaInforme), A90CitaInforme, Boolean.valueOf(n100CitaAntecedentes), A100CitaAntecedentes, Boolean.valueOf(n91CitaLink), A91CitaLink, Boolean.valueOf(n92CitaFechaReserva), A92CitaFechaReserva, Boolean.valueOf(n93CitaLog), A93CitaLog, Boolean.valueOf(n94CitaEmailGenLink), A94CitaEmailGenLink, Boolean.valueOf(n95CitaEstado), A95CitaEstado, Boolean.valueOf(n99CitaMotivoConsulta), A99CitaMotivoConsulta, Boolean.valueOf(n96CitaArchivoNombre), A96CitaArchivoNombre, Boolean.valueOf(n98CitaArchivo), A98CitaArchivo, Boolean.valueOf(n333CitaArchivoExtencion), A333CitaArchivoExtencion, Boolean.valueOf(n97CitaConsentimiento), Boolean.valueOf(A97CitaConsentimiento), Boolean.valueOf(n101CitaGestante), Boolean.valueOf(A101CitaGestante), Boolean.valueOf(n102CitaEstadoPago), A102CitaEstadoPago, Boolean.valueOf(n306CitaPeso), A306CitaPeso, Boolean.valueOf(n307CitaEstatura), A307CitaEstatura, Integer.valueOf(A20PacienteId), Integer.valueOf(A21SGCitaDisponibilidadId)});
                  A19CitaId = BC000A20_A19CitaId[0] ;
                  n19CitaId = BC000A20_n19CitaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0A17( ) ;
         }
         endLevel0A17( ) ;
      }
      closeExtendedTableCursors0A17( ) ;
   }

   public void update0A17( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A17( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A17( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000A21 */
                  pr_default.execute(19, new Object[] {A64CitaCode, Boolean.valueOf(n65CitaTipoDiagnostico), A65CitaTipoDiagnostico, Boolean.valueOf(n89CitaEstadoCita), A89CitaEstadoCita, Boolean.valueOf(n90CitaInforme), A90CitaInforme, Boolean.valueOf(n100CitaAntecedentes), A100CitaAntecedentes, Boolean.valueOf(n91CitaLink), A91CitaLink, Boolean.valueOf(n92CitaFechaReserva), A92CitaFechaReserva, Boolean.valueOf(n93CitaLog), A93CitaLog, Boolean.valueOf(n94CitaEmailGenLink), A94CitaEmailGenLink, Boolean.valueOf(n95CitaEstado), A95CitaEstado, Boolean.valueOf(n99CitaMotivoConsulta), A99CitaMotivoConsulta, Boolean.valueOf(n96CitaArchivoNombre), A96CitaArchivoNombre, Boolean.valueOf(n333CitaArchivoExtencion), A333CitaArchivoExtencion, Boolean.valueOf(n97CitaConsentimiento), Boolean.valueOf(A97CitaConsentimiento), Boolean.valueOf(n101CitaGestante), Boolean.valueOf(A101CitaGestante), Boolean.valueOf(n102CitaEstadoPago), A102CitaEstadoPago, Boolean.valueOf(n306CitaPeso), A306CitaPeso, Boolean.valueOf(n307CitaEstatura), A307CitaEstatura, Integer.valueOf(A20PacienteId), Integer.valueOf(A21SGCitaDisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cita"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A17( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0A17( ) ;
      }
      closeExtendedTableCursors0A17( ) ;
   }

   public void deferredUpdate0A17( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000A22 */
         pr_default.execute(20, new Object[] {Boolean.valueOf(n98CitaArchivo), A98CitaArchivo, Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A17( ) ;
         afterConfirm0A17( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A17( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000A23 */
               pr_default.execute(21, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode17 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0A17( ) ;
      Gx_mode = sMode17 ;
   }

   public void onDeleteControls0A17( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Cita_BC" ;
         /* Using cursor BC000A24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = BC000A24_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000A24_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000A24_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = BC000A24_A106PacienteNroDocumento[0] ;
         pr_default.close(22);
         /* Using cursor BC000A25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = BC000A25_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000A25_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = BC000A25_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = BC000A25_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = BC000A25_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = BC000A25_n387SGCitaDisponibilidadHoraFin[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000A25_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000A25_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = BC000A25_A72SGCitaDisponibilidadSedeId[0] ;
         pr_default.close(23);
         /* Using cursor BC000A26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A87SGCitaDisponibilidadProCOP = BC000A26_A87SGCitaDisponibilidadProCOP[0] ;
         A84ProfesionalNombres = BC000A26_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000A26_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000A26_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000A26_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000A26_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000A26_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(24);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         /* Using cursor BC000A27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = BC000A27_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         pr_default.close(25);
         /* Using cursor BC000A28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A73SGCitaDisponibilidadSedeNombre = BC000A28_A73SGCitaDisponibilidadSedeNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000A28_A76SGCitaDisponibilidadClinicaId[0] ;
         pr_default.close(26);
         /* Using cursor BC000A29 */
         pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = BC000A29_A78SGCitaDisponibilidadClinicaNombre[0] ;
         pr_default.close(27);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000A30 */
         pr_default.execute(28, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Receta Medica"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor BC000A31 */
         pr_default.execute(29, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Pago"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor BC000A32 */
         pr_default.execute(30, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Encuesta"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor BC000A33 */
         pr_default.execute(31, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Servicio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor BC000A34 */
         pr_default.execute(32, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Receta"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor BC000A35 */
         pr_default.execute(33, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Diagnostico"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
      }
   }

   public void endLevel0A17( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(17);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0A17( )
   {
      /* Scan By routine */
      /* Using cursor BC000A36 */
      pr_default.execute(34, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A19CitaId = BC000A36_A19CitaId[0] ;
         n19CitaId = BC000A36_n19CitaId[0] ;
         A64CitaCode = BC000A36_A64CitaCode[0] ;
         A103PacienteApellidoPaterno = BC000A36_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000A36_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000A36_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = BC000A36_A106PacienteNroDocumento[0] ;
         A65CitaTipoDiagnostico = BC000A36_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = BC000A36_n65CitaTipoDiagnostico[0] ;
         A66SGCitaDisponibilidadFecha = BC000A36_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000A36_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = BC000A36_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = BC000A36_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = BC000A36_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = BC000A36_n387SGCitaDisponibilidadHoraFin[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000A36_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = BC000A36_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000A36_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A87SGCitaDisponibilidadProCOP = BC000A36_A87SGCitaDisponibilidadProCOP[0] ;
         A89CitaEstadoCita = BC000A36_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = BC000A36_n89CitaEstadoCita[0] ;
         A90CitaInforme = BC000A36_A90CitaInforme[0] ;
         n90CitaInforme = BC000A36_n90CitaInforme[0] ;
         A100CitaAntecedentes = BC000A36_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = BC000A36_n100CitaAntecedentes[0] ;
         A91CitaLink = BC000A36_A91CitaLink[0] ;
         n91CitaLink = BC000A36_n91CitaLink[0] ;
         A92CitaFechaReserva = BC000A36_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = BC000A36_n92CitaFechaReserva[0] ;
         A93CitaLog = BC000A36_A93CitaLog[0] ;
         n93CitaLog = BC000A36_n93CitaLog[0] ;
         A94CitaEmailGenLink = BC000A36_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = BC000A36_n94CitaEmailGenLink[0] ;
         A95CitaEstado = BC000A36_A95CitaEstado[0] ;
         n95CitaEstado = BC000A36_n95CitaEstado[0] ;
         A99CitaMotivoConsulta = BC000A36_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = BC000A36_n99CitaMotivoConsulta[0] ;
         A96CitaArchivoNombre = BC000A36_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = BC000A36_n96CitaArchivoNombre[0] ;
         A98CitaArchivo = BC000A36_A98CitaArchivo[0] ;
         n98CitaArchivo = BC000A36_n98CitaArchivo[0] ;
         A333CitaArchivoExtencion = BC000A36_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = BC000A36_n333CitaArchivoExtencion[0] ;
         A97CitaConsentimiento = BC000A36_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = BC000A36_n97CitaConsentimiento[0] ;
         A101CitaGestante = BC000A36_A101CitaGestante[0] ;
         n101CitaGestante = BC000A36_n101CitaGestante[0] ;
         A102CitaEstadoPago = BC000A36_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = BC000A36_n102CitaEstadoPago[0] ;
         A306CitaPeso = BC000A36_A306CitaPeso[0] ;
         n306CitaPeso = BC000A36_n306CitaPeso[0] ;
         A307CitaEstatura = BC000A36_A307CitaEstatura[0] ;
         n307CitaEstatura = BC000A36_n307CitaEstatura[0] ;
         A84ProfesionalNombres = BC000A36_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000A36_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000A36_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000A36_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000A36_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000A36_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = BC000A36_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000A36_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000A36_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000A36_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = BC000A36_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000A36_A76SGCitaDisponibilidadClinicaId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0A17( )
   {
      /* Scan next routine */
      pr_default.readNext(34);
      RcdFound17 = (short)(0) ;
      scanKeyLoad0A17( ) ;
   }

   public void scanKeyLoad0A17( )
   {
      sMode17 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A19CitaId = BC000A36_A19CitaId[0] ;
         n19CitaId = BC000A36_n19CitaId[0] ;
         A64CitaCode = BC000A36_A64CitaCode[0] ;
         A103PacienteApellidoPaterno = BC000A36_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000A36_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000A36_A105PacienteNombres[0] ;
         A106PacienteNroDocumento = BC000A36_A106PacienteNroDocumento[0] ;
         A65CitaTipoDiagnostico = BC000A36_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = BC000A36_n65CitaTipoDiagnostico[0] ;
         A66SGCitaDisponibilidadFecha = BC000A36_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000A36_n66SGCitaDisponibilidadFecha[0] ;
         A68SGCitaDisponibilidadHoraInicio = BC000A36_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = BC000A36_n68SGCitaDisponibilidadHoraInicio[0] ;
         A387SGCitaDisponibilidadHoraFin = BC000A36_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = BC000A36_n387SGCitaDisponibilidadHoraFin[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000A36_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = BC000A36_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000A36_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A87SGCitaDisponibilidadProCOP = BC000A36_A87SGCitaDisponibilidadProCOP[0] ;
         A89CitaEstadoCita = BC000A36_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = BC000A36_n89CitaEstadoCita[0] ;
         A90CitaInforme = BC000A36_A90CitaInforme[0] ;
         n90CitaInforme = BC000A36_n90CitaInforme[0] ;
         A100CitaAntecedentes = BC000A36_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = BC000A36_n100CitaAntecedentes[0] ;
         A91CitaLink = BC000A36_A91CitaLink[0] ;
         n91CitaLink = BC000A36_n91CitaLink[0] ;
         A92CitaFechaReserva = BC000A36_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = BC000A36_n92CitaFechaReserva[0] ;
         A93CitaLog = BC000A36_A93CitaLog[0] ;
         n93CitaLog = BC000A36_n93CitaLog[0] ;
         A94CitaEmailGenLink = BC000A36_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = BC000A36_n94CitaEmailGenLink[0] ;
         A95CitaEstado = BC000A36_A95CitaEstado[0] ;
         n95CitaEstado = BC000A36_n95CitaEstado[0] ;
         A99CitaMotivoConsulta = BC000A36_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = BC000A36_n99CitaMotivoConsulta[0] ;
         A96CitaArchivoNombre = BC000A36_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = BC000A36_n96CitaArchivoNombre[0] ;
         A98CitaArchivo = BC000A36_A98CitaArchivo[0] ;
         n98CitaArchivo = BC000A36_n98CitaArchivo[0] ;
         A333CitaArchivoExtencion = BC000A36_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = BC000A36_n333CitaArchivoExtencion[0] ;
         A97CitaConsentimiento = BC000A36_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = BC000A36_n97CitaConsentimiento[0] ;
         A101CitaGestante = BC000A36_A101CitaGestante[0] ;
         n101CitaGestante = BC000A36_n101CitaGestante[0] ;
         A102CitaEstadoPago = BC000A36_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = BC000A36_n102CitaEstadoPago[0] ;
         A306CitaPeso = BC000A36_A306CitaPeso[0] ;
         n306CitaPeso = BC000A36_n306CitaPeso[0] ;
         A307CitaEstatura = BC000A36_A307CitaEstatura[0] ;
         n307CitaEstatura = BC000A36_n307CitaEstatura[0] ;
         A84ProfesionalNombres = BC000A36_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000A36_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000A36_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000A36_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000A36_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000A36_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = BC000A36_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000A36_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000A36_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000A36_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = BC000A36_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000A36_A76SGCitaDisponibilidadClinicaId[0] ;
      }
      Gx_mode = sMode17 ;
   }

   public void scanKeyEnd0A17( )
   {
      pr_default.close(34);
   }

   public void afterConfirm0A17( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A17( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A17( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A17( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A17( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A17( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A17( )
   {
   }

   public void send_integrity_lvl_hashes0A17( )
   {
   }

   public void addRow0A17( )
   {
      VarsToRow17( bcCita) ;
   }

   public void readRow0A17( )
   {
      RowToVars17( bcCita, 1) ;
   }

   public void initializeNonKey0A17( )
   {
      A64CitaCode = "" ;
      A20PacienteId = 0 ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A65CitaTipoDiagnostico = "" ;
      n65CitaTipoDiagnostico = false ;
      A21SGCitaDisponibilidadId = 0 ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      n68SGCitaDisponibilidadHoraInicio = false ;
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      n387SGCitaDisponibilidadHoraFin = false ;
      A70SGCitaDisponibilidadEspecialidadId = (short)(0) ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A72SGCitaDisponibilidadSedeId = (short)(0) ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A76SGCitaDisponibilidadClinicaId = (short)(0) ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A81SGCitaDisponibilidadProfesionalId = 0 ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A89CitaEstadoCita = "" ;
      n89CitaEstadoCita = false ;
      A90CitaInforme = "" ;
      n90CitaInforme = false ;
      A100CitaAntecedentes = "" ;
      n100CitaAntecedentes = false ;
      A91CitaLink = "" ;
      n91CitaLink = false ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      n92CitaFechaReserva = false ;
      A93CitaLog = "" ;
      n93CitaLog = false ;
      A94CitaEmailGenLink = "" ;
      n94CitaEmailGenLink = false ;
      A95CitaEstado = "" ;
      n95CitaEstado = false ;
      A99CitaMotivoConsulta = "" ;
      n99CitaMotivoConsulta = false ;
      A96CitaArchivoNombre = "" ;
      n96CitaArchivoNombre = false ;
      A98CitaArchivo = "" ;
      n98CitaArchivo = false ;
      A333CitaArchivoExtencion = "" ;
      n333CitaArchivoExtencion = false ;
      A97CitaConsentimiento = false ;
      n97CitaConsentimiento = false ;
      A101CitaGestante = false ;
      n101CitaGestante = false ;
      A102CitaEstadoPago = "" ;
      n102CitaEstadoPago = false ;
      A306CitaPeso = DecimalUtil.ZERO ;
      n306CitaPeso = false ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      n307CitaEstatura = false ;
      A84ProfesionalNombres = "" ;
      n84ProfesionalNombres = false ;
      A85ProfesionalApellidoPaterno = "" ;
      n85ProfesionalApellidoPaterno = false ;
      A86ProfesionalApellidoMaterno = "" ;
      n86ProfesionalApellidoMaterno = false ;
      Z64CitaCode = "" ;
      Z65CitaTipoDiagnostico = "" ;
      Z89CitaEstadoCita = "" ;
      Z91CitaLink = "" ;
      Z92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      Z93CitaLog = "" ;
      Z94CitaEmailGenLink = "" ;
      Z95CitaEstado = "" ;
      Z96CitaArchivoNombre = "" ;
      Z333CitaArchivoExtencion = "" ;
      Z97CitaConsentimiento = false ;
      Z101CitaGestante = false ;
      Z102CitaEstadoPago = "" ;
      Z306CitaPeso = DecimalUtil.ZERO ;
      Z307CitaEstatura = DecimalUtil.ZERO ;
      Z20PacienteId = 0 ;
      Z21SGCitaDisponibilidadId = 0 ;
   }

   public void initAll0A17( )
   {
      A19CitaId = 0 ;
      n19CitaId = false ;
      initializeNonKey0A17( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow17( com.projectthani.SdtCita obj17 )
   {
      obj17.setgxTv_SdtCita_Mode( Gx_mode );
      obj17.setgxTv_SdtCita_Citacode( A64CitaCode );
      obj17.setgxTv_SdtCita_Pacienteid( A20PacienteId );
      obj17.setgxTv_SdtCita_Pacienteapellidopaterno( A103PacienteApellidoPaterno );
      obj17.setgxTv_SdtCita_Pacienteapellidomaterno( A104PacienteApellidoMaterno );
      obj17.setgxTv_SdtCita_Pacientenombres( A105PacienteNombres );
      obj17.setgxTv_SdtCita_Pacientenrodocumento( A106PacienteNroDocumento );
      obj17.setgxTv_SdtCita_Citatipodiagnostico( A65CitaTipoDiagnostico );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadid( A21SGCitaDisponibilidadId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadfecha( A66SGCitaDisponibilidadFecha );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorainicio( A68SGCitaDisponibilidadHoraInicio );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorafin( A387SGCitaDisponibilidadHoraFin );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid( A70SGCitaDisponibilidadEspecialidadId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre( A146SGCitaDisponibilidadEspecialidadNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadsedeid( A72SGCitaDisponibilidadSedeId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadsedenombre( A73SGCitaDisponibilidadSedeNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadclinicaid( A76SGCitaDisponibilidadClinicaId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre( A78SGCitaDisponibilidadClinicaNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid( A81SGCitaDisponibilidadProfesionalId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprofullname( A82SGCitaDisponibilidadProFullName );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprocop( A87SGCitaDisponibilidadProCOP );
      obj17.setgxTv_SdtCita_Citaestadocita( A89CitaEstadoCita );
      obj17.setgxTv_SdtCita_Citainforme( A90CitaInforme );
      obj17.setgxTv_SdtCita_Citaantecedentes( A100CitaAntecedentes );
      obj17.setgxTv_SdtCita_Citalink( A91CitaLink );
      obj17.setgxTv_SdtCita_Citafechareserva( A92CitaFechaReserva );
      obj17.setgxTv_SdtCita_Citalog( A93CitaLog );
      obj17.setgxTv_SdtCita_Citaemailgenlink( A94CitaEmailGenLink );
      obj17.setgxTv_SdtCita_Citaestado( A95CitaEstado );
      obj17.setgxTv_SdtCita_Citamotivoconsulta( A99CitaMotivoConsulta );
      obj17.setgxTv_SdtCita_Citaarchivonombre( A96CitaArchivoNombre );
      obj17.setgxTv_SdtCita_Citaarchivo( A98CitaArchivo );
      obj17.setgxTv_SdtCita_Citaarchivoextencion( A333CitaArchivoExtencion );
      obj17.setgxTv_SdtCita_Citaconsentimiento( A97CitaConsentimiento );
      obj17.setgxTv_SdtCita_Citagestante( A101CitaGestante );
      obj17.setgxTv_SdtCita_Citaestadopago( A102CitaEstadoPago );
      obj17.setgxTv_SdtCita_Citapeso( A306CitaPeso );
      obj17.setgxTv_SdtCita_Citaestatura( A307CitaEstatura );
      obj17.setgxTv_SdtCita_Citaid( A19CitaId );
      obj17.setgxTv_SdtCita_Citaid_Z( Z19CitaId );
      obj17.setgxTv_SdtCita_Citacode_Z( Z64CitaCode );
      obj17.setgxTv_SdtCita_Pacienteid_Z( Z20PacienteId );
      obj17.setgxTv_SdtCita_Pacienteapellidopaterno_Z( Z103PacienteApellidoPaterno );
      obj17.setgxTv_SdtCita_Pacienteapellidomaterno_Z( Z104PacienteApellidoMaterno );
      obj17.setgxTv_SdtCita_Pacientenombres_Z( Z105PacienteNombres );
      obj17.setgxTv_SdtCita_Pacientenrodocumento_Z( Z106PacienteNroDocumento );
      obj17.setgxTv_SdtCita_Citatipodiagnostico_Z( Z65CitaTipoDiagnostico );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadid_Z( Z21SGCitaDisponibilidadId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadfecha_Z( Z66SGCitaDisponibilidadFecha );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z( Z68SGCitaDisponibilidadHoraInicio );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z( Z387SGCitaDisponibilidadHoraFin );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z( Z70SGCitaDisponibilidadEspecialidadId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z( Z146SGCitaDisponibilidadEspecialidadNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z( Z72SGCitaDisponibilidadSedeId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z( Z73SGCitaDisponibilidadSedeNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z( Z76SGCitaDisponibilidadClinicaId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z( Z78SGCitaDisponibilidadClinicaNombre );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z( Z81SGCitaDisponibilidadProfesionalId );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z( Z82SGCitaDisponibilidadProFullName );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadprocop_Z( Z87SGCitaDisponibilidadProCOP );
      obj17.setgxTv_SdtCita_Citaestadocita_Z( Z89CitaEstadoCita );
      obj17.setgxTv_SdtCita_Citalink_Z( Z91CitaLink );
      obj17.setgxTv_SdtCita_Citafechareserva_Z( Z92CitaFechaReserva );
      obj17.setgxTv_SdtCita_Citalog_Z( Z93CitaLog );
      obj17.setgxTv_SdtCita_Citaemailgenlink_Z( Z94CitaEmailGenLink );
      obj17.setgxTv_SdtCita_Citaestado_Z( Z95CitaEstado );
      obj17.setgxTv_SdtCita_Citaarchivonombre_Z( Z96CitaArchivoNombre );
      obj17.setgxTv_SdtCita_Citaarchivoextencion_Z( Z333CitaArchivoExtencion );
      obj17.setgxTv_SdtCita_Citaconsentimiento_Z( Z97CitaConsentimiento );
      obj17.setgxTv_SdtCita_Citagestante_Z( Z101CitaGestante );
      obj17.setgxTv_SdtCita_Citaestadopago_Z( Z102CitaEstadoPago );
      obj17.setgxTv_SdtCita_Citapeso_Z( Z306CitaPeso );
      obj17.setgxTv_SdtCita_Citaestatura_Z( Z307CitaEstatura );
      obj17.setgxTv_SdtCita_Citaid_N( (byte)((byte)((n19CitaId)?1:0)) );
      obj17.setgxTv_SdtCita_Citatipodiagnostico_N( (byte)((byte)((n65CitaTipoDiagnostico)?1:0)) );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadfecha_N( (byte)((byte)((n66SGCitaDisponibilidadFecha)?1:0)) );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N( (byte)((byte)((n68SGCitaDisponibilidadHoraInicio)?1:0)) );
      obj17.setgxTv_SdtCita_Sgcitadisponibilidadhorafin_N( (byte)((byte)((n387SGCitaDisponibilidadHoraFin)?1:0)) );
      obj17.setgxTv_SdtCita_Citaestadocita_N( (byte)((byte)((n89CitaEstadoCita)?1:0)) );
      obj17.setgxTv_SdtCita_Citainforme_N( (byte)((byte)((n90CitaInforme)?1:0)) );
      obj17.setgxTv_SdtCita_Citaantecedentes_N( (byte)((byte)((n100CitaAntecedentes)?1:0)) );
      obj17.setgxTv_SdtCita_Citalink_N( (byte)((byte)((n91CitaLink)?1:0)) );
      obj17.setgxTv_SdtCita_Citafechareserva_N( (byte)((byte)((n92CitaFechaReserva)?1:0)) );
      obj17.setgxTv_SdtCita_Citalog_N( (byte)((byte)((n93CitaLog)?1:0)) );
      obj17.setgxTv_SdtCita_Citaemailgenlink_N( (byte)((byte)((n94CitaEmailGenLink)?1:0)) );
      obj17.setgxTv_SdtCita_Citaestado_N( (byte)((byte)((n95CitaEstado)?1:0)) );
      obj17.setgxTv_SdtCita_Citamotivoconsulta_N( (byte)((byte)((n99CitaMotivoConsulta)?1:0)) );
      obj17.setgxTv_SdtCita_Citaarchivonombre_N( (byte)((byte)((n96CitaArchivoNombre)?1:0)) );
      obj17.setgxTv_SdtCita_Citaarchivo_N( (byte)((byte)((n98CitaArchivo)?1:0)) );
      obj17.setgxTv_SdtCita_Citaarchivoextencion_N( (byte)((byte)((n333CitaArchivoExtencion)?1:0)) );
      obj17.setgxTv_SdtCita_Citaconsentimiento_N( (byte)((byte)((n97CitaConsentimiento)?1:0)) );
      obj17.setgxTv_SdtCita_Citagestante_N( (byte)((byte)((n101CitaGestante)?1:0)) );
      obj17.setgxTv_SdtCita_Citaestadopago_N( (byte)((byte)((n102CitaEstadoPago)?1:0)) );
      obj17.setgxTv_SdtCita_Citapeso_N( (byte)((byte)((n306CitaPeso)?1:0)) );
      obj17.setgxTv_SdtCita_Citaestatura_N( (byte)((byte)((n307CitaEstatura)?1:0)) );
      obj17.setgxTv_SdtCita_Mode( Gx_mode );
   }

   public void KeyVarsToRow17( com.projectthani.SdtCita obj17 )
   {
      obj17.setgxTv_SdtCita_Citaid( A19CitaId );
   }

   public void RowToVars17( com.projectthani.SdtCita obj17 ,
                            int forceLoad )
   {
      Gx_mode = obj17.getgxTv_SdtCita_Mode() ;
      A64CitaCode = obj17.getgxTv_SdtCita_Citacode() ;
      A20PacienteId = obj17.getgxTv_SdtCita_Pacienteid() ;
      A103PacienteApellidoPaterno = obj17.getgxTv_SdtCita_Pacienteapellidopaterno() ;
      A104PacienteApellidoMaterno = obj17.getgxTv_SdtCita_Pacienteapellidomaterno() ;
      A105PacienteNombres = obj17.getgxTv_SdtCita_Pacientenombres() ;
      A106PacienteNroDocumento = obj17.getgxTv_SdtCita_Pacientenrodocumento() ;
      A65CitaTipoDiagnostico = obj17.getgxTv_SdtCita_Citatipodiagnostico() ;
      n65CitaTipoDiagnostico = false ;
      A21SGCitaDisponibilidadId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadid() ;
      A66SGCitaDisponibilidadFecha = obj17.getgxTv_SdtCita_Sgcitadisponibilidadfecha() ;
      n66SGCitaDisponibilidadFecha = false ;
      A68SGCitaDisponibilidadHoraInicio = obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorainicio() ;
      n68SGCitaDisponibilidadHoraInicio = false ;
      A387SGCitaDisponibilidadHoraFin = obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorafin() ;
      n387SGCitaDisponibilidadHoraFin = false ;
      A70SGCitaDisponibilidadEspecialidadId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid() ;
      A146SGCitaDisponibilidadEspecialidadNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre() ;
      A72SGCitaDisponibilidadSedeId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadsedeid() ;
      A73SGCitaDisponibilidadSedeNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadsedenombre() ;
      A76SGCitaDisponibilidadClinicaId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadclinicaid() ;
      A78SGCitaDisponibilidadClinicaNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre() ;
      A81SGCitaDisponibilidadProfesionalId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid() ;
      A82SGCitaDisponibilidadProFullName = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprofullname() ;
      A87SGCitaDisponibilidadProCOP = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprocop() ;
      A89CitaEstadoCita = obj17.getgxTv_SdtCita_Citaestadocita() ;
      n89CitaEstadoCita = false ;
      A90CitaInforme = obj17.getgxTv_SdtCita_Citainforme() ;
      n90CitaInforme = false ;
      A100CitaAntecedentes = obj17.getgxTv_SdtCita_Citaantecedentes() ;
      n100CitaAntecedentes = false ;
      A91CitaLink = obj17.getgxTv_SdtCita_Citalink() ;
      n91CitaLink = false ;
      A92CitaFechaReserva = obj17.getgxTv_SdtCita_Citafechareserva() ;
      n92CitaFechaReserva = false ;
      A93CitaLog = obj17.getgxTv_SdtCita_Citalog() ;
      n93CitaLog = false ;
      A94CitaEmailGenLink = obj17.getgxTv_SdtCita_Citaemailgenlink() ;
      n94CitaEmailGenLink = false ;
      A95CitaEstado = obj17.getgxTv_SdtCita_Citaestado() ;
      n95CitaEstado = false ;
      A99CitaMotivoConsulta = obj17.getgxTv_SdtCita_Citamotivoconsulta() ;
      n99CitaMotivoConsulta = false ;
      A96CitaArchivoNombre = obj17.getgxTv_SdtCita_Citaarchivonombre() ;
      n96CitaArchivoNombre = false ;
      A98CitaArchivo = obj17.getgxTv_SdtCita_Citaarchivo() ;
      n98CitaArchivo = false ;
      A333CitaArchivoExtencion = obj17.getgxTv_SdtCita_Citaarchivoextencion() ;
      n333CitaArchivoExtencion = false ;
      A97CitaConsentimiento = obj17.getgxTv_SdtCita_Citaconsentimiento() ;
      n97CitaConsentimiento = false ;
      A101CitaGestante = obj17.getgxTv_SdtCita_Citagestante() ;
      n101CitaGestante = false ;
      A102CitaEstadoPago = obj17.getgxTv_SdtCita_Citaestadopago() ;
      n102CitaEstadoPago = false ;
      A306CitaPeso = obj17.getgxTv_SdtCita_Citapeso() ;
      n306CitaPeso = false ;
      A307CitaEstatura = obj17.getgxTv_SdtCita_Citaestatura() ;
      n307CitaEstatura = false ;
      A19CitaId = obj17.getgxTv_SdtCita_Citaid() ;
      n19CitaId = false ;
      Z19CitaId = obj17.getgxTv_SdtCita_Citaid_Z() ;
      Z64CitaCode = obj17.getgxTv_SdtCita_Citacode_Z() ;
      Z20PacienteId = obj17.getgxTv_SdtCita_Pacienteid_Z() ;
      Z103PacienteApellidoPaterno = obj17.getgxTv_SdtCita_Pacienteapellidopaterno_Z() ;
      Z104PacienteApellidoMaterno = obj17.getgxTv_SdtCita_Pacienteapellidomaterno_Z() ;
      Z105PacienteNombres = obj17.getgxTv_SdtCita_Pacientenombres_Z() ;
      Z106PacienteNroDocumento = obj17.getgxTv_SdtCita_Pacientenrodocumento_Z() ;
      Z65CitaTipoDiagnostico = obj17.getgxTv_SdtCita_Citatipodiagnostico_Z() ;
      Z21SGCitaDisponibilidadId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadid_Z() ;
      Z66SGCitaDisponibilidadFecha = obj17.getgxTv_SdtCita_Sgcitadisponibilidadfecha_Z() ;
      Z68SGCitaDisponibilidadHoraInicio = obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_Z() ;
      Z387SGCitaDisponibilidadHoraFin = obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorafin_Z() ;
      Z70SGCitaDisponibilidadEspecialidadId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadid_Z() ;
      Z146SGCitaDisponibilidadEspecialidadNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadespecialidadnombre_Z() ;
      Z72SGCitaDisponibilidadSedeId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadsedeid_Z() ;
      Z73SGCitaDisponibilidadSedeNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadsedenombre_Z() ;
      Z76SGCitaDisponibilidadClinicaId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadclinicaid_Z() ;
      Z78SGCitaDisponibilidadClinicaNombre = obj17.getgxTv_SdtCita_Sgcitadisponibilidadclinicanombre_Z() ;
      Z81SGCitaDisponibilidadProfesionalId = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprofesionalid_Z() ;
      Z82SGCitaDisponibilidadProFullName = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprofullname_Z() ;
      Z87SGCitaDisponibilidadProCOP = obj17.getgxTv_SdtCita_Sgcitadisponibilidadprocop_Z() ;
      Z89CitaEstadoCita = obj17.getgxTv_SdtCita_Citaestadocita_Z() ;
      Z91CitaLink = obj17.getgxTv_SdtCita_Citalink_Z() ;
      Z92CitaFechaReserva = obj17.getgxTv_SdtCita_Citafechareserva_Z() ;
      Z93CitaLog = obj17.getgxTv_SdtCita_Citalog_Z() ;
      Z94CitaEmailGenLink = obj17.getgxTv_SdtCita_Citaemailgenlink_Z() ;
      Z95CitaEstado = obj17.getgxTv_SdtCita_Citaestado_Z() ;
      Z96CitaArchivoNombre = obj17.getgxTv_SdtCita_Citaarchivonombre_Z() ;
      Z333CitaArchivoExtencion = obj17.getgxTv_SdtCita_Citaarchivoextencion_Z() ;
      Z97CitaConsentimiento = obj17.getgxTv_SdtCita_Citaconsentimiento_Z() ;
      Z101CitaGestante = obj17.getgxTv_SdtCita_Citagestante_Z() ;
      Z102CitaEstadoPago = obj17.getgxTv_SdtCita_Citaestadopago_Z() ;
      Z306CitaPeso = obj17.getgxTv_SdtCita_Citapeso_Z() ;
      Z307CitaEstatura = obj17.getgxTv_SdtCita_Citaestatura_Z() ;
      n19CitaId = (boolean)((obj17.getgxTv_SdtCita_Citaid_N()==0)?false:true) ;
      n65CitaTipoDiagnostico = (boolean)((obj17.getgxTv_SdtCita_Citatipodiagnostico_N()==0)?false:true) ;
      n66SGCitaDisponibilidadFecha = (boolean)((obj17.getgxTv_SdtCita_Sgcitadisponibilidadfecha_N()==0)?false:true) ;
      n68SGCitaDisponibilidadHoraInicio = (boolean)((obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorainicio_N()==0)?false:true) ;
      n387SGCitaDisponibilidadHoraFin = (boolean)((obj17.getgxTv_SdtCita_Sgcitadisponibilidadhorafin_N()==0)?false:true) ;
      n89CitaEstadoCita = (boolean)((obj17.getgxTv_SdtCita_Citaestadocita_N()==0)?false:true) ;
      n90CitaInforme = (boolean)((obj17.getgxTv_SdtCita_Citainforme_N()==0)?false:true) ;
      n100CitaAntecedentes = (boolean)((obj17.getgxTv_SdtCita_Citaantecedentes_N()==0)?false:true) ;
      n91CitaLink = (boolean)((obj17.getgxTv_SdtCita_Citalink_N()==0)?false:true) ;
      n92CitaFechaReserva = (boolean)((obj17.getgxTv_SdtCita_Citafechareserva_N()==0)?false:true) ;
      n93CitaLog = (boolean)((obj17.getgxTv_SdtCita_Citalog_N()==0)?false:true) ;
      n94CitaEmailGenLink = (boolean)((obj17.getgxTv_SdtCita_Citaemailgenlink_N()==0)?false:true) ;
      n95CitaEstado = (boolean)((obj17.getgxTv_SdtCita_Citaestado_N()==0)?false:true) ;
      n99CitaMotivoConsulta = (boolean)((obj17.getgxTv_SdtCita_Citamotivoconsulta_N()==0)?false:true) ;
      n96CitaArchivoNombre = (boolean)((obj17.getgxTv_SdtCita_Citaarchivonombre_N()==0)?false:true) ;
      n98CitaArchivo = (boolean)((obj17.getgxTv_SdtCita_Citaarchivo_N()==0)?false:true) ;
      n333CitaArchivoExtencion = (boolean)((obj17.getgxTv_SdtCita_Citaarchivoextencion_N()==0)?false:true) ;
      n97CitaConsentimiento = (boolean)((obj17.getgxTv_SdtCita_Citaconsentimiento_N()==0)?false:true) ;
      n101CitaGestante = (boolean)((obj17.getgxTv_SdtCita_Citagestante_N()==0)?false:true) ;
      n102CitaEstadoPago = (boolean)((obj17.getgxTv_SdtCita_Citaestadopago_N()==0)?false:true) ;
      n306CitaPeso = (boolean)((obj17.getgxTv_SdtCita_Citapeso_N()==0)?false:true) ;
      n307CitaEstatura = (boolean)((obj17.getgxTv_SdtCita_Citaestatura_N()==0)?false:true) ;
      Gx_mode = obj17.getgxTv_SdtCita_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A19CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      n19CitaId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0A17( ) ;
      scanKeyStart0A17( ) ;
      if ( RcdFound17 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z19CitaId = A19CitaId ;
      }
      zm0A17( -11) ;
      onLoadActions0A17( ) ;
      addRow0A17( ) ;
      scanKeyEnd0A17( ) ;
      if ( RcdFound17 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars17( bcCita, 0) ;
      scanKeyStart0A17( ) ;
      if ( RcdFound17 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z19CitaId = A19CitaId ;
      }
      zm0A17( -11) ;
      onLoadActions0A17( ) ;
      addRow0A17( ) ;
      scanKeyEnd0A17( ) ;
      if ( RcdFound17 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0A17( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0A17( ) ;
      }
      else
      {
         if ( RcdFound17 == 1 )
         {
            if ( A19CitaId != Z19CitaId )
            {
               A19CitaId = Z19CitaId ;
               n19CitaId = false ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0A17( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A19CitaId != Z19CitaId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0A17( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0A17( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars17( bcCita, 1) ;
      saveImpl( ) ;
      VarsToRow17( bcCita) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars17( bcCita, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0A17( ) ;
      afterTrn( ) ;
      VarsToRow17( bcCita) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtCita auxBC = new com.projectthani.SdtCita( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A19CitaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCita);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars17( bcCita, 1) ;
      updateImpl( ) ;
      VarsToRow17( bcCita) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars17( bcCita, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0A17( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow17( bcCita) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars17( bcCita, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0A17( ) ;
      if ( RcdFound17 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A19CitaId != Z19CitaId )
         {
            A19CitaId = Z19CitaId ;
            n19CitaId = false ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A19CitaId != Z19CitaId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(22);
      pr_default.close(2);
      pr_default.close(23);
      pr_default.close(3);
      pr_default.close(24);
      pr_default.close(4);
      pr_default.close(25);
      pr_default.close(5);
      pr_default.close(26);
      pr_default.close(6);
      pr_default.close(27);
      pr_default.close(7);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "cita_bc");
      VarsToRow17( bcCita) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcCita.getgxTv_SdtCita_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCita.setgxTv_SdtCita_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtCita sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCita )
      {
         bcCita = sdt ;
         if ( GXutil.strcmp(bcCita.getgxTv_SdtCita_Mode(), "") == 0 )
         {
            bcCita.setgxTv_SdtCita_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow17( bcCita) ;
         }
         else
         {
            RowToVars17( bcCita, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCita.getgxTv_SdtCita_Mode(), "") == 0 )
         {
            bcCita.setgxTv_SdtCita_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars17( bcCita, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCita getCita_BC( )
   {
      return bcCita ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV29Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z64CitaCode = "" ;
      A64CitaCode = "" ;
      Z65CitaTipoDiagnostico = "" ;
      A65CitaTipoDiagnostico = "" ;
      Z89CitaEstadoCita = "" ;
      A89CitaEstadoCita = "" ;
      Z91CitaLink = "" ;
      A91CitaLink = "" ;
      Z92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      Z93CitaLog = "" ;
      A93CitaLog = "" ;
      Z94CitaEmailGenLink = "" ;
      A94CitaEmailGenLink = "" ;
      Z95CitaEstado = "" ;
      A95CitaEstado = "" ;
      Z96CitaArchivoNombre = "" ;
      A96CitaArchivoNombre = "" ;
      Z333CitaArchivoExtencion = "" ;
      A333CitaArchivoExtencion = "" ;
      Z102CitaEstadoPago = "" ;
      A102CitaEstadoPago = "" ;
      Z306CitaPeso = DecimalUtil.ZERO ;
      A306CitaPeso = DecimalUtil.ZERO ;
      Z307CitaEstatura = DecimalUtil.ZERO ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      Z82SGCitaDisponibilidadProFullName = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      Z103PacienteApellidoPaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      A105PacienteNombres = "" ;
      Z106PacienteNroDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      Z68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z87SGCitaDisponibilidadProCOP = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      Z84ProfesionalNombres = "" ;
      A84ProfesionalNombres = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      Z146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      Z73SGCitaDisponibilidadSedeNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      Z78SGCitaDisponibilidadClinicaNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      Z90CitaInforme = "" ;
      A90CitaInforme = "" ;
      Z100CitaAntecedentes = "" ;
      A100CitaAntecedentes = "" ;
      Z99CitaMotivoConsulta = "" ;
      A99CitaMotivoConsulta = "" ;
      Z98CitaArchivo = "" ;
      A98CitaArchivo = "" ;
      BC000A10_A19CitaId = new int[1] ;
      BC000A10_n19CitaId = new boolean[] {false} ;
      BC000A10_A64CitaCode = new String[] {""} ;
      BC000A10_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000A10_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000A10_A105PacienteNombres = new String[] {""} ;
      BC000A10_A106PacienteNroDocumento = new String[] {""} ;
      BC000A10_A65CitaTipoDiagnostico = new String[] {""} ;
      BC000A10_n65CitaTipoDiagnostico = new boolean[] {false} ;
      BC000A10_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A10_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000A10_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A10_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      BC000A10_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A10_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      BC000A10_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000A10_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      BC000A10_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000A10_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      BC000A10_A89CitaEstadoCita = new String[] {""} ;
      BC000A10_n89CitaEstadoCita = new boolean[] {false} ;
      BC000A10_A90CitaInforme = new String[] {""} ;
      BC000A10_n90CitaInforme = new boolean[] {false} ;
      BC000A10_A100CitaAntecedentes = new String[] {""} ;
      BC000A10_n100CitaAntecedentes = new boolean[] {false} ;
      BC000A10_A91CitaLink = new String[] {""} ;
      BC000A10_n91CitaLink = new boolean[] {false} ;
      BC000A10_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A10_n92CitaFechaReserva = new boolean[] {false} ;
      BC000A10_A93CitaLog = new String[] {""} ;
      BC000A10_n93CitaLog = new boolean[] {false} ;
      BC000A10_A94CitaEmailGenLink = new String[] {""} ;
      BC000A10_n94CitaEmailGenLink = new boolean[] {false} ;
      BC000A10_A95CitaEstado = new String[] {""} ;
      BC000A10_n95CitaEstado = new boolean[] {false} ;
      BC000A10_A99CitaMotivoConsulta = new String[] {""} ;
      BC000A10_n99CitaMotivoConsulta = new boolean[] {false} ;
      BC000A10_A96CitaArchivoNombre = new String[] {""} ;
      BC000A10_n96CitaArchivoNombre = new boolean[] {false} ;
      BC000A10_A98CitaArchivo = new String[] {""} ;
      BC000A10_n98CitaArchivo = new boolean[] {false} ;
      BC000A10_A333CitaArchivoExtencion = new String[] {""} ;
      BC000A10_n333CitaArchivoExtencion = new boolean[] {false} ;
      BC000A10_A97CitaConsentimiento = new boolean[] {false} ;
      BC000A10_n97CitaConsentimiento = new boolean[] {false} ;
      BC000A10_A101CitaGestante = new boolean[] {false} ;
      BC000A10_n101CitaGestante = new boolean[] {false} ;
      BC000A10_A102CitaEstadoPago = new String[] {""} ;
      BC000A10_n102CitaEstadoPago = new boolean[] {false} ;
      BC000A10_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A10_n306CitaPeso = new boolean[] {false} ;
      BC000A10_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A10_n307CitaEstatura = new boolean[] {false} ;
      BC000A10_A84ProfesionalNombres = new String[] {""} ;
      BC000A10_n84ProfesionalNombres = new boolean[] {false} ;
      BC000A10_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000A10_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000A10_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000A10_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000A10_A20PacienteId = new int[1] ;
      BC000A10_A21SGCitaDisponibilidadId = new int[1] ;
      BC000A10_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000A10_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000A10_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000A10_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000A11_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000A11_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000A11_A105PacienteNombres = new String[] {""} ;
      BC000A11_A106PacienteNroDocumento = new String[] {""} ;
      BC000A12_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A12_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000A12_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A12_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      BC000A12_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A12_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      BC000A12_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000A12_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000A12_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000A13_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      BC000A13_A84ProfesionalNombres = new String[] {""} ;
      BC000A13_n84ProfesionalNombres = new boolean[] {false} ;
      BC000A13_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000A13_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000A13_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000A13_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000A14_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000A15_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      BC000A15_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000A16_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000A17_A19CitaId = new int[1] ;
      BC000A17_n19CitaId = new boolean[] {false} ;
      BC000A18_A19CitaId = new int[1] ;
      BC000A18_n19CitaId = new boolean[] {false} ;
      BC000A18_A64CitaCode = new String[] {""} ;
      BC000A18_A65CitaTipoDiagnostico = new String[] {""} ;
      BC000A18_n65CitaTipoDiagnostico = new boolean[] {false} ;
      BC000A18_A89CitaEstadoCita = new String[] {""} ;
      BC000A18_n89CitaEstadoCita = new boolean[] {false} ;
      BC000A18_A90CitaInforme = new String[] {""} ;
      BC000A18_n90CitaInforme = new boolean[] {false} ;
      BC000A18_A100CitaAntecedentes = new String[] {""} ;
      BC000A18_n100CitaAntecedentes = new boolean[] {false} ;
      BC000A18_A91CitaLink = new String[] {""} ;
      BC000A18_n91CitaLink = new boolean[] {false} ;
      BC000A18_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A18_n92CitaFechaReserva = new boolean[] {false} ;
      BC000A18_A93CitaLog = new String[] {""} ;
      BC000A18_n93CitaLog = new boolean[] {false} ;
      BC000A18_A94CitaEmailGenLink = new String[] {""} ;
      BC000A18_n94CitaEmailGenLink = new boolean[] {false} ;
      BC000A18_A95CitaEstado = new String[] {""} ;
      BC000A18_n95CitaEstado = new boolean[] {false} ;
      BC000A18_A99CitaMotivoConsulta = new String[] {""} ;
      BC000A18_n99CitaMotivoConsulta = new boolean[] {false} ;
      BC000A18_A96CitaArchivoNombre = new String[] {""} ;
      BC000A18_n96CitaArchivoNombre = new boolean[] {false} ;
      BC000A18_A98CitaArchivo = new String[] {""} ;
      BC000A18_n98CitaArchivo = new boolean[] {false} ;
      BC000A18_A333CitaArchivoExtencion = new String[] {""} ;
      BC000A18_n333CitaArchivoExtencion = new boolean[] {false} ;
      BC000A18_A97CitaConsentimiento = new boolean[] {false} ;
      BC000A18_n97CitaConsentimiento = new boolean[] {false} ;
      BC000A18_A101CitaGestante = new boolean[] {false} ;
      BC000A18_n101CitaGestante = new boolean[] {false} ;
      BC000A18_A102CitaEstadoPago = new String[] {""} ;
      BC000A18_n102CitaEstadoPago = new boolean[] {false} ;
      BC000A18_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A18_n306CitaPeso = new boolean[] {false} ;
      BC000A18_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A18_n307CitaEstatura = new boolean[] {false} ;
      BC000A18_A20PacienteId = new int[1] ;
      BC000A18_A21SGCitaDisponibilidadId = new int[1] ;
      sMode17 = "" ;
      BC000A19_A19CitaId = new int[1] ;
      BC000A19_n19CitaId = new boolean[] {false} ;
      BC000A19_A64CitaCode = new String[] {""} ;
      BC000A19_A65CitaTipoDiagnostico = new String[] {""} ;
      BC000A19_n65CitaTipoDiagnostico = new boolean[] {false} ;
      BC000A19_A89CitaEstadoCita = new String[] {""} ;
      BC000A19_n89CitaEstadoCita = new boolean[] {false} ;
      BC000A19_A90CitaInforme = new String[] {""} ;
      BC000A19_n90CitaInforme = new boolean[] {false} ;
      BC000A19_A100CitaAntecedentes = new String[] {""} ;
      BC000A19_n100CitaAntecedentes = new boolean[] {false} ;
      BC000A19_A91CitaLink = new String[] {""} ;
      BC000A19_n91CitaLink = new boolean[] {false} ;
      BC000A19_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A19_n92CitaFechaReserva = new boolean[] {false} ;
      BC000A19_A93CitaLog = new String[] {""} ;
      BC000A19_n93CitaLog = new boolean[] {false} ;
      BC000A19_A94CitaEmailGenLink = new String[] {""} ;
      BC000A19_n94CitaEmailGenLink = new boolean[] {false} ;
      BC000A19_A95CitaEstado = new String[] {""} ;
      BC000A19_n95CitaEstado = new boolean[] {false} ;
      BC000A19_A99CitaMotivoConsulta = new String[] {""} ;
      BC000A19_n99CitaMotivoConsulta = new boolean[] {false} ;
      BC000A19_A96CitaArchivoNombre = new String[] {""} ;
      BC000A19_n96CitaArchivoNombre = new boolean[] {false} ;
      BC000A19_A98CitaArchivo = new String[] {""} ;
      BC000A19_n98CitaArchivo = new boolean[] {false} ;
      BC000A19_A333CitaArchivoExtencion = new String[] {""} ;
      BC000A19_n333CitaArchivoExtencion = new boolean[] {false} ;
      BC000A19_A97CitaConsentimiento = new boolean[] {false} ;
      BC000A19_n97CitaConsentimiento = new boolean[] {false} ;
      BC000A19_A101CitaGestante = new boolean[] {false} ;
      BC000A19_n101CitaGestante = new boolean[] {false} ;
      BC000A19_A102CitaEstadoPago = new String[] {""} ;
      BC000A19_n102CitaEstadoPago = new boolean[] {false} ;
      BC000A19_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A19_n306CitaPeso = new boolean[] {false} ;
      BC000A19_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A19_n307CitaEstatura = new boolean[] {false} ;
      BC000A19_A20PacienteId = new int[1] ;
      BC000A19_A21SGCitaDisponibilidadId = new int[1] ;
      BC000A20_A19CitaId = new int[1] ;
      BC000A20_n19CitaId = new boolean[] {false} ;
      BC000A24_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000A24_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000A24_A105PacienteNombres = new String[] {""} ;
      BC000A24_A106PacienteNroDocumento = new String[] {""} ;
      BC000A25_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A25_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000A25_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A25_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      BC000A25_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A25_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      BC000A25_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000A25_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000A25_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000A26_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      BC000A26_A84ProfesionalNombres = new String[] {""} ;
      BC000A26_n84ProfesionalNombres = new boolean[] {false} ;
      BC000A26_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000A26_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000A26_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000A26_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000A27_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000A28_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      BC000A28_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000A29_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000A30_A50RecetaMedicaId = new short[1] ;
      BC000A31_A47PagoId = new int[1] ;
      BC000A32_A37EncuestaId = new short[1] ;
      BC000A33_A26CitaServicioId = new int[1] ;
      BC000A34_A24CitaRecetaId = new int[1] ;
      BC000A35_A22CitaDiagnosticoId = new int[1] ;
      BC000A36_A19CitaId = new int[1] ;
      BC000A36_n19CitaId = new boolean[] {false} ;
      BC000A36_A64CitaCode = new String[] {""} ;
      BC000A36_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000A36_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000A36_A105PacienteNombres = new String[] {""} ;
      BC000A36_A106PacienteNroDocumento = new String[] {""} ;
      BC000A36_A65CitaTipoDiagnostico = new String[] {""} ;
      BC000A36_n65CitaTipoDiagnostico = new boolean[] {false} ;
      BC000A36_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A36_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000A36_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A36_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      BC000A36_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A36_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      BC000A36_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000A36_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      BC000A36_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000A36_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      BC000A36_A89CitaEstadoCita = new String[] {""} ;
      BC000A36_n89CitaEstadoCita = new boolean[] {false} ;
      BC000A36_A90CitaInforme = new String[] {""} ;
      BC000A36_n90CitaInforme = new boolean[] {false} ;
      BC000A36_A100CitaAntecedentes = new String[] {""} ;
      BC000A36_n100CitaAntecedentes = new boolean[] {false} ;
      BC000A36_A91CitaLink = new String[] {""} ;
      BC000A36_n91CitaLink = new boolean[] {false} ;
      BC000A36_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      BC000A36_n92CitaFechaReserva = new boolean[] {false} ;
      BC000A36_A93CitaLog = new String[] {""} ;
      BC000A36_n93CitaLog = new boolean[] {false} ;
      BC000A36_A94CitaEmailGenLink = new String[] {""} ;
      BC000A36_n94CitaEmailGenLink = new boolean[] {false} ;
      BC000A36_A95CitaEstado = new String[] {""} ;
      BC000A36_n95CitaEstado = new boolean[] {false} ;
      BC000A36_A99CitaMotivoConsulta = new String[] {""} ;
      BC000A36_n99CitaMotivoConsulta = new boolean[] {false} ;
      BC000A36_A96CitaArchivoNombre = new String[] {""} ;
      BC000A36_n96CitaArchivoNombre = new boolean[] {false} ;
      BC000A36_A98CitaArchivo = new String[] {""} ;
      BC000A36_n98CitaArchivo = new boolean[] {false} ;
      BC000A36_A333CitaArchivoExtencion = new String[] {""} ;
      BC000A36_n333CitaArchivoExtencion = new boolean[] {false} ;
      BC000A36_A97CitaConsentimiento = new boolean[] {false} ;
      BC000A36_n97CitaConsentimiento = new boolean[] {false} ;
      BC000A36_A101CitaGestante = new boolean[] {false} ;
      BC000A36_n101CitaGestante = new boolean[] {false} ;
      BC000A36_A102CitaEstadoPago = new String[] {""} ;
      BC000A36_n102CitaEstadoPago = new boolean[] {false} ;
      BC000A36_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A36_n306CitaPeso = new boolean[] {false} ;
      BC000A36_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000A36_n307CitaEstatura = new boolean[] {false} ;
      BC000A36_A84ProfesionalNombres = new String[] {""} ;
      BC000A36_n84ProfesionalNombres = new boolean[] {false} ;
      BC000A36_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000A36_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000A36_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000A36_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000A36_A20PacienteId = new int[1] ;
      BC000A36_A21SGCitaDisponibilidadId = new int[1] ;
      BC000A36_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000A36_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000A36_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000A36_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.cita_bc__default(),
         new Object[] {
             new Object[] {
            BC000A2_A19CitaId, BC000A2_A64CitaCode, BC000A2_A65CitaTipoDiagnostico, BC000A2_n65CitaTipoDiagnostico, BC000A2_A89CitaEstadoCita, BC000A2_n89CitaEstadoCita, BC000A2_A90CitaInforme, BC000A2_n90CitaInforme, BC000A2_A100CitaAntecedentes, BC000A2_n100CitaAntecedentes,
            BC000A2_A91CitaLink, BC000A2_n91CitaLink, BC000A2_A92CitaFechaReserva, BC000A2_n92CitaFechaReserva, BC000A2_A93CitaLog, BC000A2_n93CitaLog, BC000A2_A94CitaEmailGenLink, BC000A2_n94CitaEmailGenLink, BC000A2_A95CitaEstado, BC000A2_n95CitaEstado,
            BC000A2_A99CitaMotivoConsulta, BC000A2_n99CitaMotivoConsulta, BC000A2_A96CitaArchivoNombre, BC000A2_n96CitaArchivoNombre, BC000A2_A98CitaArchivo, BC000A2_n98CitaArchivo, BC000A2_A333CitaArchivoExtencion, BC000A2_n333CitaArchivoExtencion, BC000A2_A97CitaConsentimiento, BC000A2_n97CitaConsentimiento,
            BC000A2_A101CitaGestante, BC000A2_n101CitaGestante, BC000A2_A102CitaEstadoPago, BC000A2_n102CitaEstadoPago, BC000A2_A306CitaPeso, BC000A2_n306CitaPeso, BC000A2_A307CitaEstatura, BC000A2_n307CitaEstatura, BC000A2_A20PacienteId, BC000A2_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000A3_A19CitaId, BC000A3_A64CitaCode, BC000A3_A65CitaTipoDiagnostico, BC000A3_n65CitaTipoDiagnostico, BC000A3_A89CitaEstadoCita, BC000A3_n89CitaEstadoCita, BC000A3_A90CitaInforme, BC000A3_n90CitaInforme, BC000A3_A100CitaAntecedentes, BC000A3_n100CitaAntecedentes,
            BC000A3_A91CitaLink, BC000A3_n91CitaLink, BC000A3_A92CitaFechaReserva, BC000A3_n92CitaFechaReserva, BC000A3_A93CitaLog, BC000A3_n93CitaLog, BC000A3_A94CitaEmailGenLink, BC000A3_n94CitaEmailGenLink, BC000A3_A95CitaEstado, BC000A3_n95CitaEstado,
            BC000A3_A99CitaMotivoConsulta, BC000A3_n99CitaMotivoConsulta, BC000A3_A96CitaArchivoNombre, BC000A3_n96CitaArchivoNombre, BC000A3_A98CitaArchivo, BC000A3_n98CitaArchivo, BC000A3_A333CitaArchivoExtencion, BC000A3_n333CitaArchivoExtencion, BC000A3_A97CitaConsentimiento, BC000A3_n97CitaConsentimiento,
            BC000A3_A101CitaGestante, BC000A3_n101CitaGestante, BC000A3_A102CitaEstadoPago, BC000A3_n102CitaEstadoPago, BC000A3_A306CitaPeso, BC000A3_n306CitaPeso, BC000A3_A307CitaEstatura, BC000A3_n307CitaEstatura, BC000A3_A20PacienteId, BC000A3_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000A4_A103PacienteApellidoPaterno, BC000A4_A104PacienteApellidoMaterno, BC000A4_A105PacienteNombres, BC000A4_A106PacienteNroDocumento
            }
            , new Object[] {
            BC000A5_A66SGCitaDisponibilidadFecha, BC000A5_n66SGCitaDisponibilidadFecha, BC000A5_A68SGCitaDisponibilidadHoraInicio, BC000A5_n68SGCitaDisponibilidadHoraInicio, BC000A5_A387SGCitaDisponibilidadHoraFin, BC000A5_n387SGCitaDisponibilidadHoraFin, BC000A5_A81SGCitaDisponibilidadProfesionalId, BC000A5_A70SGCitaDisponibilidadEspecialidadId, BC000A5_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            BC000A6_A87SGCitaDisponibilidadProCOP, BC000A6_A84ProfesionalNombres, BC000A6_n84ProfesionalNombres, BC000A6_A85ProfesionalApellidoPaterno, BC000A6_n85ProfesionalApellidoPaterno, BC000A6_A86ProfesionalApellidoMaterno, BC000A6_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000A7_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000A8_A73SGCitaDisponibilidadSedeNombre, BC000A8_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000A9_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000A10_A19CitaId, BC000A10_A64CitaCode, BC000A10_A103PacienteApellidoPaterno, BC000A10_A104PacienteApellidoMaterno, BC000A10_A105PacienteNombres, BC000A10_A106PacienteNroDocumento, BC000A10_A65CitaTipoDiagnostico, BC000A10_n65CitaTipoDiagnostico, BC000A10_A66SGCitaDisponibilidadFecha, BC000A10_n66SGCitaDisponibilidadFecha,
            BC000A10_A68SGCitaDisponibilidadHoraInicio, BC000A10_n68SGCitaDisponibilidadHoraInicio, BC000A10_A387SGCitaDisponibilidadHoraFin, BC000A10_n387SGCitaDisponibilidadHoraFin, BC000A10_A146SGCitaDisponibilidadEspecialidadNombre, BC000A10_A73SGCitaDisponibilidadSedeNombre, BC000A10_A78SGCitaDisponibilidadClinicaNombre, BC000A10_A87SGCitaDisponibilidadProCOP, BC000A10_A89CitaEstadoCita, BC000A10_n89CitaEstadoCita,
            BC000A10_A90CitaInforme, BC000A10_n90CitaInforme, BC000A10_A100CitaAntecedentes, BC000A10_n100CitaAntecedentes, BC000A10_A91CitaLink, BC000A10_n91CitaLink, BC000A10_A92CitaFechaReserva, BC000A10_n92CitaFechaReserva, BC000A10_A93CitaLog, BC000A10_n93CitaLog,
            BC000A10_A94CitaEmailGenLink, BC000A10_n94CitaEmailGenLink, BC000A10_A95CitaEstado, BC000A10_n95CitaEstado, BC000A10_A99CitaMotivoConsulta, BC000A10_n99CitaMotivoConsulta, BC000A10_A96CitaArchivoNombre, BC000A10_n96CitaArchivoNombre, BC000A10_A98CitaArchivo, BC000A10_n98CitaArchivo,
            BC000A10_A333CitaArchivoExtencion, BC000A10_n333CitaArchivoExtencion, BC000A10_A97CitaConsentimiento, BC000A10_n97CitaConsentimiento, BC000A10_A101CitaGestante, BC000A10_n101CitaGestante, BC000A10_A102CitaEstadoPago, BC000A10_n102CitaEstadoPago, BC000A10_A306CitaPeso, BC000A10_n306CitaPeso,
            BC000A10_A307CitaEstatura, BC000A10_n307CitaEstatura, BC000A10_A84ProfesionalNombres, BC000A10_n84ProfesionalNombres, BC000A10_A85ProfesionalApellidoPaterno, BC000A10_n85ProfesionalApellidoPaterno, BC000A10_A86ProfesionalApellidoMaterno, BC000A10_n86ProfesionalApellidoMaterno, BC000A10_A20PacienteId, BC000A10_A21SGCitaDisponibilidadId,
            BC000A10_A81SGCitaDisponibilidadProfesionalId, BC000A10_A70SGCitaDisponibilidadEspecialidadId, BC000A10_A72SGCitaDisponibilidadSedeId, BC000A10_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000A11_A103PacienteApellidoPaterno, BC000A11_A104PacienteApellidoMaterno, BC000A11_A105PacienteNombres, BC000A11_A106PacienteNroDocumento
            }
            , new Object[] {
            BC000A12_A66SGCitaDisponibilidadFecha, BC000A12_n66SGCitaDisponibilidadFecha, BC000A12_A68SGCitaDisponibilidadHoraInicio, BC000A12_n68SGCitaDisponibilidadHoraInicio, BC000A12_A387SGCitaDisponibilidadHoraFin, BC000A12_n387SGCitaDisponibilidadHoraFin, BC000A12_A81SGCitaDisponibilidadProfesionalId, BC000A12_A70SGCitaDisponibilidadEspecialidadId, BC000A12_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            BC000A13_A87SGCitaDisponibilidadProCOP, BC000A13_A84ProfesionalNombres, BC000A13_n84ProfesionalNombres, BC000A13_A85ProfesionalApellidoPaterno, BC000A13_n85ProfesionalApellidoPaterno, BC000A13_A86ProfesionalApellidoMaterno, BC000A13_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000A14_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000A15_A73SGCitaDisponibilidadSedeNombre, BC000A15_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000A16_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000A17_A19CitaId
            }
            , new Object[] {
            BC000A18_A19CitaId, BC000A18_A64CitaCode, BC000A18_A65CitaTipoDiagnostico, BC000A18_n65CitaTipoDiagnostico, BC000A18_A89CitaEstadoCita, BC000A18_n89CitaEstadoCita, BC000A18_A90CitaInforme, BC000A18_n90CitaInforme, BC000A18_A100CitaAntecedentes, BC000A18_n100CitaAntecedentes,
            BC000A18_A91CitaLink, BC000A18_n91CitaLink, BC000A18_A92CitaFechaReserva, BC000A18_n92CitaFechaReserva, BC000A18_A93CitaLog, BC000A18_n93CitaLog, BC000A18_A94CitaEmailGenLink, BC000A18_n94CitaEmailGenLink, BC000A18_A95CitaEstado, BC000A18_n95CitaEstado,
            BC000A18_A99CitaMotivoConsulta, BC000A18_n99CitaMotivoConsulta, BC000A18_A96CitaArchivoNombre, BC000A18_n96CitaArchivoNombre, BC000A18_A98CitaArchivo, BC000A18_n98CitaArchivo, BC000A18_A333CitaArchivoExtencion, BC000A18_n333CitaArchivoExtencion, BC000A18_A97CitaConsentimiento, BC000A18_n97CitaConsentimiento,
            BC000A18_A101CitaGestante, BC000A18_n101CitaGestante, BC000A18_A102CitaEstadoPago, BC000A18_n102CitaEstadoPago, BC000A18_A306CitaPeso, BC000A18_n306CitaPeso, BC000A18_A307CitaEstatura, BC000A18_n307CitaEstatura, BC000A18_A20PacienteId, BC000A18_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000A19_A19CitaId, BC000A19_A64CitaCode, BC000A19_A65CitaTipoDiagnostico, BC000A19_n65CitaTipoDiagnostico, BC000A19_A89CitaEstadoCita, BC000A19_n89CitaEstadoCita, BC000A19_A90CitaInforme, BC000A19_n90CitaInforme, BC000A19_A100CitaAntecedentes, BC000A19_n100CitaAntecedentes,
            BC000A19_A91CitaLink, BC000A19_n91CitaLink, BC000A19_A92CitaFechaReserva, BC000A19_n92CitaFechaReserva, BC000A19_A93CitaLog, BC000A19_n93CitaLog, BC000A19_A94CitaEmailGenLink, BC000A19_n94CitaEmailGenLink, BC000A19_A95CitaEstado, BC000A19_n95CitaEstado,
            BC000A19_A99CitaMotivoConsulta, BC000A19_n99CitaMotivoConsulta, BC000A19_A96CitaArchivoNombre, BC000A19_n96CitaArchivoNombre, BC000A19_A98CitaArchivo, BC000A19_n98CitaArchivo, BC000A19_A333CitaArchivoExtencion, BC000A19_n333CitaArchivoExtencion, BC000A19_A97CitaConsentimiento, BC000A19_n97CitaConsentimiento,
            BC000A19_A101CitaGestante, BC000A19_n101CitaGestante, BC000A19_A102CitaEstadoPago, BC000A19_n102CitaEstadoPago, BC000A19_A306CitaPeso, BC000A19_n306CitaPeso, BC000A19_A307CitaEstatura, BC000A19_n307CitaEstatura, BC000A19_A20PacienteId, BC000A19_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000A20_A19CitaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000A24_A103PacienteApellidoPaterno, BC000A24_A104PacienteApellidoMaterno, BC000A24_A105PacienteNombres, BC000A24_A106PacienteNroDocumento
            }
            , new Object[] {
            BC000A25_A66SGCitaDisponibilidadFecha, BC000A25_n66SGCitaDisponibilidadFecha, BC000A25_A68SGCitaDisponibilidadHoraInicio, BC000A25_n68SGCitaDisponibilidadHoraInicio, BC000A25_A387SGCitaDisponibilidadHoraFin, BC000A25_n387SGCitaDisponibilidadHoraFin, BC000A25_A81SGCitaDisponibilidadProfesionalId, BC000A25_A70SGCitaDisponibilidadEspecialidadId, BC000A25_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            BC000A26_A87SGCitaDisponibilidadProCOP, BC000A26_A84ProfesionalNombres, BC000A26_n84ProfesionalNombres, BC000A26_A85ProfesionalApellidoPaterno, BC000A26_n85ProfesionalApellidoPaterno, BC000A26_A86ProfesionalApellidoMaterno, BC000A26_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000A27_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000A28_A73SGCitaDisponibilidadSedeNombre, BC000A28_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000A29_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000A30_A50RecetaMedicaId
            }
            , new Object[] {
            BC000A31_A47PagoId
            }
            , new Object[] {
            BC000A32_A37EncuestaId
            }
            , new Object[] {
            BC000A33_A26CitaServicioId
            }
            , new Object[] {
            BC000A34_A24CitaRecetaId
            }
            , new Object[] {
            BC000A35_A22CitaDiagnosticoId
            }
            , new Object[] {
            BC000A36_A19CitaId, BC000A36_A64CitaCode, BC000A36_A103PacienteApellidoPaterno, BC000A36_A104PacienteApellidoMaterno, BC000A36_A105PacienteNombres, BC000A36_A106PacienteNroDocumento, BC000A36_A65CitaTipoDiagnostico, BC000A36_n65CitaTipoDiagnostico, BC000A36_A66SGCitaDisponibilidadFecha, BC000A36_n66SGCitaDisponibilidadFecha,
            BC000A36_A68SGCitaDisponibilidadHoraInicio, BC000A36_n68SGCitaDisponibilidadHoraInicio, BC000A36_A387SGCitaDisponibilidadHoraFin, BC000A36_n387SGCitaDisponibilidadHoraFin, BC000A36_A146SGCitaDisponibilidadEspecialidadNombre, BC000A36_A73SGCitaDisponibilidadSedeNombre, BC000A36_A78SGCitaDisponibilidadClinicaNombre, BC000A36_A87SGCitaDisponibilidadProCOP, BC000A36_A89CitaEstadoCita, BC000A36_n89CitaEstadoCita,
            BC000A36_A90CitaInforme, BC000A36_n90CitaInforme, BC000A36_A100CitaAntecedentes, BC000A36_n100CitaAntecedentes, BC000A36_A91CitaLink, BC000A36_n91CitaLink, BC000A36_A92CitaFechaReserva, BC000A36_n92CitaFechaReserva, BC000A36_A93CitaLog, BC000A36_n93CitaLog,
            BC000A36_A94CitaEmailGenLink, BC000A36_n94CitaEmailGenLink, BC000A36_A95CitaEstado, BC000A36_n95CitaEstado, BC000A36_A99CitaMotivoConsulta, BC000A36_n99CitaMotivoConsulta, BC000A36_A96CitaArchivoNombre, BC000A36_n96CitaArchivoNombre, BC000A36_A98CitaArchivo, BC000A36_n98CitaArchivo,
            BC000A36_A333CitaArchivoExtencion, BC000A36_n333CitaArchivoExtencion, BC000A36_A97CitaConsentimiento, BC000A36_n97CitaConsentimiento, BC000A36_A101CitaGestante, BC000A36_n101CitaGestante, BC000A36_A102CitaEstadoPago, BC000A36_n102CitaEstadoPago, BC000A36_A306CitaPeso, BC000A36_n306CitaPeso,
            BC000A36_A307CitaEstatura, BC000A36_n307CitaEstatura, BC000A36_A84ProfesionalNombres, BC000A36_n84ProfesionalNombres, BC000A36_A85ProfesionalApellidoPaterno, BC000A36_n85ProfesionalApellidoPaterno, BC000A36_A86ProfesionalApellidoMaterno, BC000A36_n86ProfesionalApellidoMaterno, BC000A36_A20PacienteId, BC000A36_A21SGCitaDisponibilidadId,
            BC000A36_A81SGCitaDisponibilidadProfesionalId, BC000A36_A70SGCitaDisponibilidadEspecialidadId, BC000A36_A72SGCitaDisponibilidadSedeId, BC000A36_A76SGCitaDisponibilidadClinicaId
            }
         }
      );
      AV29Pgmname = "Cita_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120A2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z70SGCitaDisponibilidadEspecialidadId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short Z72SGCitaDisponibilidadSedeId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short Z76SGCitaDisponibilidadClinicaId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short RcdFound17 ;
   private short nIsDirty_17 ;
   private int trnEnded ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int AV30GXV1 ;
   private int AV12Insert_PacienteId ;
   private int AV13Insert_SGCitaDisponibilidadId ;
   private int GX_JID ;
   private int Z20PacienteId ;
   private int A20PacienteId ;
   private int Z21SGCitaDisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private int Z81SGCitaDisponibilidadProfesionalId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private java.math.BigDecimal Z306CitaPeso ;
   private java.math.BigDecimal A306CitaPeso ;
   private java.math.BigDecimal Z307CitaEstatura ;
   private java.math.BigDecimal A307CitaEstatura ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV29Pgmname ;
   private String Z89CitaEstadoCita ;
   private String A89CitaEstadoCita ;
   private String Z95CitaEstado ;
   private String A95CitaEstado ;
   private String Z102CitaEstadoPago ;
   private String A102CitaEstadoPago ;
   private String sMode17 ;
   private java.util.Date Z92CitaFechaReserva ;
   private java.util.Date A92CitaFechaReserva ;
   private java.util.Date Z68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date Z387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z97CitaConsentimiento ;
   private boolean A97CitaConsentimiento ;
   private boolean Z101CitaGestante ;
   private boolean A101CitaGestante ;
   private boolean n19CitaId ;
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
   private boolean n333CitaArchivoExtencion ;
   private boolean n97CitaConsentimiento ;
   private boolean n101CitaGestante ;
   private boolean n102CitaEstadoPago ;
   private boolean n306CitaPeso ;
   private boolean n307CitaEstatura ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z90CitaInforme ;
   private String A90CitaInforme ;
   private String Z100CitaAntecedentes ;
   private String A100CitaAntecedentes ;
   private String Z99CitaMotivoConsulta ;
   private String A99CitaMotivoConsulta ;
   private String Z98CitaArchivo ;
   private String A98CitaArchivo ;
   private String Z64CitaCode ;
   private String A64CitaCode ;
   private String Z65CitaTipoDiagnostico ;
   private String A65CitaTipoDiagnostico ;
   private String Z91CitaLink ;
   private String A91CitaLink ;
   private String Z93CitaLog ;
   private String A93CitaLog ;
   private String Z94CitaEmailGenLink ;
   private String A94CitaEmailGenLink ;
   private String Z96CitaArchivoNombre ;
   private String A96CitaArchivoNombre ;
   private String Z333CitaArchivoExtencion ;
   private String A333CitaArchivoExtencion ;
   private String Z82SGCitaDisponibilidadProFullName ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String Z103PacienteApellidoPaterno ;
   private String A103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String A104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String A105PacienteNombres ;
   private String Z106PacienteNroDocumento ;
   private String A106PacienteNroDocumento ;
   private String Z87SGCitaDisponibilidadProCOP ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String Z84ProfesionalNombres ;
   private String A84ProfesionalNombres ;
   private String Z85ProfesionalApellidoPaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String Z146SGCitaDisponibilidadEspecialidadNombre ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String Z73SGCitaDisponibilidadSedeNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String Z78SGCitaDisponibilidadClinicaNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtCita bcCita ;
   private IDataStoreProvider pr_default ;
   private int[] BC000A10_A19CitaId ;
   private boolean[] BC000A10_n19CitaId ;
   private String[] BC000A10_A64CitaCode ;
   private String[] BC000A10_A103PacienteApellidoPaterno ;
   private String[] BC000A10_A104PacienteApellidoMaterno ;
   private String[] BC000A10_A105PacienteNombres ;
   private String[] BC000A10_A106PacienteNroDocumento ;
   private String[] BC000A10_A65CitaTipoDiagnostico ;
   private boolean[] BC000A10_n65CitaTipoDiagnostico ;
   private java.util.Date[] BC000A10_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000A10_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] BC000A10_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] BC000A10_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] BC000A10_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] BC000A10_n387SGCitaDisponibilidadHoraFin ;
   private String[] BC000A10_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] BC000A10_A73SGCitaDisponibilidadSedeNombre ;
   private String[] BC000A10_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000A10_A87SGCitaDisponibilidadProCOP ;
   private String[] BC000A10_A89CitaEstadoCita ;
   private boolean[] BC000A10_n89CitaEstadoCita ;
   private String[] BC000A10_A90CitaInforme ;
   private boolean[] BC000A10_n90CitaInforme ;
   private String[] BC000A10_A100CitaAntecedentes ;
   private boolean[] BC000A10_n100CitaAntecedentes ;
   private String[] BC000A10_A91CitaLink ;
   private boolean[] BC000A10_n91CitaLink ;
   private java.util.Date[] BC000A10_A92CitaFechaReserva ;
   private boolean[] BC000A10_n92CitaFechaReserva ;
   private String[] BC000A10_A93CitaLog ;
   private boolean[] BC000A10_n93CitaLog ;
   private String[] BC000A10_A94CitaEmailGenLink ;
   private boolean[] BC000A10_n94CitaEmailGenLink ;
   private String[] BC000A10_A95CitaEstado ;
   private boolean[] BC000A10_n95CitaEstado ;
   private String[] BC000A10_A99CitaMotivoConsulta ;
   private boolean[] BC000A10_n99CitaMotivoConsulta ;
   private String[] BC000A10_A96CitaArchivoNombre ;
   private boolean[] BC000A10_n96CitaArchivoNombre ;
   private String[] BC000A10_A98CitaArchivo ;
   private boolean[] BC000A10_n98CitaArchivo ;
   private String[] BC000A10_A333CitaArchivoExtencion ;
   private boolean[] BC000A10_n333CitaArchivoExtencion ;
   private boolean[] BC000A10_A97CitaConsentimiento ;
   private boolean[] BC000A10_n97CitaConsentimiento ;
   private boolean[] BC000A10_A101CitaGestante ;
   private boolean[] BC000A10_n101CitaGestante ;
   private String[] BC000A10_A102CitaEstadoPago ;
   private boolean[] BC000A10_n102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A10_A306CitaPeso ;
   private boolean[] BC000A10_n306CitaPeso ;
   private java.math.BigDecimal[] BC000A10_A307CitaEstatura ;
   private boolean[] BC000A10_n307CitaEstatura ;
   private String[] BC000A10_A84ProfesionalNombres ;
   private boolean[] BC000A10_n84ProfesionalNombres ;
   private String[] BC000A10_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000A10_n85ProfesionalApellidoPaterno ;
   private String[] BC000A10_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000A10_n86ProfesionalApellidoMaterno ;
   private int[] BC000A10_A20PacienteId ;
   private int[] BC000A10_A21SGCitaDisponibilidadId ;
   private int[] BC000A10_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000A10_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000A10_A72SGCitaDisponibilidadSedeId ;
   private short[] BC000A10_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000A11_A103PacienteApellidoPaterno ;
   private String[] BC000A11_A104PacienteApellidoMaterno ;
   private String[] BC000A11_A105PacienteNombres ;
   private String[] BC000A11_A106PacienteNroDocumento ;
   private java.util.Date[] BC000A12_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000A12_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] BC000A12_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] BC000A12_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] BC000A12_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] BC000A12_n387SGCitaDisponibilidadHoraFin ;
   private int[] BC000A12_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000A12_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000A12_A72SGCitaDisponibilidadSedeId ;
   private String[] BC000A13_A87SGCitaDisponibilidadProCOP ;
   private String[] BC000A13_A84ProfesionalNombres ;
   private boolean[] BC000A13_n84ProfesionalNombres ;
   private String[] BC000A13_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000A13_n85ProfesionalApellidoPaterno ;
   private String[] BC000A13_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000A13_n86ProfesionalApellidoMaterno ;
   private String[] BC000A14_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] BC000A15_A73SGCitaDisponibilidadSedeNombre ;
   private short[] BC000A15_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000A16_A78SGCitaDisponibilidadClinicaNombre ;
   private int[] BC000A17_A19CitaId ;
   private boolean[] BC000A17_n19CitaId ;
   private int[] BC000A18_A19CitaId ;
   private boolean[] BC000A18_n19CitaId ;
   private String[] BC000A18_A64CitaCode ;
   private String[] BC000A18_A65CitaTipoDiagnostico ;
   private boolean[] BC000A18_n65CitaTipoDiagnostico ;
   private String[] BC000A18_A89CitaEstadoCita ;
   private boolean[] BC000A18_n89CitaEstadoCita ;
   private String[] BC000A18_A90CitaInforme ;
   private boolean[] BC000A18_n90CitaInforme ;
   private String[] BC000A18_A100CitaAntecedentes ;
   private boolean[] BC000A18_n100CitaAntecedentes ;
   private String[] BC000A18_A91CitaLink ;
   private boolean[] BC000A18_n91CitaLink ;
   private java.util.Date[] BC000A18_A92CitaFechaReserva ;
   private boolean[] BC000A18_n92CitaFechaReserva ;
   private String[] BC000A18_A93CitaLog ;
   private boolean[] BC000A18_n93CitaLog ;
   private String[] BC000A18_A94CitaEmailGenLink ;
   private boolean[] BC000A18_n94CitaEmailGenLink ;
   private String[] BC000A18_A95CitaEstado ;
   private boolean[] BC000A18_n95CitaEstado ;
   private String[] BC000A18_A99CitaMotivoConsulta ;
   private boolean[] BC000A18_n99CitaMotivoConsulta ;
   private String[] BC000A18_A96CitaArchivoNombre ;
   private boolean[] BC000A18_n96CitaArchivoNombre ;
   private String[] BC000A18_A98CitaArchivo ;
   private boolean[] BC000A18_n98CitaArchivo ;
   private String[] BC000A18_A333CitaArchivoExtencion ;
   private boolean[] BC000A18_n333CitaArchivoExtencion ;
   private boolean[] BC000A18_A97CitaConsentimiento ;
   private boolean[] BC000A18_n97CitaConsentimiento ;
   private boolean[] BC000A18_A101CitaGestante ;
   private boolean[] BC000A18_n101CitaGestante ;
   private String[] BC000A18_A102CitaEstadoPago ;
   private boolean[] BC000A18_n102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A18_A306CitaPeso ;
   private boolean[] BC000A18_n306CitaPeso ;
   private java.math.BigDecimal[] BC000A18_A307CitaEstatura ;
   private boolean[] BC000A18_n307CitaEstatura ;
   private int[] BC000A18_A20PacienteId ;
   private int[] BC000A18_A21SGCitaDisponibilidadId ;
   private int[] BC000A19_A19CitaId ;
   private boolean[] BC000A19_n19CitaId ;
   private String[] BC000A19_A64CitaCode ;
   private String[] BC000A19_A65CitaTipoDiagnostico ;
   private boolean[] BC000A19_n65CitaTipoDiagnostico ;
   private String[] BC000A19_A89CitaEstadoCita ;
   private boolean[] BC000A19_n89CitaEstadoCita ;
   private String[] BC000A19_A90CitaInforme ;
   private boolean[] BC000A19_n90CitaInforme ;
   private String[] BC000A19_A100CitaAntecedentes ;
   private boolean[] BC000A19_n100CitaAntecedentes ;
   private String[] BC000A19_A91CitaLink ;
   private boolean[] BC000A19_n91CitaLink ;
   private java.util.Date[] BC000A19_A92CitaFechaReserva ;
   private boolean[] BC000A19_n92CitaFechaReserva ;
   private String[] BC000A19_A93CitaLog ;
   private boolean[] BC000A19_n93CitaLog ;
   private String[] BC000A19_A94CitaEmailGenLink ;
   private boolean[] BC000A19_n94CitaEmailGenLink ;
   private String[] BC000A19_A95CitaEstado ;
   private boolean[] BC000A19_n95CitaEstado ;
   private String[] BC000A19_A99CitaMotivoConsulta ;
   private boolean[] BC000A19_n99CitaMotivoConsulta ;
   private String[] BC000A19_A96CitaArchivoNombre ;
   private boolean[] BC000A19_n96CitaArchivoNombre ;
   private String[] BC000A19_A98CitaArchivo ;
   private boolean[] BC000A19_n98CitaArchivo ;
   private String[] BC000A19_A333CitaArchivoExtencion ;
   private boolean[] BC000A19_n333CitaArchivoExtencion ;
   private boolean[] BC000A19_A97CitaConsentimiento ;
   private boolean[] BC000A19_n97CitaConsentimiento ;
   private boolean[] BC000A19_A101CitaGestante ;
   private boolean[] BC000A19_n101CitaGestante ;
   private String[] BC000A19_A102CitaEstadoPago ;
   private boolean[] BC000A19_n102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A19_A306CitaPeso ;
   private boolean[] BC000A19_n306CitaPeso ;
   private java.math.BigDecimal[] BC000A19_A307CitaEstatura ;
   private boolean[] BC000A19_n307CitaEstatura ;
   private int[] BC000A19_A20PacienteId ;
   private int[] BC000A19_A21SGCitaDisponibilidadId ;
   private int[] BC000A20_A19CitaId ;
   private boolean[] BC000A20_n19CitaId ;
   private String[] BC000A24_A103PacienteApellidoPaterno ;
   private String[] BC000A24_A104PacienteApellidoMaterno ;
   private String[] BC000A24_A105PacienteNombres ;
   private String[] BC000A24_A106PacienteNroDocumento ;
   private java.util.Date[] BC000A25_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000A25_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] BC000A25_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] BC000A25_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] BC000A25_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] BC000A25_n387SGCitaDisponibilidadHoraFin ;
   private int[] BC000A25_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000A25_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000A25_A72SGCitaDisponibilidadSedeId ;
   private String[] BC000A26_A87SGCitaDisponibilidadProCOP ;
   private String[] BC000A26_A84ProfesionalNombres ;
   private boolean[] BC000A26_n84ProfesionalNombres ;
   private String[] BC000A26_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000A26_n85ProfesionalApellidoPaterno ;
   private String[] BC000A26_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000A26_n86ProfesionalApellidoMaterno ;
   private String[] BC000A27_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] BC000A28_A73SGCitaDisponibilidadSedeNombre ;
   private short[] BC000A28_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000A29_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] BC000A30_A50RecetaMedicaId ;
   private int[] BC000A31_A47PagoId ;
   private short[] BC000A32_A37EncuestaId ;
   private int[] BC000A33_A26CitaServicioId ;
   private int[] BC000A34_A24CitaRecetaId ;
   private int[] BC000A35_A22CitaDiagnosticoId ;
   private int[] BC000A36_A19CitaId ;
   private boolean[] BC000A36_n19CitaId ;
   private String[] BC000A36_A64CitaCode ;
   private String[] BC000A36_A103PacienteApellidoPaterno ;
   private String[] BC000A36_A104PacienteApellidoMaterno ;
   private String[] BC000A36_A105PacienteNombres ;
   private String[] BC000A36_A106PacienteNroDocumento ;
   private String[] BC000A36_A65CitaTipoDiagnostico ;
   private boolean[] BC000A36_n65CitaTipoDiagnostico ;
   private java.util.Date[] BC000A36_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000A36_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] BC000A36_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] BC000A36_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] BC000A36_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] BC000A36_n387SGCitaDisponibilidadHoraFin ;
   private String[] BC000A36_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] BC000A36_A73SGCitaDisponibilidadSedeNombre ;
   private String[] BC000A36_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000A36_A87SGCitaDisponibilidadProCOP ;
   private String[] BC000A36_A89CitaEstadoCita ;
   private boolean[] BC000A36_n89CitaEstadoCita ;
   private String[] BC000A36_A90CitaInforme ;
   private boolean[] BC000A36_n90CitaInforme ;
   private String[] BC000A36_A100CitaAntecedentes ;
   private boolean[] BC000A36_n100CitaAntecedentes ;
   private String[] BC000A36_A91CitaLink ;
   private boolean[] BC000A36_n91CitaLink ;
   private java.util.Date[] BC000A36_A92CitaFechaReserva ;
   private boolean[] BC000A36_n92CitaFechaReserva ;
   private String[] BC000A36_A93CitaLog ;
   private boolean[] BC000A36_n93CitaLog ;
   private String[] BC000A36_A94CitaEmailGenLink ;
   private boolean[] BC000A36_n94CitaEmailGenLink ;
   private String[] BC000A36_A95CitaEstado ;
   private boolean[] BC000A36_n95CitaEstado ;
   private String[] BC000A36_A99CitaMotivoConsulta ;
   private boolean[] BC000A36_n99CitaMotivoConsulta ;
   private String[] BC000A36_A96CitaArchivoNombre ;
   private boolean[] BC000A36_n96CitaArchivoNombre ;
   private String[] BC000A36_A98CitaArchivo ;
   private boolean[] BC000A36_n98CitaArchivo ;
   private String[] BC000A36_A333CitaArchivoExtencion ;
   private boolean[] BC000A36_n333CitaArchivoExtencion ;
   private boolean[] BC000A36_A97CitaConsentimiento ;
   private boolean[] BC000A36_n97CitaConsentimiento ;
   private boolean[] BC000A36_A101CitaGestante ;
   private boolean[] BC000A36_n101CitaGestante ;
   private String[] BC000A36_A102CitaEstadoPago ;
   private boolean[] BC000A36_n102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A36_A306CitaPeso ;
   private boolean[] BC000A36_n306CitaPeso ;
   private java.math.BigDecimal[] BC000A36_A307CitaEstatura ;
   private boolean[] BC000A36_n307CitaEstatura ;
   private String[] BC000A36_A84ProfesionalNombres ;
   private boolean[] BC000A36_n84ProfesionalNombres ;
   private String[] BC000A36_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000A36_n85ProfesionalApellidoPaterno ;
   private String[] BC000A36_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000A36_n86ProfesionalApellidoMaterno ;
   private int[] BC000A36_A20PacienteId ;
   private int[] BC000A36_A21SGCitaDisponibilidadId ;
   private int[] BC000A36_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000A36_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000A36_A72SGCitaDisponibilidadSedeId ;
   private short[] BC000A36_A76SGCitaDisponibilidadClinicaId ;
   private int[] BC000A2_A19CitaId ;
   private String[] BC000A2_A64CitaCode ;
   private String[] BC000A2_A65CitaTipoDiagnostico ;
   private String[] BC000A2_A89CitaEstadoCita ;
   private String[] BC000A2_A90CitaInforme ;
   private String[] BC000A2_A100CitaAntecedentes ;
   private String[] BC000A2_A91CitaLink ;
   private java.util.Date[] BC000A2_A92CitaFechaReserva ;
   private String[] BC000A2_A93CitaLog ;
   private String[] BC000A2_A94CitaEmailGenLink ;
   private String[] BC000A2_A95CitaEstado ;
   private String[] BC000A2_A99CitaMotivoConsulta ;
   private String[] BC000A2_A96CitaArchivoNombre ;
   private String[] BC000A2_A98CitaArchivo ;
   private String[] BC000A2_A333CitaArchivoExtencion ;
   private boolean[] BC000A2_A97CitaConsentimiento ;
   private boolean[] BC000A2_A101CitaGestante ;
   private String[] BC000A2_A102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A2_A306CitaPeso ;
   private java.math.BigDecimal[] BC000A2_A307CitaEstatura ;
   private int[] BC000A2_A20PacienteId ;
   private int[] BC000A2_A21SGCitaDisponibilidadId ;
   private int[] BC000A3_A19CitaId ;
   private String[] BC000A3_A64CitaCode ;
   private String[] BC000A3_A65CitaTipoDiagnostico ;
   private String[] BC000A3_A89CitaEstadoCita ;
   private String[] BC000A3_A90CitaInforme ;
   private String[] BC000A3_A100CitaAntecedentes ;
   private String[] BC000A3_A91CitaLink ;
   private java.util.Date[] BC000A3_A92CitaFechaReserva ;
   private String[] BC000A3_A93CitaLog ;
   private String[] BC000A3_A94CitaEmailGenLink ;
   private String[] BC000A3_A95CitaEstado ;
   private String[] BC000A3_A99CitaMotivoConsulta ;
   private String[] BC000A3_A96CitaArchivoNombre ;
   private String[] BC000A3_A98CitaArchivo ;
   private String[] BC000A3_A333CitaArchivoExtencion ;
   private boolean[] BC000A3_A97CitaConsentimiento ;
   private boolean[] BC000A3_A101CitaGestante ;
   private String[] BC000A3_A102CitaEstadoPago ;
   private java.math.BigDecimal[] BC000A3_A306CitaPeso ;
   private java.math.BigDecimal[] BC000A3_A307CitaEstatura ;
   private int[] BC000A3_A20PacienteId ;
   private int[] BC000A3_A21SGCitaDisponibilidadId ;
   private String[] BC000A4_A103PacienteApellidoPaterno ;
   private String[] BC000A4_A104PacienteApellidoMaterno ;
   private String[] BC000A4_A105PacienteNombres ;
   private String[] BC000A4_A106PacienteNroDocumento ;
   private java.util.Date[] BC000A5_A66SGCitaDisponibilidadFecha ;
   private java.util.Date[] BC000A5_A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] BC000A5_A387SGCitaDisponibilidadHoraFin ;
   private int[] BC000A5_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000A5_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000A5_A72SGCitaDisponibilidadSedeId ;
   private String[] BC000A6_A87SGCitaDisponibilidadProCOP ;
   private String[] BC000A6_A84ProfesionalNombres ;
   private String[] BC000A6_A85ProfesionalApellidoPaterno ;
   private String[] BC000A6_A86ProfesionalApellidoMaterno ;
   private String[] BC000A7_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] BC000A8_A73SGCitaDisponibilidadSedeNombre ;
   private short[] BC000A8_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000A9_A78SGCitaDisponibilidadClinicaNombre ;
   private boolean[] BC000A2_n65CitaTipoDiagnostico ;
   private boolean[] BC000A2_n89CitaEstadoCita ;
   private boolean[] BC000A2_n90CitaInforme ;
   private boolean[] BC000A2_n100CitaAntecedentes ;
   private boolean[] BC000A2_n91CitaLink ;
   private boolean[] BC000A2_n92CitaFechaReserva ;
   private boolean[] BC000A2_n93CitaLog ;
   private boolean[] BC000A2_n94CitaEmailGenLink ;
   private boolean[] BC000A2_n95CitaEstado ;
   private boolean[] BC000A2_n99CitaMotivoConsulta ;
   private boolean[] BC000A2_n96CitaArchivoNombre ;
   private boolean[] BC000A2_n98CitaArchivo ;
   private boolean[] BC000A2_n333CitaArchivoExtencion ;
   private boolean[] BC000A2_n97CitaConsentimiento ;
   private boolean[] BC000A2_n101CitaGestante ;
   private boolean[] BC000A2_n102CitaEstadoPago ;
   private boolean[] BC000A2_n306CitaPeso ;
   private boolean[] BC000A2_n307CitaEstatura ;
   private boolean[] BC000A3_n65CitaTipoDiagnostico ;
   private boolean[] BC000A3_n89CitaEstadoCita ;
   private boolean[] BC000A3_n90CitaInforme ;
   private boolean[] BC000A3_n100CitaAntecedentes ;
   private boolean[] BC000A3_n91CitaLink ;
   private boolean[] BC000A3_n92CitaFechaReserva ;
   private boolean[] BC000A3_n93CitaLog ;
   private boolean[] BC000A3_n94CitaEmailGenLink ;
   private boolean[] BC000A3_n95CitaEstado ;
   private boolean[] BC000A3_n99CitaMotivoConsulta ;
   private boolean[] BC000A3_n96CitaArchivoNombre ;
   private boolean[] BC000A3_n98CitaArchivo ;
   private boolean[] BC000A3_n333CitaArchivoExtencion ;
   private boolean[] BC000A3_n97CitaConsentimiento ;
   private boolean[] BC000A3_n101CitaGestante ;
   private boolean[] BC000A3_n102CitaEstadoPago ;
   private boolean[] BC000A3_n306CitaPeso ;
   private boolean[] BC000A3_n307CitaEstatura ;
   private boolean[] BC000A5_n66SGCitaDisponibilidadFecha ;
   private boolean[] BC000A5_n68SGCitaDisponibilidadHoraInicio ;
   private boolean[] BC000A5_n387SGCitaDisponibilidadHoraFin ;
   private boolean[] BC000A6_n84ProfesionalNombres ;
   private boolean[] BC000A6_n85ProfesionalApellidoPaterno ;
   private boolean[] BC000A6_n86ProfesionalApellidoMaterno ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class cita_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000A2", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WITH (UPDLOCK) WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A3", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A4", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A5", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A6", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A7", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A8", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A9", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A10", "SELECT TM1.[CitaId], TM1.[CitaCode], T2.[PacienteApellidoPaterno], T2.[PacienteApellidoMaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], TM1.[CitaTipoDiagnostico], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T5.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T6.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T7.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, TM1.[CitaEstadoCita], TM1.[CitaInforme], TM1.[CitaAntecedentes], TM1.[CitaLink], TM1.[CitaFechaReserva], TM1.[CitaLog], TM1.[CitaEmailGenLink], TM1.[CitaEstado], TM1.[CitaMotivoConsulta], TM1.[CitaArchivoNombre], TM1.[CitaArchivo], TM1.[CitaArchivoExtencion], TM1.[CitaConsentimiento], TM1.[CitaGestante], TM1.[CitaEstadoPago], TM1.[CitaPeso], TM1.[CitaEstatura], T4.[ProfesionalNombres], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalApellidoMaterno], TM1.[PacienteId], TM1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T6.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM (((((([Cita] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = TM1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Especialidad] T5 ON T5.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T6 ON T6.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T7 ON T7.[ClinicaId] = T6.[ClinicaId]) WHERE TM1.[CitaId] = ? ORDER BY TM1.[CitaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A11", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A12", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A13", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A14", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A15", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A16", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A17", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A18", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A19", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WITH (UPDLOCK) WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A20", "INSERT INTO [Cita]([CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000A21", "UPDATE [Cita] SET [CitaCode]=?, [CitaTipoDiagnostico]=?, [CitaEstadoCita]=?, [CitaInforme]=?, [CitaAntecedentes]=?, [CitaLink]=?, [CitaFechaReserva]=?, [CitaLog]=?, [CitaEmailGenLink]=?, [CitaEstado]=?, [CitaMotivoConsulta]=?, [CitaArchivoNombre]=?, [CitaArchivoExtencion]=?, [CitaConsentimiento]=?, [CitaGestante]=?, [CitaEstadoPago]=?, [CitaPeso]=?, [CitaEstatura]=?, [PacienteId]=?, [SGCitaDisponibilidadId]=?  WHERE [CitaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000A22", "UPDATE [Cita] SET [CitaArchivo]=?  WHERE [CitaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000A23", "DELETE FROM [Cita]  WHERE [CitaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000A24", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A25", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A26", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A27", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A28", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A29", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000A30", "SELECT TOP 1 [RecetaMedicaId] FROM [RecetaMedica] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A31", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A32", "SELECT TOP 1 [EncuestaId] FROM [Encuesta] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A33", "SELECT TOP 1 [CitaServicioId] FROM [CitaServicio] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A34", "SELECT TOP 1 [CitaRecetaId] FROM [CitaReceta] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A35", "SELECT TOP 1 [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000A36", "SELECT TM1.[CitaId], TM1.[CitaCode], T2.[PacienteApellidoPaterno], T2.[PacienteApellidoMaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], TM1.[CitaTipoDiagnostico], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T5.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T6.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T7.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, TM1.[CitaEstadoCita], TM1.[CitaInforme], TM1.[CitaAntecedentes], TM1.[CitaLink], TM1.[CitaFechaReserva], TM1.[CitaLog], TM1.[CitaEmailGenLink], TM1.[CitaEstado], TM1.[CitaMotivoConsulta], TM1.[CitaArchivoNombre], TM1.[CitaArchivo], TM1.[CitaArchivoExtencion], TM1.[CitaConsentimiento], TM1.[CitaGestante], TM1.[CitaEstadoPago], TM1.[CitaPeso], TM1.[CitaEstatura], T4.[ProfesionalNombres], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalApellidoMaterno], TM1.[PacienteId], TM1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T6.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM (((((([Cita] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = TM1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Especialidad] T5 ON T5.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T6 ON T6.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T7 ON T7.[ClinicaId] = T6.[ClinicaId]) WHERE TM1.[CitaId] = ? ORDER BY TM1.[CitaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(22, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getLongVarchar(23);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getBLOBFile(25, "tmp", "");
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((boolean[]) buf[42])[0] = rslt.getBoolean(27);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((boolean[]) buf[44])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(29, 1);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(30,2);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[50])[0] = rslt.getBigDecimal(31,2);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((int[]) buf[58])[0] = rslt.getInt(35);
               ((int[]) buf[59])[0] = rslt.getInt(36);
               ((int[]) buf[60])[0] = rslt.getInt(37);
               ((short[]) buf[61])[0] = rslt.getShort(38);
               ((short[]) buf[62])[0] = rslt.getShort(39);
               ((short[]) buf[63])[0] = rslt.getShort(40);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 10 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 23 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(22, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getLongVarchar(23);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getBLOBFile(25, "tmp", "");
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((boolean[]) buf[42])[0] = rslt.getBoolean(27);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((boolean[]) buf[44])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(29, 1);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(30,2);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[50])[0] = rslt.getBigDecimal(31,2);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((int[]) buf[58])[0] = rslt.getInt(35);
               ((int[]) buf[59])[0] = rslt.getInt(36);
               ((int[]) buf[60])[0] = rslt.getInt(37);
               ((short[]) buf[61])[0] = rslt.getShort(38);
               ((short[]) buf[62])[0] = rslt.getShort(39);
               ((short[]) buf[63])[0] = rslt.getShort(40);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 1);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[6]);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[10], 1000);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[12], false);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[14], 2000);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[16], 100);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[18], 1);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(11, (String)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[22], 100);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(13, (String)parms[24]);
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[26], 30);
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[28]).booleanValue());
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(16, ((Boolean) parms[30]).booleanValue());
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(17, (String)parms[32], 1);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(19, (java.math.BigDecimal)parms[36], 2);
               }
               stmt.setInt(20, ((Number) parms[37]).intValue());
               stmt.setInt(21, ((Number) parms[38]).intValue());
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 1);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[6]);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[10], 1000);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[12], false);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[14], 2000);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[16], 100);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[18], 1);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(11, (String)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[22], 100);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(13, (String)parms[24], 30);
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(14, ((Boolean) parms[26]).booleanValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[28]).booleanValue());
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[30], 1);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(17, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[34], 2);
               }
               stmt.setInt(19, ((Number) parms[35]).intValue());
               stmt.setInt(20, ((Number) parms[36]).intValue());
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[38]).intValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 33 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 34 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

