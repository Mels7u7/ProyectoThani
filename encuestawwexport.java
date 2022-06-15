package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class encuestawwexport extends GXProcedure
{
   public encuestawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuestawwexport.class ), "" );
   }

   public encuestawwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      encuestawwexport.this.aP1 = new String[] {""};
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
      encuestawwexport.this.aP0 = aP0;
      encuestawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta", GXv_boolean2) ;
      encuestawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV82Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "EncuestaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFEncuestaId) && (0==AV36TFEncuestaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFEncuestaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFEncuestaId_To );
      }
      if ( ! ( (0==AV37TFCitaId) && (0==AV38TFCitaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cita Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFCitaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFCitaId_To );
      }
      if ( ! ( (0==AV39TFSGCitaDisponibilidadProfesionalId) && (0==AV40TFSGCitaDisponibilidadProfesionalId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Profesional Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFSGCitaDisponibilidadProfesionalId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFSGCitaDisponibilidadProfesionalId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV42TFSGCitaDisponibilidadProFullName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Pro Full Name") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFSGCitaDisponibilidadProFullName_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFSGCitaDisponibilidadProFullName)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Pro Full Name") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFSGCitaDisponibilidadProFullName, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFSGCitaDisponibilidadEspecialidadId) && (0==AV44TFSGCitaDisponibilidadEspecialidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Especialidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV43TFSGCitaDisponibilidadEspecialidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV44TFSGCitaDisponibilidadEspecialidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Especialidad Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFSGCitaDisponibilidadEspecialidadNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Especialidad Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFSGCitaDisponibilidadEspecialidadNombre, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV47TFSGCitaDisponibilidadId) && (0==AV48TFSGCitaDisponibilidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV47TFSGCitaDisponibilidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV48TFSGCitaDisponibilidadId_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50TFSGCitaDisponibilidadFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Fecha") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV49TFSGCitaDisponibilidadFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV50TFSGCitaDisponibilidadFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( (0==AV51TFPacienteId) && (0==AV52TFPacienteId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV51TFPacienteId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV52TFPacienteId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV54TFPacienteApellidoPaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Paterno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFPacienteApellidoPaterno_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV53TFPacienteApellidoPaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Paterno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFPacienteApellidoPaterno, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV56TFPacienteApellidoMaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Materno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFPacienteApellidoMaterno_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV55TFPacienteApellidoMaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Apellido Materno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFPacienteApellidoMaterno, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV58TFPacienteNombres_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nombres") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFPacienteNombres_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFPacienteNombres)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Paciente Nombres") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFPacienteNombres, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV59TFSGCitaDisponibilidadClinicaId) && (0==AV60TFSGCitaDisponibilidadClinicaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Clinica Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV59TFSGCitaDisponibilidadClinicaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV60TFSGCitaDisponibilidadClinicaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV79TFSGCitaDisponibilidadClinicaNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Clinica Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV79TFSGCitaDisponibilidadClinicaNombre_Sel, GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV61TFSGCitaDisponibilidadClinicaNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Clinica Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFSGCitaDisponibilidadClinicaNombre, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV64TFEncuestaAtencion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Atencion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV78i = 1 ;
         AV83GXV1 = 1 ;
         while ( AV83GXV1 <= AV64TFEncuestaAtencion_Sels.size() )
         {
            AV65TFEncuestaAtencion_Sel = (String)AV64TFEncuestaAtencion_Sels.elementAt(-1+AV83GXV1) ;
            if ( AV78i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            if ( GXutil.strcmp(GXutil.trim( AV65TFEncuestaAtencion_Sel), "B") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Buena" );
            }
            else if ( GXutil.strcmp(GXutil.trim( AV65TFEncuestaAtencion_Sel), "R") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Regular" );
            }
            else if ( GXutil.strcmp(GXutil.trim( AV65TFEncuestaAtencion_Sel), "M") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Mala" );
            }
            AV78i = (long)(AV78i+1) ;
            AV83GXV1 = (int)(AV83GXV1+1) ;
         }
      }
      if ( ! ( ( AV67TFEncuestaAtendido_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Atendido") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV78i = 1 ;
         AV84GXV2 = 1 ;
         while ( AV84GXV2 <= AV67TFEncuestaAtendido_Sels.size() )
         {
            AV68TFEncuestaAtendido_Sel = (String)AV67TFEncuestaAtendido_Sels.elementAt(-1+AV84GXV2) ;
            if ( AV78i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            if ( GXutil.strcmp(GXutil.trim( AV68TFEncuestaAtendido_Sel), "S") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Si" );
            }
            else if ( GXutil.strcmp(GXutil.trim( AV68TFEncuestaAtendido_Sel), "N") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"No" );
            }
            AV78i = (long)(AV78i+1) ;
            AV84GXV2 = (int)(AV84GXV2+1) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV69TFEncuestaHoraAtencion) && GXutil.dateCompare(GXutil.nullDate(), AV70TFEncuestaHoraAtencion_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Hora Atencion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( AV69TFEncuestaHoraAtencion, "99:99") );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( localUtil.format( AV70TFEncuestaHoraAtencion_To, "99:99") );
      }
      if ( ! ( (GXutil.strcmp("", AV72TFEncuestaComentarios_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Comentarios") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV72TFEncuestaComentarios_Sel, 1, 1000), GXv_char7) ;
         encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV71TFEncuestaComentarios)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Comentarios") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV71TFEncuestaComentarios, 1, 1000), GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV73TFEncuestaRecomendacion) && (0==AV74TFEncuestaRecomendacion_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Recomendacion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV73TFEncuestaRecomendacion );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV74TFEncuestaRecomendacion_To );
      }
      if ( ! ( ( AV76TFEncuestaEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         encuestawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV78i = 1 ;
         AV85GXV3 = 1 ;
         while ( AV85GXV3 <= AV76TFEncuestaEstado_Sels.size() )
         {
            AV77TFEncuestaEstado_Sel = (String)AV76TFEncuestaEstado_Sels.elementAt(-1+AV85GXV3) ;
            if ( AV78i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            if ( GXutil.strcmp(GXutil.trim( AV77TFEncuestaEstado_Sel), "P") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Pendiente" );
            }
            else if ( GXutil.strcmp(GXutil.trim( AV77TFEncuestaEstado_Sel), "R") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"Realizada" );
            }
            else if ( GXutil.strcmp(GXutil.trim( AV77TFEncuestaEstado_Sel), "") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+"" );
            }
            AV78i = (long)(AV78i+1) ;
            AV85GXV3 = (int)(AV85GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("EncuestaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("EncuestaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV86GXV4 = 1 ;
      while ( AV86GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV86GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV86GXV4 = (int)(AV86GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV88Encuestawwds_1_filterfulltext = AV19FilterFullText ;
      AV89Encuestawwds_2_tfencuestaid = AV35TFEncuestaId ;
      AV90Encuestawwds_3_tfencuestaid_to = AV36TFEncuestaId_To ;
      AV91Encuestawwds_4_tfcitaid = AV37TFCitaId ;
      AV92Encuestawwds_5_tfcitaid_to = AV38TFCitaId_To ;
      AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV39TFSGCitaDisponibilidadProfesionalId ;
      AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV40TFSGCitaDisponibilidadProfesionalId_To ;
      AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV41TFSGCitaDisponibilidadProFullName ;
      AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV42TFSGCitaDisponibilidadProFullName_Sel ;
      AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV43TFSGCitaDisponibilidadEspecialidadId ;
      AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV44TFSGCitaDisponibilidadEspecialidadId_To ;
      AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV45TFSGCitaDisponibilidadEspecialidadNombre ;
      AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV101Encuestawwds_14_tfsgcitadisponibilidadid = AV47TFSGCitaDisponibilidadId ;
      AV102Encuestawwds_15_tfsgcitadisponibilidadid_to = AV48TFSGCitaDisponibilidadId_To ;
      AV103Encuestawwds_16_tfsgcitadisponibilidadfecha = AV49TFSGCitaDisponibilidadFecha ;
      AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV50TFSGCitaDisponibilidadFecha_To ;
      AV105Encuestawwds_18_tfpacienteid = AV51TFPacienteId ;
      AV106Encuestawwds_19_tfpacienteid_to = AV52TFPacienteId_To ;
      AV107Encuestawwds_20_tfpacienteapellidopaterno = AV53TFPacienteApellidoPaterno ;
      AV108Encuestawwds_21_tfpacienteapellidopaterno_sel = AV54TFPacienteApellidoPaterno_Sel ;
      AV109Encuestawwds_22_tfpacienteapellidomaterno = AV55TFPacienteApellidoMaterno ;
      AV110Encuestawwds_23_tfpacienteapellidomaterno_sel = AV56TFPacienteApellidoMaterno_Sel ;
      AV111Encuestawwds_24_tfpacientenombres = AV57TFPacienteNombres ;
      AV112Encuestawwds_25_tfpacientenombres_sel = AV58TFPacienteNombres_Sel ;
      AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV59TFSGCitaDisponibilidadClinicaId ;
      AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV60TFSGCitaDisponibilidadClinicaId_To ;
      AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV61TFSGCitaDisponibilidadClinicaNombre ;
      AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV79TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV117Encuestawwds_30_tfencuestaatencion_sels = AV64TFEncuestaAtencion_Sels ;
      AV118Encuestawwds_31_tfencuestaatendido_sels = AV67TFEncuestaAtendido_Sels ;
      AV119Encuestawwds_32_tfencuestahoraatencion = AV69TFEncuestaHoraAtencion ;
      AV120Encuestawwds_33_tfencuestahoraatencion_to = AV70TFEncuestaHoraAtencion_To ;
      AV121Encuestawwds_34_tfencuestacomentarios = AV71TFEncuestaComentarios ;
      AV122Encuestawwds_35_tfencuestacomentarios_sel = AV72TFEncuestaComentarios_Sel ;
      AV123Encuestawwds_36_tfencuestarecomendacion = AV73TFEncuestaRecomendacion ;
      AV124Encuestawwds_37_tfencuestarecomendacion_to = AV74TFEncuestaRecomendacion_To ;
      AV125Encuestawwds_38_tfencuestaestado_sels = AV76TFEncuestaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV117Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV118Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV125Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV89Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV90Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV91Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV92Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV101Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV102Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV103Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV105Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV106Encuestawwds_19_tfpacienteid_to) ,
                                           AV108Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV107Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV110Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV109Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV112Encuestawwds_25_tfpacientenombres_sel ,
                                           AV111Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV117Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV118Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV119Encuestawwds_32_tfencuestahoraatencion ,
                                           AV120Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV122Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV121Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV123Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV124Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV125Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV88Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV88Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV88Encuestawwds_1_filterfulltext), "%", "") ;
      lV95Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV107Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV107Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV109Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV109Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV111Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV111Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV121Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV121Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P004N2 */
      pr_default.execute(0, new Object[] {AV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, lV88Encuestawwds_1_filterfulltext, Short.valueOf(AV89Encuestawwds_2_tfencuestaid), Short.valueOf(AV90Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV91Encuestawwds_4_tfcitaid), Integer.valueOf(AV92Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV95Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV101Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV102Encuestawwds_15_tfsgcitadisponibilidadid_to), AV103Encuestawwds_16_tfsgcitadisponibilidadfecha, AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV105Encuestawwds_18_tfpacienteid), Integer.valueOf(AV106Encuestawwds_19_tfpacienteid_to), lV107Encuestawwds_20_tfpacienteapellidopaterno, AV108Encuestawwds_21_tfpacienteapellidopaterno_sel, lV109Encuestawwds_22_tfpacienteapellidomaterno, AV110Encuestawwds_23_tfpacienteapellidomaterno_sel, lV111Encuestawwds_24_tfpacientenombres, AV112Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV119Encuestawwds_32_tfencuestahoraatencion, AV120Encuestawwds_33_tfencuestahoraatencion_to, lV121Encuestawwds_34_tfencuestacomentarios, AV122Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV123Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV124Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A72SGCitaDisponibilidadSedeId = P004N2_A72SGCitaDisponibilidadSedeId[0] ;
         A152EncuestaRecomendacion = P004N2_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P004N2_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P004N2_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P004N2_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P004N2_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P004N2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004N2_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P004N2_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P004N2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P004N2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P004N2_A19CitaId[0] ;
         A37EncuestaId = P004N2_A37EncuestaId[0] ;
         A153EncuestaEstado = P004N2_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P004N2_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P004N2_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P004N2_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P004N2_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P004N2_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P004N2_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P004N2_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P004N2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P004N2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P004N2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P004N2_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P004N2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P004N2_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P004N2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P004N2_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004N2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P004N2_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004N2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P004N2_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P004N2_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P004N2_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P004N2_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P004N2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P004N2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P004N2_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P004N2_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P004N2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004N2_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P004N2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P004N2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P004N2_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P004N2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P004N2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P004N2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P004N2_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P004N2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P004N2_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P004N2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P004N2_n86ProfesionalApellidoMaterno[0] ;
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
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A37EncuestaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A19CitaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A81SGCitaDisponibilidadProfesionalId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A82SGCitaDisponibilidadProFullName, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A70SGCitaDisponibilidadEspecialidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A146SGCitaDisponibilidadEspecialidadNombre, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A21SGCitaDisponibilidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A66SGCitaDisponibilidadFecha );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A20PacienteId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A103PacienteApellidoPaterno, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A104PacienteApellidoMaterno, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A105PacienteNombres, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A76SGCitaDisponibilidadClinicaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A78SGCitaDisponibilidadClinicaNombre, GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "B") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Buena" );
            }
            else if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "R") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Regular" );
            }
            else if ( GXutil.strcmp(GXutil.trim( A148EncuestaAtencion), "M") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Mala" );
            }
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            if ( GXutil.strcmp(GXutil.trim( A149EncuestaAtendido), "S") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Si" );
            }
            else if ( GXutil.strcmp(GXutil.trim( A149EncuestaAtendido), "N") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "No" );
            }
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( localUtil.format( A150EncuestaHoraAtencion, "99:99") );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A151EncuestaComentarios, 1, 1000), GXv_char7) ;
            encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A152EncuestaRecomendacion );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "P") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Pendiente" );
            }
            else if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "R") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "Realizada" );
            }
            else if ( GXutil.strcmp(GXutil.trim( A153EncuestaEstado), "") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            }
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Cita Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProfesionalId", "", "SGCita Disponibilidad Profesional Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadProFullName", "", "SGCita Disponibilidad Pro Full Name", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadId", "", "SGCita Disponibilidad Especialidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadEspecialidadNombre", "", "SGCita Disponibilidad Especialidad Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadId", "", "SGCita Disponibilidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "SGCita Disponibilidad Fecha", true, "") ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaId", "", "SGCita Disponibilidad Clinica Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadClinicaNombre", "", "SGCita Disponibilidad Clinica Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaAtencion", "", "Atencion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaAtendido", "", "Atendido", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaHoraAtencion", "", "Hora Atencion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaComentarios", "", "Comentarios", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaRecomendacion", "", "Recomendacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "EncuestaEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "EncuestaWWColumnsSelector", GXv_char7) ;
      encuestawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("EncuestaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EncuestaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("EncuestaWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV126GXV5 = 1 ;
      while ( AV126GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV126GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAID") == 0 )
         {
            AV35TFEncuestaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFEncuestaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV37TFCitaId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFCitaId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV39TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV41TFSGCitaDisponibilidadProFullName = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV42TFSGCitaDisponibilidadProFullName_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV43TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV44TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV45TFSGCitaDisponibilidadEspecialidadNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV47TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV48TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV49TFSGCitaDisponibilidadFecha = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV50TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV51TFPacienteId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFPacienteId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV53TFPacienteApellidoPaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV54TFPacienteApellidoPaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV55TFPacienteApellidoMaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV56TFPacienteApellidoMaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV57TFPacienteNombres = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV58TFPacienteNombres_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV59TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV61TFSGCitaDisponibilidadClinicaNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV79TFSGCitaDisponibilidadClinicaNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENCION_SEL") == 0 )
         {
            AV63TFEncuestaAtencion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV64TFEncuestaAtencion_Sels.fromJSonString(AV63TFEncuestaAtencion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENDIDO_SEL") == 0 )
         {
            AV66TFEncuestaAtendido_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFEncuestaAtendido_Sels.fromJSonString(AV66TFEncuestaAtendido_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAHORAATENCION") == 0 )
         {
            AV69TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV70TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS") == 0 )
         {
            AV71TFEncuestaComentarios = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS_SEL") == 0 )
         {
            AV72TFEncuestaComentarios_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTARECOMENDACION") == 0 )
         {
            AV73TFEncuestaRecomendacion = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV74TFEncuestaRecomendacion_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAESTADO_SEL") == 0 )
         {
            AV75TFEncuestaEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV76TFEncuestaEstado_Sels.fromJSonString(AV75TFEncuestaEstado_SelsJson, null);
         }
         AV126GXV5 = (int)(AV126GXV5+1) ;
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
      this.aP0[0] = encuestawwexport.this.AV12Filename;
      this.aP1[0] = encuestawwexport.this.AV13ErrorMessage;
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
      AV82Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV42TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV41TFSGCitaDisponibilidadProFullName = "" ;
      AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV45TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV49TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV50TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV54TFPacienteApellidoPaterno_Sel = "" ;
      AV53TFPacienteApellidoPaterno = "" ;
      AV56TFPacienteApellidoMaterno_Sel = "" ;
      AV55TFPacienteApellidoMaterno = "" ;
      AV58TFPacienteNombres_Sel = "" ;
      AV57TFPacienteNombres = "" ;
      AV79TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV61TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV64TFEncuestaAtencion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65TFEncuestaAtencion_Sel = "" ;
      AV67TFEncuestaAtendido_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFEncuestaAtendido_Sel = "" ;
      AV69TFEncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      AV70TFEncuestaHoraAtencion_To = GXutil.resetTime( GXutil.nullDate() );
      AV72TFEncuestaComentarios_Sel = "" ;
      AV71TFEncuestaComentarios = "" ;
      AV76TFEncuestaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV77TFEncuestaEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A82SGCitaDisponibilidadProFullName = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A151EncuestaComentarios = "" ;
      A153EncuestaEstado = "" ;
      AV88Encuestawwds_1_filterfulltext = "" ;
      AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV103Encuestawwds_16_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV107Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      AV108Encuestawwds_21_tfpacienteapellidopaterno_sel = "" ;
      AV109Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      AV110Encuestawwds_23_tfpacienteapellidomaterno_sel = "" ;
      AV111Encuestawwds_24_tfpacientenombres = "" ;
      AV112Encuestawwds_25_tfpacientenombres_sel = "" ;
      AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV117Encuestawwds_30_tfencuestaatencion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV118Encuestawwds_31_tfencuestaatendido_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV119Encuestawwds_32_tfencuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
      AV120Encuestawwds_33_tfencuestahoraatencion_to = GXutil.resetTime( GXutil.nullDate() );
      AV121Encuestawwds_34_tfencuestacomentarios = "" ;
      AV122Encuestawwds_35_tfencuestacomentarios_sel = "" ;
      AV125Encuestawwds_38_tfencuestaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV88Encuestawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV95Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      lV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV107Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      lV109Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      lV111Encuestawwds_24_tfpacientenombres = "" ;
      lV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      lV121Encuestawwds_34_tfencuestacomentarios = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      P004N2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P004N2_A152EncuestaRecomendacion = new byte[1] ;
      P004N2_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P004N2_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P004N2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P004N2_A20PacienteId = new int[1] ;
      P004N2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004N2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P004N2_A21SGCitaDisponibilidadId = new int[1] ;
      P004N2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P004N2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P004N2_A19CitaId = new int[1] ;
      P004N2_A37EncuestaId = new short[1] ;
      P004N2_A153EncuestaEstado = new String[] {""} ;
      P004N2_n153EncuestaEstado = new boolean[] {false} ;
      P004N2_A151EncuestaComentarios = new String[] {""} ;
      P004N2_n151EncuestaComentarios = new boolean[] {false} ;
      P004N2_A149EncuestaAtendido = new String[] {""} ;
      P004N2_n149EncuestaAtendido = new boolean[] {false} ;
      P004N2_A148EncuestaAtencion = new String[] {""} ;
      P004N2_n148EncuestaAtencion = new boolean[] {false} ;
      P004N2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P004N2_A105PacienteNombres = new String[] {""} ;
      P004N2_A104PacienteApellidoMaterno = new String[] {""} ;
      P004N2_A103PacienteApellidoPaterno = new String[] {""} ;
      P004N2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P004N2_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P004N2_A84ProfesionalNombres = new String[] {""} ;
      P004N2_n84ProfesionalNombres = new boolean[] {false} ;
      P004N2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P004N2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P004N2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P004N2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV63TFEncuestaAtencion_SelsJson = "" ;
      AV66TFEncuestaAtendido_SelsJson = "" ;
      AV75TFEncuestaEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuestawwexport__default(),
         new Object[] {
             new Object[] {
            P004N2_A72SGCitaDisponibilidadSedeId, P004N2_A152EncuestaRecomendacion, P004N2_A150EncuestaHoraAtencion, P004N2_n150EncuestaHoraAtencion, P004N2_A76SGCitaDisponibilidadClinicaId, P004N2_A20PacienteId, P004N2_A66SGCitaDisponibilidadFecha, P004N2_n66SGCitaDisponibilidadFecha, P004N2_A21SGCitaDisponibilidadId, P004N2_A70SGCitaDisponibilidadEspecialidadId,
            P004N2_A81SGCitaDisponibilidadProfesionalId, P004N2_A19CitaId, P004N2_A37EncuestaId, P004N2_A153EncuestaEstado, P004N2_n153EncuestaEstado, P004N2_A151EncuestaComentarios, P004N2_n151EncuestaComentarios, P004N2_A149EncuestaAtendido, P004N2_n149EncuestaAtendido, P004N2_A148EncuestaAtencion,
            P004N2_n148EncuestaAtencion, P004N2_A78SGCitaDisponibilidadClinicaNombre, P004N2_A105PacienteNombres, P004N2_A104PacienteApellidoMaterno, P004N2_A103PacienteApellidoPaterno, P004N2_A146SGCitaDisponibilidadEspecialidadNombre, P004N2_A82SGCitaDisponibilidadProFullName, P004N2_A84ProfesionalNombres, P004N2_n84ProfesionalNombres, P004N2_A85ProfesionalApellidoPaterno,
            P004N2_n85ProfesionalApellidoPaterno, P004N2_A86ProfesionalApellidoMaterno, P004N2_n86ProfesionalApellidoMaterno
            }
         }
      );
      AV82Pgmname = "EncuestaWWExport" ;
      /* GeneXus formulas. */
      AV82Pgmname = "EncuestaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV73TFEncuestaRecomendacion ;
   private byte AV74TFEncuestaRecomendacion_To ;
   private byte A152EncuestaRecomendacion ;
   private byte AV123Encuestawwds_36_tfencuestarecomendacion ;
   private byte AV124Encuestawwds_37_tfencuestarecomendacion_to ;
   private short AV35TFEncuestaId ;
   private short AV36TFEncuestaId_To ;
   private short AV43TFSGCitaDisponibilidadEspecialidadId ;
   private short AV44TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV59TFSGCitaDisponibilidadClinicaId ;
   private short AV60TFSGCitaDisponibilidadClinicaId_To ;
   private short GXv_int5[] ;
   private short A37EncuestaId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short AV89Encuestawwds_2_tfencuestaid ;
   private short AV90Encuestawwds_3_tfencuestaid_to ;
   private short AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ;
   private short AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid ;
   private short AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ;
   private short AV17OrderedBy ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV37TFCitaId ;
   private int AV38TFCitaId_To ;
   private int AV39TFSGCitaDisponibilidadProfesionalId ;
   private int AV40TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV47TFSGCitaDisponibilidadId ;
   private int AV48TFSGCitaDisponibilidadId_To ;
   private int AV51TFPacienteId ;
   private int AV52TFPacienteId_To ;
   private int AV83GXV1 ;
   private int AV84GXV2 ;
   private int AV85GXV3 ;
   private int AV86GXV4 ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private int AV91Encuestawwds_4_tfcitaid ;
   private int AV92Encuestawwds_5_tfcitaid_to ;
   private int AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ;
   private int AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV101Encuestawwds_14_tfsgcitadisponibilidadid ;
   private int AV102Encuestawwds_15_tfsgcitadisponibilidadid_to ;
   private int AV105Encuestawwds_18_tfpacienteid ;
   private int AV106Encuestawwds_19_tfpacienteid_to ;
   private int AV117Encuestawwds_30_tfencuestaatencion_sels_size ;
   private int AV118Encuestawwds_31_tfencuestaatendido_sels_size ;
   private int AV125Encuestawwds_38_tfencuestaestado_sels_size ;
   private int AV126GXV5 ;
   private long AV78i ;
   private long AV32VisibleColumnCount ;
   private String AV82Pgmname ;
   private String AV65TFEncuestaAtencion_Sel ;
   private String AV68TFEncuestaAtendido_Sel ;
   private String AV77TFEncuestaEstado_Sel ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String A153EncuestaEstado ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV69TFEncuestaHoraAtencion ;
   private java.util.Date AV70TFEncuestaHoraAtencion_To ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date AV119Encuestawwds_32_tfencuestahoraatencion ;
   private java.util.Date AV120Encuestawwds_33_tfencuestahoraatencion_to ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV49TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV50TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV103Encuestawwds_16_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n153EncuestaEstado ;
   private boolean n151EncuestaComentarios ;
   private boolean n149EncuestaAtendido ;
   private boolean n148EncuestaAtencion ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private String AV27ColumnsSelectorXML ;
   private String A151EncuestaComentarios ;
   private String AV28UserCustomValue ;
   private String AV63TFEncuestaAtencion_SelsJson ;
   private String AV66TFEncuestaAtendido_SelsJson ;
   private String AV75TFEncuestaEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV42TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV41TFSGCitaDisponibilidadProFullName ;
   private String AV46TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV45TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV54TFPacienteApellidoPaterno_Sel ;
   private String AV53TFPacienteApellidoPaterno ;
   private String AV56TFPacienteApellidoMaterno_Sel ;
   private String AV55TFPacienteApellidoMaterno ;
   private String AV58TFPacienteNombres_Sel ;
   private String AV57TFPacienteNombres ;
   private String AV79TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV61TFSGCitaDisponibilidadClinicaNombre ;
   private String AV72TFEncuestaComentarios_Sel ;
   private String AV71TFEncuestaComentarios ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String AV88Encuestawwds_1_filterfulltext ;
   private String AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ;
   private String AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV107Encuestawwds_20_tfpacienteapellidopaterno ;
   private String AV108Encuestawwds_21_tfpacienteapellidopaterno_sel ;
   private String AV109Encuestawwds_22_tfpacienteapellidomaterno ;
   private String AV110Encuestawwds_23_tfpacienteapellidomaterno_sel ;
   private String AV111Encuestawwds_24_tfpacientenombres ;
   private String AV112Encuestawwds_25_tfpacientenombres_sel ;
   private String AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV121Encuestawwds_34_tfencuestacomentarios ;
   private String AV122Encuestawwds_35_tfencuestacomentarios_sel ;
   private String lV88Encuestawwds_1_filterfulltext ;
   private String lV95Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String lV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV107Encuestawwds_20_tfpacienteapellidopaterno ;
   private String lV109Encuestawwds_22_tfpacienteapellidomaterno ;
   private String lV111Encuestawwds_24_tfpacientenombres ;
   private String lV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String lV121Encuestawwds_34_tfencuestacomentarios ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV64TFEncuestaAtencion_Sels ;
   private GXSimpleCollection<String> AV67TFEncuestaAtendido_Sels ;
   private GXSimpleCollection<String> AV76TFEncuestaEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P004N2_A72SGCitaDisponibilidadSedeId ;
   private byte[] P004N2_A152EncuestaRecomendacion ;
   private java.util.Date[] P004N2_A150EncuestaHoraAtencion ;
   private boolean[] P004N2_n150EncuestaHoraAtencion ;
   private short[] P004N2_A76SGCitaDisponibilidadClinicaId ;
   private int[] P004N2_A20PacienteId ;
   private java.util.Date[] P004N2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P004N2_n66SGCitaDisponibilidadFecha ;
   private int[] P004N2_A21SGCitaDisponibilidadId ;
   private short[] P004N2_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P004N2_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P004N2_A19CitaId ;
   private short[] P004N2_A37EncuestaId ;
   private String[] P004N2_A153EncuestaEstado ;
   private boolean[] P004N2_n153EncuestaEstado ;
   private String[] P004N2_A151EncuestaComentarios ;
   private boolean[] P004N2_n151EncuestaComentarios ;
   private String[] P004N2_A149EncuestaAtendido ;
   private boolean[] P004N2_n149EncuestaAtendido ;
   private String[] P004N2_A148EncuestaAtencion ;
   private boolean[] P004N2_n148EncuestaAtencion ;
   private String[] P004N2_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P004N2_A105PacienteNombres ;
   private String[] P004N2_A104PacienteApellidoMaterno ;
   private String[] P004N2_A103PacienteApellidoPaterno ;
   private String[] P004N2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P004N2_A82SGCitaDisponibilidadProFullName ;
   private String[] P004N2_A84ProfesionalNombres ;
   private boolean[] P004N2_n84ProfesionalNombres ;
   private String[] P004N2_A85ProfesionalApellidoPaterno ;
   private boolean[] P004N2_n85ProfesionalApellidoPaterno ;
   private String[] P004N2_A86ProfesionalApellidoMaterno ;
   private boolean[] P004N2_n86ProfesionalApellidoMaterno ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV117Encuestawwds_30_tfencuestaatencion_sels ;
   private GXSimpleCollection<String> AV118Encuestawwds_31_tfencuestaatendido_sels ;
   private GXSimpleCollection<String> AV125Encuestawwds_38_tfencuestaestado_sels ;
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

final  class encuestawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004N2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV117Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV118Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV125Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV89Encuestawwds_2_tfencuestaid ,
                                          short AV90Encuestawwds_3_tfencuestaid_to ,
                                          int AV91Encuestawwds_4_tfcitaid ,
                                          int AV92Encuestawwds_5_tfcitaid_to ,
                                          int AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV101Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV102Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV103Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV105Encuestawwds_18_tfpacienteid ,
                                          int AV106Encuestawwds_19_tfpacienteid_to ,
                                          String AV108Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV107Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV110Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV109Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV112Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV111Encuestawwds_24_tfpacientenombres ,
                                          short AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV117Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV118Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV119Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV120Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV122Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV121Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV123Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV124Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV125Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV88Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[57];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId," ;
      scmdbuf += " T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId," ;
      scmdbuf += " T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado], T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion]," ;
      scmdbuf += " T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres], T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno]," ;
      scmdbuf += " '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno] FROM ((((((([Encuesta] T1 INNER" ;
      scmdbuf += " JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId]" ;
      scmdbuf += " = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV89Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int11[23] = (byte)(1) ;
      }
      if ( ! (0==AV90Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int11[24] = (byte)(1) ;
      }
      if ( ! (0==AV91Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int11[25] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int11[26] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int11[27] = (byte)(1) ;
      }
      if ( ! (0==AV94Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int11[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV95Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[30] = (byte)(1) ;
      }
      if ( ! (0==AV97Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ! (0==AV98Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int11[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV99Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int11[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (0==AV102Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV103Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV104Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( ! (0==AV105Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! (0==AV106Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV107Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV109Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV111Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ! (0==AV113Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int11[47] = (byte)(1) ;
      }
      if ( ! (0==AV114Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int11[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV115Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int11[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int11[50] = (byte)(1) ;
      }
      if ( AV117Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV118Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV118Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV119Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int11[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV120Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int11[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV122Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV121Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int11[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV122Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int11[54] = (byte)(1) ;
      }
      if ( ! (0==AV123Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int11[55] = (byte)(1) ;
      }
      if ( ! (0==AV124Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int11[56] = (byte)(1) ;
      }
      if ( AV125Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV125Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtencion]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtencion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[ProfesionalId]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[ProfesionalId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[EspecialidadId]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[EspecialidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T7.[EspecialidadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T7.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SGCitaDisponibilidadId]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SGCitaDisponibilidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[DisponibilidadFecha]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PacienteId]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PacienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PacienteNombres]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PacienteNombres] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[ClinicaId]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[ClinicaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtendido]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaAtendido] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaHoraAtencion]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaHoraAtencion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaComentarios]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaComentarios] DESC" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaRecomendacion]" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaRecomendacion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[EncuestaEstado]" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[EncuestaEstado] DESC" ;
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
                  return conditional_P004N2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , ((Number) dynConstraints[62]).shortValue() , ((Boolean) dynConstraints[63]).booleanValue() , (String)dynConstraints[64] , (String)dynConstraints[65] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004N2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((short[]) buf[9])[0] = rslt.getShort(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((String[]) buf[13])[0] = rslt.getString(12, 1);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
      }
   }

}

