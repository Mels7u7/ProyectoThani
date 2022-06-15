package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class citawwexport extends GXProcedure
{
   public citawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citawwexport.class ), "" );
   }

   public citawwexport( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      citawwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      citawwexport.this.aP0 = aP0;
      citawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean2) ;
      citawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV101Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "CitaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Filter") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFCitaId) && (0==AV36TFCitaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFCitaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFCitaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFCitaCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFCitaCode_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFCitaCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFCitaCode, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV39TFPacienteId) && (0==AV40TFPacienteId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFPacienteId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFPacienteId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV42TFPacienteApellidoPaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Paterno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPacienteApellidoPaterno_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFPacienteApellidoPaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Paterno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFPacienteApellidoPaterno, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV44TFPacienteApellidoMaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Materno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFPacienteApellidoMaterno_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFPacienteApellidoMaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Materno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFPacienteApellidoMaterno, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFPacienteNombres_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nombres") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFPacienteNombres_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFPacienteNombres)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nombres") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFPacienteNombres, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFPacienteNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFPacienteNroDocumento_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFPacienteNroDocumento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFPacienteNroDocumento, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV96TFCitaTipoDiagnostico_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Diagnostico") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV86i = 1 ;
         AV102GXV1 = 1 ;
         while ( AV102GXV1 <= AV96TFCitaTipoDiagnostico_Sels.size() )
         {
            AV56TFCitaTipoDiagnostico_Sel = (String)AV96TFCitaTipoDiagnostico_Sels.elementAt(-1+AV102GXV1) ;
            if ( AV86i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodiagnostico.getDescription(httpContext,(String)AV56TFCitaTipoDiagnostico_Sel) );
            AV86i = (long)(AV86i+1) ;
            AV102GXV1 = (int)(AV102GXV1+1) ;
         }
      }
      if ( ! ( (0==AV57TFSGCitaDisponibilidadId) && (0==AV58TFSGCitaDisponibilidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Disponibilidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV57TFSGCitaDisponibilidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV58TFSGCitaDisponibilidadId_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV59TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60TFSGCitaDisponibilidadFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Disponibilidad Fecha") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV59TFSGCitaDisponibilidadFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV60TFSGCitaDisponibilidadFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV61TFSGCitaDisponibilidadHoraInicio) && GXutil.dateCompare(GXutil.nullDate(), AV62TFSGCitaDisponibilidadHoraInicio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Hora Inicio") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( AV61TFSGCitaDisponibilidadHoraInicio, "99:99") );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( localUtil.format( AV62TFSGCitaDisponibilidadHoraInicio_To, "99:99") );
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV97TFSGCitaDisponibilidadHoraFin) && GXutil.dateCompare(GXutil.nullDate(), AV98TFSGCitaDisponibilidadHoraFin_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Hora Fin") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( AV97TFSGCitaDisponibilidadHoraFin, "99:99") );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( localUtil.format( AV98TFSGCitaDisponibilidadHoraFin_To, "99:99") );
      }
      if ( ! ( (0==AV63TFSGCitaDisponibilidadEspecialidadId) && (0==AV64TFSGCitaDisponibilidadEspecialidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV63TFSGCitaDisponibilidadEspecialidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV64TFSGCitaDisponibilidadEspecialidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV65TFSGCitaDisponibilidadEspecialidadNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especialidad Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV65TFSGCitaDisponibilidadEspecialidadNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV67TFSGCitaDisponibilidadSedeId) && (0==AV68TFSGCitaDisponibilidadSedeId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sede Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV67TFSGCitaDisponibilidadSedeId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV68TFSGCitaDisponibilidadSedeId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV87TFSGCitaDisponibilidadSedeNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sede Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV87TFSGCitaDisponibilidadSedeNombre_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV69TFSGCitaDisponibilidadSedeNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sede Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV69TFSGCitaDisponibilidadSedeNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV71TFSGCitaDisponibilidadClinicaId) && (0==AV72TFSGCitaDisponibilidadClinicaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Clinica Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV71TFSGCitaDisponibilidadClinicaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV72TFSGCitaDisponibilidadClinicaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV88TFSGCitaDisponibilidadClinicaNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Clinica Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV88TFSGCitaDisponibilidadClinicaNombre_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV73TFSGCitaDisponibilidadClinicaNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Clinica Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV73TFSGCitaDisponibilidadClinicaNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV75TFSGCitaDisponibilidadProfesionalId) && (0==AV76TFSGCitaDisponibilidadProfesionalId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Profesional Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV75TFSGCitaDisponibilidadProfesionalId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV76TFSGCitaDisponibilidadProfesionalId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV78TFSGCitaDisponibilidadProFullName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Full Name") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV78TFSGCitaDisponibilidadProFullName_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV77TFSGCitaDisponibilidadProFullName)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Full Name") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV77TFSGCitaDisponibilidadProFullName, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV80TFSGCitaDisponibilidadProCOP_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pro COP") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV80TFSGCitaDisponibilidadProCOP_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV79TFSGCitaDisponibilidadProCOP)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pro COP") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV79TFSGCitaDisponibilidadProCOP, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV82TFCitaEstadoCita_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado Cita") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV86i = 1 ;
         AV103GXV2 = 1 ;
         while ( AV103GXV2 <= AV82TFCitaEstadoCita_Sels.size() )
         {
            AV83TFCitaEstadoCita_Sel = (String)AV82TFCitaEstadoCita_Sels.elementAt(-1+AV103GXV2) ;
            if ( AV86i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestadocita.getDescription(httpContext,(String)AV83TFCitaEstadoCita_Sel) );
            AV86i = (long)(AV86i+1) ;
            AV103GXV2 = (int)(AV103GXV2+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV85TFCitaInforme_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Informe") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV85TFCitaInforme_Sel, 1, 1000), GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV84TFCitaInforme)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Informe") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV84TFCitaInforme, 1, 1000), GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV90TFCitaAntecedentes_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Antecedentes") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV90TFCitaAntecedentes_Sel, 1, 1000), GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV89TFCitaAntecedentes)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Antecedentes") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV89TFCitaAntecedentes, 1, 1000), GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV92TFCitaLink_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Link") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         citawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV92TFCitaLink_Sel, GXv_char7) ;
         citawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV91TFCitaLink)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Link") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            citawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV91TFCitaLink, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("CitaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("CitaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV104GXV3 = 1 ;
      while ( AV104GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV104GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV104GXV3 = (int)(AV104GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV106Citawwds_1_filterfulltext = AV19FilterFullText ;
      AV107Citawwds_2_tfcitaid = AV35TFCitaId ;
      AV108Citawwds_3_tfcitaid_to = AV36TFCitaId_To ;
      AV109Citawwds_4_tfcitacode = AV37TFCitaCode ;
      AV110Citawwds_5_tfcitacode_sel = AV38TFCitaCode_Sel ;
      AV111Citawwds_6_tfpacienteid = AV39TFPacienteId ;
      AV112Citawwds_7_tfpacienteid_to = AV40TFPacienteId_To ;
      AV113Citawwds_8_tfpacienteapellidopaterno = AV41TFPacienteApellidoPaterno ;
      AV114Citawwds_9_tfpacienteapellidopaterno_sel = AV42TFPacienteApellidoPaterno_Sel ;
      AV115Citawwds_10_tfpacienteapellidomaterno = AV43TFPacienteApellidoMaterno ;
      AV116Citawwds_11_tfpacienteapellidomaterno_sel = AV44TFPacienteApellidoMaterno_Sel ;
      AV117Citawwds_12_tfpacientenombres = AV45TFPacienteNombres ;
      AV118Citawwds_13_tfpacientenombres_sel = AV46TFPacienteNombres_Sel ;
      AV119Citawwds_14_tfpacientenrodocumento = AV47TFPacienteNroDocumento ;
      AV120Citawwds_15_tfpacientenrodocumento_sel = AV48TFPacienteNroDocumento_Sel ;
      AV121Citawwds_16_tfcitatipodiagnostico_sels = AV96TFCitaTipoDiagnostico_Sels ;
      AV122Citawwds_17_tfsgcitadisponibilidadid = AV57TFSGCitaDisponibilidadId ;
      AV123Citawwds_18_tfsgcitadisponibilidadid_to = AV58TFSGCitaDisponibilidadId_To ;
      AV124Citawwds_19_tfsgcitadisponibilidadfecha = AV59TFSGCitaDisponibilidadFecha ;
      AV125Citawwds_20_tfsgcitadisponibilidadfecha_to = AV60TFSGCitaDisponibilidadFecha_To ;
      AV126Citawwds_21_tfsgcitadisponibilidadhorainicio = AV61TFSGCitaDisponibilidadHoraInicio ;
      AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to = AV62TFSGCitaDisponibilidadHoraInicio_To ;
      AV128Citawwds_23_tfsgcitadisponibilidadhorafin = AV97TFSGCitaDisponibilidadHoraFin ;
      AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to = AV98TFSGCitaDisponibilidadHoraFin_To ;
      AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid = AV63TFSGCitaDisponibilidadEspecialidadId ;
      AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to = AV64TFSGCitaDisponibilidadEspecialidadId_To ;
      AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = AV65TFSGCitaDisponibilidadEspecialidadNombre ;
      AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV134Citawwds_29_tfsgcitadisponibilidadsedeid = AV67TFSGCitaDisponibilidadSedeId ;
      AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to = AV68TFSGCitaDisponibilidadSedeId_To ;
      AV136Citawwds_31_tfsgcitadisponibilidadsedenombre = AV69TFSGCitaDisponibilidadSedeNombre ;
      AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = AV87TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV138Citawwds_33_tfsgcitadisponibilidadclinicaid = AV71TFSGCitaDisponibilidadClinicaId ;
      AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to = AV72TFSGCitaDisponibilidadClinicaId_To ;
      AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre = AV73TFSGCitaDisponibilidadClinicaNombre ;
      AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = AV88TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid = AV75TFSGCitaDisponibilidadProfesionalId ;
      AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to = AV76TFSGCitaDisponibilidadProfesionalId_To ;
      AV144Citawwds_39_tfsgcitadisponibilidadprofullname = AV77TFSGCitaDisponibilidadProFullName ;
      AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel = AV78TFSGCitaDisponibilidadProFullName_Sel ;
      AV146Citawwds_41_tfsgcitadisponibilidadprocop = AV79TFSGCitaDisponibilidadProCOP ;
      AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel = AV80TFSGCitaDisponibilidadProCOP_Sel ;
      AV148Citawwds_43_tfcitaestadocita_sels = AV82TFCitaEstadoCita_Sels ;
      AV149Citawwds_44_tfcitainforme = AV84TFCitaInforme ;
      AV150Citawwds_45_tfcitainforme_sel = AV85TFCitaInforme_Sel ;
      AV151Citawwds_46_tfcitaantecedentes = AV89TFCitaAntecedentes ;
      AV152Citawwds_47_tfcitaantecedentes_sel = AV90TFCitaAntecedentes_Sel ;
      AV153Citawwds_48_tfcitalink = AV91TFCitaLink ;
      AV154Citawwds_49_tfcitalink_sel = AV92TFCitaLink_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A65CitaTipoDiagnostico ,
                                           AV121Citawwds_16_tfcitatipodiagnostico_sels ,
                                           A89CitaEstadoCita ,
                                           AV148Citawwds_43_tfcitaestadocita_sels ,
                                           AV106Citawwds_1_filterfulltext ,
                                           Integer.valueOf(AV107Citawwds_2_tfcitaid) ,
                                           Integer.valueOf(AV108Citawwds_3_tfcitaid_to) ,
                                           AV110Citawwds_5_tfcitacode_sel ,
                                           AV109Citawwds_4_tfcitacode ,
                                           Integer.valueOf(AV111Citawwds_6_tfpacienteid) ,
                                           Integer.valueOf(AV112Citawwds_7_tfpacienteid_to) ,
                                           AV114Citawwds_9_tfpacienteapellidopaterno_sel ,
                                           AV113Citawwds_8_tfpacienteapellidopaterno ,
                                           AV116Citawwds_11_tfpacienteapellidomaterno_sel ,
                                           AV115Citawwds_10_tfpacienteapellidomaterno ,
                                           AV118Citawwds_13_tfpacientenombres_sel ,
                                           AV117Citawwds_12_tfpacientenombres ,
                                           AV120Citawwds_15_tfpacientenrodocumento_sel ,
                                           AV119Citawwds_14_tfpacientenrodocumento ,
                                           Integer.valueOf(AV121Citawwds_16_tfcitatipodiagnostico_sels.size()) ,
                                           Integer.valueOf(AV122Citawwds_17_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV123Citawwds_18_tfsgcitadisponibilidadid_to) ,
                                           AV124Citawwds_19_tfsgcitadisponibilidadfecha ,
                                           AV125Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                           AV126Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                           AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                           AV128Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                           AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                           Short.valueOf(AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                           Short.valueOf(AV134Citawwds_29_tfsgcitadisponibilidadsedeid) ,
                                           Short.valueOf(AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to) ,
                                           AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV136Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                           Short.valueOf(AV138Citawwds_33_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                           AV144Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                           AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                           AV146Citawwds_41_tfsgcitadisponibilidadprocop ,
                                           Integer.valueOf(AV148Citawwds_43_tfcitaestadocita_sels.size()) ,
                                           AV150Citawwds_45_tfcitainforme_sel ,
                                           AV149Citawwds_44_tfcitainforme ,
                                           AV152Citawwds_47_tfcitaantecedentes_sel ,
                                           AV151Citawwds_46_tfcitaantecedentes ,
                                           AV154Citawwds_49_tfcitalink_sel ,
                                           AV153Citawwds_48_tfcitalink ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Short.valueOf(A72SGCitaDisponibilidadSedeId) ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A87SGCitaDisponibilidadProCOP ,
                                           A90CitaInforme ,
                                           A100CitaAntecedentes ,
                                           A91CitaLink ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV106Citawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV106Citawwds_1_filterfulltext), "%", "") ;
      lV109Citawwds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV109Citawwds_4_tfcitacode), "%", "") ;
      lV113Citawwds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV113Citawwds_8_tfpacienteapellidopaterno), "%", "") ;
      lV115Citawwds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV115Citawwds_10_tfpacienteapellidomaterno), "%", "") ;
      lV117Citawwds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV117Citawwds_12_tfpacientenombres), "%", "") ;
      lV119Citawwds_14_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV119Citawwds_14_tfpacientenrodocumento), "%", "") ;
      lV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV136Citawwds_31_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV136Citawwds_31_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV140Citawwds_35_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV144Citawwds_39_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV144Citawwds_39_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV146Citawwds_41_tfsgcitadisponibilidadprocop = GXutil.concat( GXutil.rtrim( AV146Citawwds_41_tfsgcitadisponibilidadprocop), "%", "") ;
      lV149Citawwds_44_tfcitainforme = GXutil.concat( GXutil.rtrim( AV149Citawwds_44_tfcitainforme), "%", "") ;
      lV151Citawwds_46_tfcitaantecedentes = GXutil.concat( GXutil.rtrim( AV151Citawwds_46_tfcitaantecedentes), "%", "") ;
      lV153Citawwds_48_tfcitalink = GXutil.concat( GXutil.rtrim( AV153Citawwds_48_tfcitalink), "%", "") ;
      /* Using cursor P00412 */
      pr_default.execute(0, new Object[] {lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, lV106Citawwds_1_filterfulltext, Integer.valueOf(AV107Citawwds_2_tfcitaid), Integer.valueOf(AV108Citawwds_3_tfcitaid_to), lV109Citawwds_4_tfcitacode, AV110Citawwds_5_tfcitacode_sel, Integer.valueOf(AV111Citawwds_6_tfpacienteid), Integer.valueOf(AV112Citawwds_7_tfpacienteid_to), lV113Citawwds_8_tfpacienteapellidopaterno, AV114Citawwds_9_tfpacienteapellidopaterno_sel, lV115Citawwds_10_tfpacienteapellidomaterno, AV116Citawwds_11_tfpacienteapellidomaterno_sel, lV117Citawwds_12_tfpacientenombres, AV118Citawwds_13_tfpacientenombres_sel, lV119Citawwds_14_tfpacientenrodocumento, AV120Citawwds_15_tfpacientenrodocumento_sel, Integer.valueOf(AV122Citawwds_17_tfsgcitadisponibilidadid), Integer.valueOf(AV123Citawwds_18_tfsgcitadisponibilidadid_to), AV124Citawwds_19_tfsgcitadisponibilidadfecha, AV125Citawwds_20_tfsgcitadisponibilidadfecha_to, AV126Citawwds_21_tfsgcitadisponibilidadhorainicio, AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to, AV128Citawwds_23_tfsgcitadisponibilidadhorafin, AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to, Short.valueOf(AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to), lV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre, AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel, Short.valueOf(AV134Citawwds_29_tfsgcitadisponibilidadsedeid), Short.valueOf(AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to), lV136Citawwds_31_tfsgcitadisponibilidadsedenombre, AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel, Short.valueOf(AV138Citawwds_33_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to), lV140Citawwds_35_tfsgcitadisponibilidadclinicanombre, AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel, Integer.valueOf(AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to), lV144Citawwds_39_tfsgcitadisponibilidadprofullname, AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel, lV146Citawwds_41_tfsgcitadisponibilidadprocop, AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel, lV149Citawwds_44_tfcitainforme, AV150Citawwds_45_tfcitainforme_sel, lV151Citawwds_46_tfcitaantecedentes, AV152Citawwds_47_tfcitaantecedentes_sel, lV153Citawwds_48_tfcitalink, AV154Citawwds_49_tfcitalink_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A81SGCitaDisponibilidadProfesionalId = P00412_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00412_A76SGCitaDisponibilidadClinicaId[0] ;
         A72SGCitaDisponibilidadSedeId = P00412_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00412_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A387SGCitaDisponibilidadHoraFin = P00412_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P00412_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P00412_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P00412_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P00412_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00412_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00412_A21SGCitaDisponibilidadId[0] ;
         A20PacienteId = P00412_A20PacienteId[0] ;
         A19CitaId = P00412_A19CitaId[0] ;
         A91CitaLink = P00412_A91CitaLink[0] ;
         n91CitaLink = P00412_n91CitaLink[0] ;
         A100CitaAntecedentes = P00412_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = P00412_n100CitaAntecedentes[0] ;
         A90CitaInforme = P00412_A90CitaInforme[0] ;
         n90CitaInforme = P00412_n90CitaInforme[0] ;
         A89CitaEstadoCita = P00412_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P00412_n89CitaEstadoCita[0] ;
         A87SGCitaDisponibilidadProCOP = P00412_A87SGCitaDisponibilidadProCOP[0] ;
         A82SGCitaDisponibilidadProFullName = P00412_A82SGCitaDisponibilidadProFullName[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00412_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P00412_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00412_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A65CitaTipoDiagnostico = P00412_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = P00412_n65CitaTipoDiagnostico[0] ;
         A106PacienteNroDocumento = P00412_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P00412_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00412_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00412_A103PacienteApellidoPaterno[0] ;
         A64CitaCode = P00412_A64CitaCode[0] ;
         A84ProfesionalNombres = P00412_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00412_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00412_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00412_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00412_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00412_n86ProfesionalApellidoMaterno[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00412_A81SGCitaDisponibilidadProfesionalId[0] ;
         A72SGCitaDisponibilidadSedeId = P00412_A72SGCitaDisponibilidadSedeId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00412_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A387SGCitaDisponibilidadHoraFin = P00412_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P00412_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P00412_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P00412_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P00412_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00412_n66SGCitaDisponibilidadFecha[0] ;
         A87SGCitaDisponibilidadProCOP = P00412_A87SGCitaDisponibilidadProCOP[0] ;
         A84ProfesionalNombres = P00412_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00412_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00412_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00412_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00412_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00412_n86ProfesionalApellidoMaterno[0] ;
         A76SGCitaDisponibilidadClinicaId = P00412_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P00412_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00412_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00412_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A106PacienteNroDocumento = P00412_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P00412_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00412_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00412_A103PacienteApellidoPaterno[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A19CitaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A64CitaCode, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A20PacienteId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A103PacienteApellidoPaterno, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A104PacienteApellidoMaterno, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A105PacienteNombres, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A106PacienteNroDocumento, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodiagnostico.getDescription(httpContext,(String)A65CitaTipoDiagnostico) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A21SGCitaDisponibilidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A66SGCitaDisponibilidadFecha );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99") );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99") );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A70SGCitaDisponibilidadEspecialidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A146SGCitaDisponibilidadEspecialidadNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A72SGCitaDisponibilidadSedeId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A73SGCitaDisponibilidadSedeNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A76SGCitaDisponibilidadClinicaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A78SGCitaDisponibilidadClinicaNombre, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A81SGCitaDisponibilidadProfesionalId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A82SGCitaDisponibilidadProFullName, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A87SGCitaDisponibilidadProCOP, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestadocita.getDescription(httpContext,(String)A89CitaEstadoCita) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A90CitaInforme, 1, 1000), GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A100CitaAntecedentes, 1, 1000), GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A91CitaLink, GXv_char7) ;
            citawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaCode", "", "Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteId", "", "Paciente Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoPaterno", "", "Paciente Apellido Paterno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoMaterno", "", "Paciente Apellido Materno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombres", "", "Paciente Nombres", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNroDocumento", "", "Paciente Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaTipoDiagnostico", "", "Tipo Diagnostico", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadId", "", "Disponibilidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "Disponibilidad Fecha", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadHoraInicio", "", "Hora Inicio", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadHoraFin", "", "Hora Fin", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadId", "", "Especialidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadNombre", "", "Especialidad Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadSedeId", "", "Sede Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadSedeNombre", "", "Sede Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaId", "", "Clinica Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaNombre", "", "Clinica Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProfesionalId", "", "Profesional Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProFullName", "", "Full Name", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProCOP", "", "Pro COP", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaEstadoCita", "", "Estado Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaInforme", "", "Informe", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaAntecedentes", "", "Antecedentes", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaLink", "", "Link", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "CitaWWColumnsSelector", GXv_char7) ;
      citawwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("CitaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CitaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("CitaWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV155GXV4 = 1 ;
      while ( AV155GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV155GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV35TFCitaId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFCitaId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV37TFCitaCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV38TFCitaCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV39TFPacienteId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFPacienteId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV41TFPacienteApellidoPaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV42TFPacienteApellidoPaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV43TFPacienteApellidoMaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV44TFPacienteApellidoMaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV45TFPacienteNombres = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV46TFPacienteNombres_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV47TFPacienteNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV48TFPacienteNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITATIPODIAGNOSTICO_SEL") == 0 )
         {
            AV95TFCitaTipoDiagnostico_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV96TFCitaTipoDiagnostico_Sels.fromJSonString(AV95TFCitaTipoDiagnostico_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV57TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV58TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV59TFSGCitaDisponibilidadFecha = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV60TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAINICIO") == 0 )
         {
            AV61TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV62TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAFIN") == 0 )
         {
            AV97TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV98TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV63TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV64TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV65TFSGCitaDisponibilidadEspecialidadNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDEID") == 0 )
         {
            AV67TFSGCitaDisponibilidadSedeId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV68TFSGCitaDisponibilidadSedeId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE") == 0 )
         {
            AV69TFSGCitaDisponibilidadSedeNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE_SEL") == 0 )
         {
            AV87TFSGCitaDisponibilidadSedeNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV71TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV72TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV73TFSGCitaDisponibilidadClinicaNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV88TFSGCitaDisponibilidadClinicaNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV75TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV76TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV77TFSGCitaDisponibilidadProFullName = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV78TFSGCitaDisponibilidadProFullName_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP") == 0 )
         {
            AV79TFSGCitaDisponibilidadProCOP = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROCOP_SEL") == 0 )
         {
            AV80TFSGCitaDisponibilidadProCOP_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOCITA_SEL") == 0 )
         {
            AV81TFCitaEstadoCita_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV82TFCitaEstadoCita_Sels.fromJSonString(AV81TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME") == 0 )
         {
            AV84TFCitaInforme = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAINFORME_SEL") == 0 )
         {
            AV85TFCitaInforme_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES") == 0 )
         {
            AV89TFCitaAntecedentes = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAANTECEDENTES_SEL") == 0 )
         {
            AV90TFCitaAntecedentes_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK") == 0 )
         {
            AV91TFCitaLink = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITALINK_SEL") == 0 )
         {
            AV92TFCitaLink_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV155GXV4 = (int)(AV155GXV4+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = citawwexport.this.AV12Filename;
      this.aP1[0] = citawwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV101Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFCitaCode_Sel = "" ;
      AV37TFCitaCode = "" ;
      AV42TFPacienteApellidoPaterno_Sel = "" ;
      AV41TFPacienteApellidoPaterno = "" ;
      AV44TFPacienteApellidoMaterno_Sel = "" ;
      AV43TFPacienteApellidoMaterno = "" ;
      AV46TFPacienteNombres_Sel = "" ;
      AV45TFPacienteNombres = "" ;
      AV48TFPacienteNroDocumento_Sel = "" ;
      AV47TFPacienteNroDocumento = "" ;
      AV96TFCitaTipoDiagnostico_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFCitaTipoDiagnostico_Sel = "" ;
      AV59TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV60TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV61TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV62TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV97TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV98TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV65TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV87TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV69TFSGCitaDisponibilidadSedeNombre = "" ;
      AV88TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV73TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV78TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV77TFSGCitaDisponibilidadProFullName = "" ;
      AV80TFSGCitaDisponibilidadProCOP_Sel = "" ;
      AV79TFSGCitaDisponibilidadProCOP = "" ;
      AV82TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV83TFCitaEstadoCita_Sel = "" ;
      AV85TFCitaInforme_Sel = "" ;
      AV84TFCitaInforme = "" ;
      AV90TFCitaAntecedentes_Sel = "" ;
      AV89TFCitaAntecedentes = "" ;
      AV92TFCitaLink_Sel = "" ;
      AV91TFCitaLink = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
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
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A89CitaEstadoCita = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      AV106Citawwds_1_filterfulltext = "" ;
      AV109Citawwds_4_tfcitacode = "" ;
      AV110Citawwds_5_tfcitacode_sel = "" ;
      AV113Citawwds_8_tfpacienteapellidopaterno = "" ;
      AV114Citawwds_9_tfpacienteapellidopaterno_sel = "" ;
      AV115Citawwds_10_tfpacienteapellidomaterno = "" ;
      AV116Citawwds_11_tfpacienteapellidomaterno_sel = "" ;
      AV117Citawwds_12_tfpacientenombres = "" ;
      AV118Citawwds_13_tfpacientenombres_sel = "" ;
      AV119Citawwds_14_tfpacientenrodocumento = "" ;
      AV120Citawwds_15_tfpacientenrodocumento_sel = "" ;
      AV121Citawwds_16_tfcitatipodiagnostico_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV124Citawwds_19_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV125Citawwds_20_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV126Citawwds_21_tfsgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV128Citawwds_23_tfsgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV136Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel = "" ;
      AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV144Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV146Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel = "" ;
      AV148Citawwds_43_tfcitaestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV149Citawwds_44_tfcitainforme = "" ;
      AV150Citawwds_45_tfcitainforme_sel = "" ;
      AV151Citawwds_46_tfcitaantecedentes = "" ;
      AV152Citawwds_47_tfcitaantecedentes_sel = "" ;
      AV153Citawwds_48_tfcitalink = "" ;
      AV154Citawwds_49_tfcitalink_sel = "" ;
      scmdbuf = "" ;
      lV106Citawwds_1_filterfulltext = "" ;
      lV109Citawwds_4_tfcitacode = "" ;
      lV113Citawwds_8_tfpacienteapellidopaterno = "" ;
      lV115Citawwds_10_tfpacienteapellidomaterno = "" ;
      lV117Citawwds_12_tfpacientenombres = "" ;
      lV119Citawwds_14_tfpacientenrodocumento = "" ;
      lV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV136Citawwds_31_tfsgcitadisponibilidadsedenombre = "" ;
      lV140Citawwds_35_tfsgcitadisponibilidadclinicanombre = "" ;
      lV144Citawwds_39_tfsgcitadisponibilidadprofullname = "" ;
      lV146Citawwds_41_tfsgcitadisponibilidadprocop = "" ;
      lV149Citawwds_44_tfcitainforme = "" ;
      lV151Citawwds_46_tfcitaantecedentes = "" ;
      lV153Citawwds_48_tfcitalink = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      P00412_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00412_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00412_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00412_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00412_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00412_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P00412_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P00412_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P00412_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00412_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00412_A21SGCitaDisponibilidadId = new int[1] ;
      P00412_A20PacienteId = new int[1] ;
      P00412_A19CitaId = new int[1] ;
      P00412_A91CitaLink = new String[] {""} ;
      P00412_n91CitaLink = new boolean[] {false} ;
      P00412_A100CitaAntecedentes = new String[] {""} ;
      P00412_n100CitaAntecedentes = new boolean[] {false} ;
      P00412_A90CitaInforme = new String[] {""} ;
      P00412_n90CitaInforme = new boolean[] {false} ;
      P00412_A89CitaEstadoCita = new String[] {""} ;
      P00412_n89CitaEstadoCita = new boolean[] {false} ;
      P00412_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      P00412_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00412_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00412_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P00412_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00412_A65CitaTipoDiagnostico = new String[] {""} ;
      P00412_n65CitaTipoDiagnostico = new boolean[] {false} ;
      P00412_A106PacienteNroDocumento = new String[] {""} ;
      P00412_A105PacienteNombres = new String[] {""} ;
      P00412_A104PacienteApellidoMaterno = new String[] {""} ;
      P00412_A103PacienteApellidoPaterno = new String[] {""} ;
      P00412_A64CitaCode = new String[] {""} ;
      P00412_A84ProfesionalNombres = new String[] {""} ;
      P00412_n84ProfesionalNombres = new boolean[] {false} ;
      P00412_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00412_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00412_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00412_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV95TFCitaTipoDiagnostico_SelsJson = "" ;
      AV81TFCitaEstadoCita_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citawwexport__default(),
         new Object[] {
             new Object[] {
            P00412_A81SGCitaDisponibilidadProfesionalId, P00412_A76SGCitaDisponibilidadClinicaId, P00412_A72SGCitaDisponibilidadSedeId, P00412_A70SGCitaDisponibilidadEspecialidadId, P00412_A387SGCitaDisponibilidadHoraFin, P00412_n387SGCitaDisponibilidadHoraFin, P00412_A68SGCitaDisponibilidadHoraInicio, P00412_n68SGCitaDisponibilidadHoraInicio, P00412_A66SGCitaDisponibilidadFecha, P00412_n66SGCitaDisponibilidadFecha,
            P00412_A21SGCitaDisponibilidadId, P00412_A20PacienteId, P00412_A19CitaId, P00412_A91CitaLink, P00412_n91CitaLink, P00412_A100CitaAntecedentes, P00412_n100CitaAntecedentes, P00412_A90CitaInforme, P00412_n90CitaInforme, P00412_A89CitaEstadoCita,
            P00412_n89CitaEstadoCita, P00412_A87SGCitaDisponibilidadProCOP, P00412_A82SGCitaDisponibilidadProFullName, P00412_A78SGCitaDisponibilidadClinicaNombre, P00412_A73SGCitaDisponibilidadSedeNombre, P00412_A146SGCitaDisponibilidadEspecialidadNombre, P00412_A65CitaTipoDiagnostico, P00412_n65CitaTipoDiagnostico, P00412_A106PacienteNroDocumento, P00412_A105PacienteNombres,
            P00412_A104PacienteApellidoMaterno, P00412_A103PacienteApellidoPaterno, P00412_A64CitaCode, P00412_A84ProfesionalNombres, P00412_n84ProfesionalNombres, P00412_A85ProfesionalApellidoPaterno, P00412_n85ProfesionalApellidoPaterno, P00412_A86ProfesionalApellidoMaterno, P00412_n86ProfesionalApellidoMaterno
            }
         }
      );
      AV101Pgmname = "CitaWWExport" ;
      /* GeneXus formulas. */
      AV101Pgmname = "CitaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV63TFSGCitaDisponibilidadEspecialidadId ;
   private short AV64TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV67TFSGCitaDisponibilidadSedeId ;
   private short AV68TFSGCitaDisponibilidadSedeId_To ;
   private short AV71TFSGCitaDisponibilidadClinicaId ;
   private short AV72TFSGCitaDisponibilidadClinicaId_To ;
   private short GXv_int5[] ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid ;
   private short AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV134Citawwds_29_tfsgcitadisponibilidadsedeid ;
   private short AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to ;
   private short AV138Citawwds_33_tfsgcitadisponibilidadclinicaid ;
   private short AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFCitaId ;
   private int AV36TFCitaId_To ;
   private int AV39TFPacienteId ;
   private int AV40TFPacienteId_To ;
   private int AV102GXV1 ;
   private int AV57TFSGCitaDisponibilidadId ;
   private int AV58TFSGCitaDisponibilidadId_To ;
   private int AV75TFSGCitaDisponibilidadProfesionalId ;
   private int AV76TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV103GXV2 ;
   private int AV104GXV3 ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int AV107Citawwds_2_tfcitaid ;
   private int AV108Citawwds_3_tfcitaid_to ;
   private int AV111Citawwds_6_tfpacienteid ;
   private int AV112Citawwds_7_tfpacienteid_to ;
   private int AV122Citawwds_17_tfsgcitadisponibilidadid ;
   private int AV123Citawwds_18_tfsgcitadisponibilidadid_to ;
   private int AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid ;
   private int AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV121Citawwds_16_tfcitatipodiagnostico_sels_size ;
   private int AV148Citawwds_43_tfcitaestadocita_sels_size ;
   private int AV155GXV4 ;
   private long AV86i ;
   private long AV32VisibleColumnCount ;
   private String AV101Pgmname ;
   private String AV83TFCitaEstadoCita_Sel ;
   private String A89CitaEstadoCita ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV61TFSGCitaDisponibilidadHoraInicio ;
   private java.util.Date AV62TFSGCitaDisponibilidadHoraInicio_To ;
   private java.util.Date AV97TFSGCitaDisponibilidadHoraFin ;
   private java.util.Date AV98TFSGCitaDisponibilidadHoraFin_To ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date AV126Citawwds_21_tfsgcitadisponibilidadhorainicio ;
   private java.util.Date AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to ;
   private java.util.Date AV128Citawwds_23_tfsgcitadisponibilidadhorafin ;
   private java.util.Date AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV59TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV60TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV124Citawwds_19_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV125Citawwds_20_tfsgcitadisponibilidadfecha_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n91CitaLink ;
   private boolean n100CitaAntecedentes ;
   private boolean n90CitaInforme ;
   private boolean n89CitaEstadoCita ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private String AV27ColumnsSelectorXML ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String AV28UserCustomValue ;
   private String AV95TFCitaTipoDiagnostico_SelsJson ;
   private String AV81TFCitaEstadoCita_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFCitaCode_Sel ;
   private String AV37TFCitaCode ;
   private String AV42TFPacienteApellidoPaterno_Sel ;
   private String AV41TFPacienteApellidoPaterno ;
   private String AV44TFPacienteApellidoMaterno_Sel ;
   private String AV43TFPacienteApellidoMaterno ;
   private String AV46TFPacienteNombres_Sel ;
   private String AV45TFPacienteNombres ;
   private String AV48TFPacienteNroDocumento_Sel ;
   private String AV47TFPacienteNroDocumento ;
   private String AV56TFCitaTipoDiagnostico_Sel ;
   private String AV66TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV65TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV87TFSGCitaDisponibilidadSedeNombre_Sel ;
   private String AV69TFSGCitaDisponibilidadSedeNombre ;
   private String AV88TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV73TFSGCitaDisponibilidadClinicaNombre ;
   private String AV78TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV77TFSGCitaDisponibilidadProFullName ;
   private String AV80TFSGCitaDisponibilidadProCOP_Sel ;
   private String AV79TFSGCitaDisponibilidadProCOP ;
   private String AV85TFCitaInforme_Sel ;
   private String AV84TFCitaInforme ;
   private String AV90TFCitaAntecedentes_Sel ;
   private String AV89TFCitaAntecedentes ;
   private String AV92TFCitaLink_Sel ;
   private String AV91TFCitaLink ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A65CitaTipoDiagnostico ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A91CitaLink ;
   private String AV106Citawwds_1_filterfulltext ;
   private String AV109Citawwds_4_tfcitacode ;
   private String AV110Citawwds_5_tfcitacode_sel ;
   private String AV113Citawwds_8_tfpacienteapellidopaterno ;
   private String AV114Citawwds_9_tfpacienteapellidopaterno_sel ;
   private String AV115Citawwds_10_tfpacienteapellidomaterno ;
   private String AV116Citawwds_11_tfpacienteapellidomaterno_sel ;
   private String AV117Citawwds_12_tfpacientenombres ;
   private String AV118Citawwds_13_tfpacientenombres_sel ;
   private String AV119Citawwds_14_tfpacientenrodocumento ;
   private String AV120Citawwds_15_tfpacientenrodocumento_sel ;
   private String AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV136Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ;
   private String AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV144Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel ;
   private String AV146Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel ;
   private String AV149Citawwds_44_tfcitainforme ;
   private String AV150Citawwds_45_tfcitainforme_sel ;
   private String AV151Citawwds_46_tfcitaantecedentes ;
   private String AV152Citawwds_47_tfcitaantecedentes_sel ;
   private String AV153Citawwds_48_tfcitalink ;
   private String AV154Citawwds_49_tfcitalink_sel ;
   private String lV106Citawwds_1_filterfulltext ;
   private String lV109Citawwds_4_tfcitacode ;
   private String lV113Citawwds_8_tfpacienteapellidopaterno ;
   private String lV115Citawwds_10_tfpacienteapellidomaterno ;
   private String lV117Citawwds_12_tfpacientenombres ;
   private String lV119Citawwds_14_tfpacientenrodocumento ;
   private String lV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV136Citawwds_31_tfsgcitadisponibilidadsedenombre ;
   private String lV140Citawwds_35_tfsgcitadisponibilidadclinicanombre ;
   private String lV144Citawwds_39_tfsgcitadisponibilidadprofullname ;
   private String lV146Citawwds_41_tfsgcitadisponibilidadprocop ;
   private String lV149Citawwds_44_tfcitainforme ;
   private String lV151Citawwds_46_tfcitaantecedentes ;
   private String lV153Citawwds_48_tfcitalink ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV82TFCitaEstadoCita_Sels ;
   private GXSimpleCollection<String> AV96TFCitaTipoDiagnostico_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00412_A81SGCitaDisponibilidadProfesionalId ;
   private short[] P00412_A76SGCitaDisponibilidadClinicaId ;
   private short[] P00412_A72SGCitaDisponibilidadSedeId ;
   private short[] P00412_A70SGCitaDisponibilidadEspecialidadId ;
   private java.util.Date[] P00412_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P00412_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P00412_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P00412_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P00412_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00412_n66SGCitaDisponibilidadFecha ;
   private int[] P00412_A21SGCitaDisponibilidadId ;
   private int[] P00412_A20PacienteId ;
   private int[] P00412_A19CitaId ;
   private String[] P00412_A91CitaLink ;
   private boolean[] P00412_n91CitaLink ;
   private String[] P00412_A100CitaAntecedentes ;
   private boolean[] P00412_n100CitaAntecedentes ;
   private String[] P00412_A90CitaInforme ;
   private boolean[] P00412_n90CitaInforme ;
   private String[] P00412_A89CitaEstadoCita ;
   private boolean[] P00412_n89CitaEstadoCita ;
   private String[] P00412_A87SGCitaDisponibilidadProCOP ;
   private String[] P00412_A82SGCitaDisponibilidadProFullName ;
   private String[] P00412_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00412_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P00412_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00412_A65CitaTipoDiagnostico ;
   private boolean[] P00412_n65CitaTipoDiagnostico ;
   private String[] P00412_A106PacienteNroDocumento ;
   private String[] P00412_A105PacienteNombres ;
   private String[] P00412_A104PacienteApellidoMaterno ;
   private String[] P00412_A103PacienteApellidoPaterno ;
   private String[] P00412_A64CitaCode ;
   private String[] P00412_A84ProfesionalNombres ;
   private boolean[] P00412_n84ProfesionalNombres ;
   private String[] P00412_A85ProfesionalApellidoPaterno ;
   private boolean[] P00412_n85ProfesionalApellidoPaterno ;
   private String[] P00412_A86ProfesionalApellidoMaterno ;
   private boolean[] P00412_n86ProfesionalApellidoMaterno ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV148Citawwds_43_tfcitaestadocita_sels ;
   private GXSimpleCollection<String> AV121Citawwds_16_tfcitatipodiagnostico_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class citawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00412( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A65CitaTipoDiagnostico ,
                                          GXSimpleCollection<String> AV121Citawwds_16_tfcitatipodiagnostico_sels ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV148Citawwds_43_tfcitaestadocita_sels ,
                                          String AV106Citawwds_1_filterfulltext ,
                                          int AV107Citawwds_2_tfcitaid ,
                                          int AV108Citawwds_3_tfcitaid_to ,
                                          String AV110Citawwds_5_tfcitacode_sel ,
                                          String AV109Citawwds_4_tfcitacode ,
                                          int AV111Citawwds_6_tfpacienteid ,
                                          int AV112Citawwds_7_tfpacienteid_to ,
                                          String AV114Citawwds_9_tfpacienteapellidopaterno_sel ,
                                          String AV113Citawwds_8_tfpacienteapellidopaterno ,
                                          String AV116Citawwds_11_tfpacienteapellidomaterno_sel ,
                                          String AV115Citawwds_10_tfpacienteapellidomaterno ,
                                          String AV118Citawwds_13_tfpacientenombres_sel ,
                                          String AV117Citawwds_12_tfpacientenombres ,
                                          String AV120Citawwds_15_tfpacientenrodocumento_sel ,
                                          String AV119Citawwds_14_tfpacientenrodocumento ,
                                          int AV121Citawwds_16_tfcitatipodiagnostico_sels_size ,
                                          int AV122Citawwds_17_tfsgcitadisponibilidadid ,
                                          int AV123Citawwds_18_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV124Citawwds_19_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV125Citawwds_20_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV126Citawwds_21_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to ,
                                          java.util.Date AV128Citawwds_23_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to ,
                                          short AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid ,
                                          short AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre ,
                                          short AV134Citawwds_29_tfsgcitadisponibilidadsedeid ,
                                          short AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to ,
                                          String AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV136Citawwds_31_tfsgcitadisponibilidadsedenombre ,
                                          short AV138Citawwds_33_tfsgcitadisponibilidadclinicaid ,
                                          short AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre ,
                                          int AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid ,
                                          int AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV144Citawwds_39_tfsgcitadisponibilidadprofullname ,
                                          String AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel ,
                                          String AV146Citawwds_41_tfsgcitadisponibilidadprocop ,
                                          int AV148Citawwds_43_tfcitaestadocita_sels_size ,
                                          String AV150Citawwds_45_tfcitainforme_sel ,
                                          String AV149Citawwds_44_tfcitainforme ,
                                          String AV152Citawwds_47_tfcitaantecedentes_sel ,
                                          String AV151Citawwds_46_tfcitaantecedentes ,
                                          String AV154Citawwds_49_tfcitalink_sel ,
                                          String AV153Citawwds_48_tfcitalink ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          int A21SGCitaDisponibilidadId ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          short A72SGCitaDisponibilidadSedeId ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A87SGCitaDisponibilidadProCOP ,
                                          String A90CitaInforme ,
                                          String A100CitaAntecedentes ,
                                          String A91CitaLink ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[75];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T2.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId," ;
      scmdbuf += " T2.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T2.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T2.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      scmdbuf += " T2.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PacienteId], T1.[CitaId], T1.[CitaLink], T1.[CitaAntecedentes]," ;
      scmdbuf += " T1.[CitaInforme], T1.[CitaEstadoCita], T3.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, COALESCE( T3.[ProfesionalNombres], '') + ' ' + COALESCE( T3.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T3.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T5.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre," ;
      scmdbuf += " T4.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T6.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T1.[CitaTipoDiagnostico], T7.[PacienteNroDocumento]," ;
      scmdbuf += " T7.[PacienteNombres], T7.[PacienteApellidoMaterno], T7.[PacienteApellidoPaterno], T1.[CitaCode], T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM (((((([Cita] T1 INNER JOIN [Disponibilidad] T2 ON T2.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] =" ;
      scmdbuf += " T2.[ProfesionalId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T2.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T5 ON T5.[ClinicaId] = T4.[ClinicaId]) INNER JOIN" ;
      scmdbuf += " [Especialidad] T6 ON T6.[EspecialidadId] = T2.[EspecialidadId]) INNER JOIN [Paciente] T7 ON T7.[PacienteId] = T1.[PacienteId])" ;
      if ( ! (GXutil.strcmp("", AV106Citawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T1.[CitaCode] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T7.[PacienteApellidoPaterno] like '%' + ?) or ( T7.[PacienteApellidoMaterno] like '%' + ?) or ( T7.[PacienteNombres] like '%' + ?) or ( T7.[PacienteNroDocumento] like '%' + ?) or ( 'prensuntivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Prensuntivo') or ( 'definitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Definitivo') or ( 'repetitivo' like '%' + LOWER(?) and T1.[CitaTipoDiagnostico] = 'Repetitivo') or ( CONVERT( char(8), CAST(T1.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T2.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T6.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[SGSedeDisponibilidadSedeId] AS decimal(4,0))) like '%' + ?) or ( T4.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T4.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T5.[ClinicaNombreAbreviado] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( T1.[CitaInforme] like '%' + ?) or ( T1.[CitaAntecedentes] like '%' + ?) or ( T1.[CitaLink] like '%' + ?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
         GXv_int11[1] = (byte)(1) ;
         GXv_int11[2] = (byte)(1) ;
         GXv_int11[3] = (byte)(1) ;
         GXv_int11[4] = (byte)(1) ;
         GXv_int11[5] = (byte)(1) ;
         GXv_int11[6] = (byte)(1) ;
         GXv_int11[7] = (byte)(1) ;
         GXv_int11[8] = (byte)(1) ;
         GXv_int11[9] = (byte)(1) ;
         GXv_int11[10] = (byte)(1) ;
         GXv_int11[11] = (byte)(1) ;
         GXv_int11[12] = (byte)(1) ;
         GXv_int11[13] = (byte)(1) ;
         GXv_int11[14] = (byte)(1) ;
         GXv_int11[15] = (byte)(1) ;
         GXv_int11[16] = (byte)(1) ;
         GXv_int11[17] = (byte)(1) ;
         GXv_int11[18] = (byte)(1) ;
         GXv_int11[19] = (byte)(1) ;
         GXv_int11[20] = (byte)(1) ;
         GXv_int11[21] = (byte)(1) ;
         GXv_int11[22] = (byte)(1) ;
         GXv_int11[23] = (byte)(1) ;
         GXv_int11[24] = (byte)(1) ;
         GXv_int11[25] = (byte)(1) ;
         GXv_int11[26] = (byte)(1) ;
         GXv_int11[27] = (byte)(1) ;
         GXv_int11[28] = (byte)(1) ;
      }
      if ( ! (0==AV107Citawwds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int11[29] = (byte)(1) ;
      }
      if ( ! (0==AV108Citawwds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int11[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Citawwds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV109Citawwds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Citawwds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int11[32] = (byte)(1) ;
      }
      if ( ! (0==AV111Citawwds_6_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int11[33] = (byte)(1) ;
      }
      if ( ! (0==AV112Citawwds_7_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Citawwds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV113Citawwds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Citawwds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Citawwds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Citawwds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Citawwds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Citawwds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV117Citawwds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Citawwds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Citawwds_15_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV119Citawwds_14_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Citawwds_15_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( AV121Citawwds_16_tfcitatipodiagnostico_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV121Citawwds_16_tfcitatipodiagnostico_sels, "T1.[CitaTipoDiagnostico] IN (", ")")+")");
      }
      if ( ! (0==AV122Citawwds_17_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( ! (0==AV123Citawwds_18_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV124Citawwds_19_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Citawwds_20_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Citawwds_21_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int11[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV127Citawwds_22_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int11[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV128Citawwds_23_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int11[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV129Citawwds_24_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int11[50] = (byte)(1) ;
      }
      if ( ! (0==AV130Citawwds_25_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int11[51] = (byte)(1) ;
      }
      if ( ! (0==AV131Citawwds_26_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int11[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV132Citawwds_27_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int11[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Citawwds_28_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int11[54] = (byte)(1) ;
      }
      if ( ! (0==AV134Citawwds_29_tfsgcitadisponibilidadsedeid) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] >= ?)");
      }
      else
      {
         GXv_int11[55] = (byte)(1) ;
      }
      if ( ! (0==AV135Citawwds_30_tfsgcitadisponibilidadsedeid_to) )
      {
         addWhere(sWhereString, "(T2.[SGSedeDisponibilidadSedeId] <= ?)");
      }
      else
      {
         GXv_int11[56] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV136Citawwds_31_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int11[57] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV137Citawwds_32_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int11[58] = (byte)(1) ;
      }
      if ( ! (0==AV138Citawwds_33_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int11[59] = (byte)(1) ;
      }
      if ( ! (0==AV139Citawwds_34_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T4.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int11[60] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV140Citawwds_35_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int11[61] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV141Citawwds_36_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int11[62] = (byte)(1) ;
      }
      if ( ! (0==AV142Citawwds_37_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int11[63] = (byte)(1) ;
      }
      if ( ! (0==AV143Citawwds_38_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int11[64] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV144Citawwds_39_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[65] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Citawwds_40_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[66] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) && ( ! (GXutil.strcmp("", AV146Citawwds_41_tfsgcitadisponibilidadprocop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int11[67] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV147Citawwds_42_tfsgcitadisponibilidadprocop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int11[68] = (byte)(1) ;
      }
      if ( AV148Citawwds_43_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV148Citawwds_43_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV150Citawwds_45_tfcitainforme_sel)==0) && ( ! (GXutil.strcmp("", AV149Citawwds_44_tfcitainforme)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] like ?)");
      }
      else
      {
         GXv_int11[69] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Citawwds_45_tfcitainforme_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaInforme] = ?)");
      }
      else
      {
         GXv_int11[70] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV152Citawwds_47_tfcitaantecedentes_sel)==0) && ( ! (GXutil.strcmp("", AV151Citawwds_46_tfcitaantecedentes)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] like ?)");
      }
      else
      {
         GXv_int11[71] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV152Citawwds_47_tfcitaantecedentes_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaAntecedentes] = ?)");
      }
      else
      {
         GXv_int11[72] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV154Citawwds_49_tfcitalink_sel)==0) && ( ! (GXutil.strcmp("", AV153Citawwds_48_tfcitalink)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] like ?)");
      }
      else
      {
         GXv_int11[73] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV154Citawwds_49_tfcitalink_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaLink] = ?)");
      }
      else
      {
         GXv_int11[74] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaCode]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteNombres]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteNombres] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[PacienteNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaTipoDiagnostico]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaTipoDiagnostico] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadFecha]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadId]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[EspecialidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T6.[EspecialidadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T6.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SGSedeDisponibilidadSedeId]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SGSedeDisponibilidadSedeId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[SedeNombre]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[SedeNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[ClinicaId]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[ClinicaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ProfesionalId]" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ProfesionalId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP]" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ProfesionalCOP] DESC" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaEstadoCita]" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaEstadoCita] DESC" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaInforme]" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaInforme] DESC" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaAntecedentes]" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaAntecedentes] DESC" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaLink]" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaLink] DESC" ;
      }
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00412(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (java.util.Date)dynConstraints[22] , (java.util.Date)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , (String)dynConstraints[49] , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , ((Number) dynConstraints[65]).shortValue() , (String)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , (String)dynConstraints[68] , (String)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (String)dynConstraints[72] , (String)dynConstraints[73] , (String)dynConstraints[74] , (java.util.Date)dynConstraints[75] , (java.util.Date)dynConstraints[76] , (java.util.Date)dynConstraints[77] , ((Number) dynConstraints[78]).shortValue() , ((Boolean) dynConstraints[79]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00412", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(15);
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((String[]) buf[23])[0] = rslt.getVarchar(17);
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((String[]) buf[25])[0] = rslt.getVarchar(19);
               ((String[]) buf[26])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((String[]) buf[32])[0] = rslt.getVarchar(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[104]).intValue());
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[105]).intValue());
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[108]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[109]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 15);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 15);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[118]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[119]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[120]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[121]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[122], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[123], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[124], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[125], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[126]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[127]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 40);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 40);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[130]).shortValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[131]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[132], 80);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[133], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[134]).shortValue());
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[135]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 100);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 100);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[138]).intValue());
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[139]).intValue());
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 40);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 40);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[144], 200);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[145], 200);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 200);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               return;
      }
   }

}

