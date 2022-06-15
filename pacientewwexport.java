package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pacientewwexport extends GXProcedure
{
   public pacientewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacientewwexport.class ), "" );
   }

   public pacientewwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      pacientewwexport.this.aP1 = new String[] {""};
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
      pacientewwexport.this.aP0 = aP0;
      pacientewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      pacientewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV90Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PacienteWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFPacienteId) && (0==AV36TFPacienteId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPacienteId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPacienteId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFPacienteApellidoPaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Paterno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFPacienteApellidoPaterno_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFPacienteApellidoPaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Paterno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFPacienteApellidoPaterno, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFPacienteApellidoMaterno_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Materno") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPacienteApellidoMaterno_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFPacienteApellidoMaterno)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Apellido Materno") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFPacienteApellidoMaterno, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFPacienteNombres_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPacienteNombres_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFPacienteNombres)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFPacienteNombres, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV44TFPacienteNombreCompleto_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Completo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFPacienteNombreCompleto_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFPacienteNombreCompleto)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Completo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFPacienteNombreCompleto, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV45TFPacienteFechaNacimiento)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFPacienteFechaNacimiento_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Fecha Nacimiento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV45TFPacienteFechaNacimiento );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV46TFPacienteFechaNacimiento_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV48TFPacienteTipoDocumento_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV85i = 1 ;
         AV91GXV1 = 1 ;
         while ( AV91GXV1 <= AV48TFPacienteTipoDocumento_Sels.size() )
         {
            AV49TFPacienteTipoDocumento_Sel = (String)AV48TFPacienteTipoDocumento_Sels.elementAt(-1+AV91GXV1) ;
            if ( AV85i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV49TFPacienteTipoDocumento_Sel) );
            AV85i = (long)(AV85i+1) ;
            AV91GXV1 = (int)(AV91GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV51TFPacienteNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFPacienteNroDocumento_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFPacienteNroDocumento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFPacienteNroDocumento, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV53TFPacienteDireccion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFPacienteDireccion_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFPacienteDireccion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFPacienteDireccion, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV58TFPacienteSexo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sexo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV85i = 1 ;
         AV92GXV2 = 1 ;
         while ( AV92GXV2 <= AV58TFPacienteSexo_Sels.size() )
         {
            AV59TFPacienteSexo_Sel = (String)AV58TFPacienteSexo_Sels.elementAt(-1+AV92GXV2) ;
            if ( AV85i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainsexo.getDescription(httpContext,(String)AV59TFPacienteSexo_Sel) );
            AV85i = (long)(AV85i+1) ;
            AV92GXV2 = (int)(AV92GXV2+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV61TFPacienteCorreo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFPacienteCorreo_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV60TFPacienteCorreo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFPacienteCorreo, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV63TFPacienteTelefono_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Telefono") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV63TFPacienteTelefono_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV62TFPacienteTelefono)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Telefono") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV62TFPacienteTelefono, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV64TFPaisId) && (0==AV65TFPaisId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pais Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV64TFPaisId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV65TFPaisId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV67TFPaisDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pais Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV67TFPaisDescripcion_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV66TFPaisDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pais Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV66TFPaisDescripcion, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV69TFPacienteEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV85i = 1 ;
         AV93GXV3 = 1 ;
         while ( AV93GXV3 <= AV69TFPacienteEstado_Sels.size() )
         {
            AV70TFPacienteEstado_Sel = (String)AV69TFPacienteEstado_Sels.elementAt(-1+AV93GXV3) ;
            if ( AV85i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestadopaciente.getDescription(httpContext,(String)AV70TFPacienteEstado_Sel) );
            AV85i = (long)(AV85i+1) ;
            AV93GXV3 = (int)(AV93GXV3+1) ;
         }
      }
      if ( ! ( (0==AV71TFSecUserId) && (0==AV72TFSecUserId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "User Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV71TFSecUserId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV72TFSecUserId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV74TFUbigeoCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV74TFUbigeoCode_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV73TFUbigeoCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV73TFUbigeoCode, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV76TFUbigeoNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV76TFUbigeoNombre_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV75TFUbigeoNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV75TFUbigeoNombre, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77TFPacienteEstatura)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78TFPacienteEstatura_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estatura") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV77TFPacienteEstatura)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV78TFPacienteEstatura_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79TFPacientePeso)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFPacientePeso_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Peso") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV79TFPacientePeso)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV80TFPacientePeso_To)) );
      }
      if ( ! ( (GXutil.strcmp("", AV82TFPacienteNombreAnexo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Anexo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV82TFPacienteNombreAnexo_Sel, GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV81TFPacienteNombreAnexo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Anexo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV81TFPacienteNombreAnexo, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV55TFPacienteEnterarse_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Enterarse") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV85i = 1 ;
         AV94GXV4 = 1 ;
         while ( AV94GXV4 <= AV55TFPacienteEnterarse_Sels.size() )
         {
            AV56TFPacienteEnterarse_Sel = (String)AV55TFPacienteEnterarse_Sels.elementAt(-1+AV94GXV4) ;
            if ( AV85i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainorigenpaciente.getDescription(httpContext,(String)AV56TFPacienteEnterarse_Sel) );
            AV85i = (long)(AV85i+1) ;
            AV94GXV4 = (int)(AV94GXV4+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV87TFPacienteEspecifique_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especifique") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV87TFPacienteEspecifique_Sel, 1, 1000), GXv_char7) ;
         pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV86TFPacienteEspecifique)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Especifique") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV86TFPacienteEspecifique, 1, 1000), GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV83TFPacienteFechaRegistro) && GXutil.dateCompare(GXutil.nullDate(), AV84TFPacienteFechaRegistro_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Fecha Registro") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( AV83TFPacienteFechaRegistro );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pacientewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( AV84TFPacienteFechaRegistro_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PacienteWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PacienteWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV95GXV5 = 1 ;
      while ( AV95GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV95GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV95GXV5 = (int)(AV95GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV97Pacientewwds_1_filterfulltext = AV19FilterFullText ;
      AV98Pacientewwds_2_tfpacienteid = AV35TFPacienteId ;
      AV99Pacientewwds_3_tfpacienteid_to = AV36TFPacienteId_To ;
      AV100Pacientewwds_4_tfpacienteapellidopaterno = AV37TFPacienteApellidoPaterno ;
      AV101Pacientewwds_5_tfpacienteapellidopaterno_sel = AV38TFPacienteApellidoPaterno_Sel ;
      AV102Pacientewwds_6_tfpacienteapellidomaterno = AV39TFPacienteApellidoMaterno ;
      AV103Pacientewwds_7_tfpacienteapellidomaterno_sel = AV40TFPacienteApellidoMaterno_Sel ;
      AV104Pacientewwds_8_tfpacientenombres = AV41TFPacienteNombres ;
      AV105Pacientewwds_9_tfpacientenombres_sel = AV42TFPacienteNombres_Sel ;
      AV106Pacientewwds_10_tfpacientenombrecompleto = AV43TFPacienteNombreCompleto ;
      AV107Pacientewwds_11_tfpacientenombrecompleto_sel = AV44TFPacienteNombreCompleto_Sel ;
      AV108Pacientewwds_12_tfpacientefechanacimiento = AV45TFPacienteFechaNacimiento ;
      AV109Pacientewwds_13_tfpacientefechanacimiento_to = AV46TFPacienteFechaNacimiento_To ;
      AV110Pacientewwds_14_tfpacientetipodocumento_sels = AV48TFPacienteTipoDocumento_Sels ;
      AV111Pacientewwds_15_tfpacientenrodocumento = AV50TFPacienteNroDocumento ;
      AV112Pacientewwds_16_tfpacientenrodocumento_sel = AV51TFPacienteNroDocumento_Sel ;
      AV113Pacientewwds_17_tfpacientedireccion = AV52TFPacienteDireccion ;
      AV114Pacientewwds_18_tfpacientedireccion_sel = AV53TFPacienteDireccion_Sel ;
      AV115Pacientewwds_19_tfpacientesexo_sels = AV58TFPacienteSexo_Sels ;
      AV116Pacientewwds_20_tfpacientecorreo = AV60TFPacienteCorreo ;
      AV117Pacientewwds_21_tfpacientecorreo_sel = AV61TFPacienteCorreo_Sel ;
      AV118Pacientewwds_22_tfpacientetelefono = AV62TFPacienteTelefono ;
      AV119Pacientewwds_23_tfpacientetelefono_sel = AV63TFPacienteTelefono_Sel ;
      AV120Pacientewwds_24_tfpaisid = AV64TFPaisId ;
      AV121Pacientewwds_25_tfpaisid_to = AV65TFPaisId_To ;
      AV122Pacientewwds_26_tfpaisdescripcion = AV66TFPaisDescripcion ;
      AV123Pacientewwds_27_tfpaisdescripcion_sel = AV67TFPaisDescripcion_Sel ;
      AV124Pacientewwds_28_tfpacienteestado_sels = AV69TFPacienteEstado_Sels ;
      AV125Pacientewwds_29_tfsecuserid = AV71TFSecUserId ;
      AV126Pacientewwds_30_tfsecuserid_to = AV72TFSecUserId_To ;
      AV127Pacientewwds_31_tfubigeocode = AV73TFUbigeoCode ;
      AV128Pacientewwds_32_tfubigeocode_sel = AV74TFUbigeoCode_Sel ;
      AV129Pacientewwds_33_tfubigeonombre = AV75TFUbigeoNombre ;
      AV130Pacientewwds_34_tfubigeonombre_sel = AV76TFUbigeoNombre_Sel ;
      AV131Pacientewwds_35_tfpacienteestatura = AV77TFPacienteEstatura ;
      AV132Pacientewwds_36_tfpacienteestatura_to = AV78TFPacienteEstatura_To ;
      AV133Pacientewwds_37_tfpacientepeso = AV79TFPacientePeso ;
      AV134Pacientewwds_38_tfpacientepeso_to = AV80TFPacientePeso_To ;
      AV135Pacientewwds_39_tfpacientenombreanexo = AV81TFPacienteNombreAnexo ;
      AV136Pacientewwds_40_tfpacientenombreanexo_sel = AV82TFPacienteNombreAnexo_Sel ;
      AV137Pacientewwds_41_tfpacienteenterarse_sels = AV55TFPacienteEnterarse_Sels ;
      AV138Pacientewwds_42_tfpacienteespecifique = AV86TFPacienteEspecifique ;
      AV139Pacientewwds_43_tfpacienteespecifique_sel = AV87TFPacienteEspecifique_Sel ;
      AV140Pacientewwds_44_tfpacientefecharegistro = AV83TFPacienteFechaRegistro ;
      AV141Pacientewwds_45_tfpacientefecharegistro_to = AV84TFPacienteFechaRegistro_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV110Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV115Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV124Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV137Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV97Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV98Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV99Pacientewwds_3_tfpacienteid_to) ,
                                           AV101Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV100Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV103Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV102Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV105Pacientewwds_9_tfpacientenombres_sel ,
                                           AV104Pacientewwds_8_tfpacientenombres ,
                                           AV107Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV106Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV108Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV109Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV110Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV112Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV111Pacientewwds_15_tfpacientenrodocumento ,
                                           AV114Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV113Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV115Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV117Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV116Pacientewwds_20_tfpacientecorreo ,
                                           AV119Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV118Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV120Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV121Pacientewwds_25_tfpaisid_to) ,
                                           AV123Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV122Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV124Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV125Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV126Pacientewwds_30_tfsecuserid_to) ,
                                           AV128Pacientewwds_32_tfubigeocode_sel ,
                                           AV127Pacientewwds_31_tfubigeocode ,
                                           AV130Pacientewwds_34_tfubigeonombre_sel ,
                                           AV129Pacientewwds_33_tfubigeonombre ,
                                           AV131Pacientewwds_35_tfpacienteestatura ,
                                           AV132Pacientewwds_36_tfpacienteestatura_to ,
                                           AV133Pacientewwds_37_tfpacientepeso ,
                                           AV134Pacientewwds_38_tfpacientepeso_to ,
                                           AV136Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV135Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV137Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV139Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV138Pacientewwds_42_tfpacienteespecifique ,
                                           AV140Pacientewwds_44_tfpacientefecharegistro ,
                                           AV141Pacientewwds_45_tfpacientefecharegistro_to ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A106PacienteNroDocumento ,
                                           A215PacienteDireccion ,
                                           A217PacienteCorreo ,
                                           A218PacienteTelefono ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion ,
                                           Short.valueOf(A6SecUserId) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A220PacienteEstatura ,
                                           A221PacientePeso ,
                                           A222PacienteNombreAnexo ,
                                           A225PacienteEspecifique ,
                                           A213PacienteFechaNacimiento ,
                                           A226PacienteFechaRegistro ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV97Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV97Pacientewwds_1_filterfulltext), "%", "") ;
      lV100Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV100Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV102Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV102Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV104Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV104Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV106Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV106Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV111Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV111Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV113Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV113Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV116Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV116Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV118Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV118Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV122Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV122Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV127Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV127Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV129Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV129Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV135Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV135Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV138Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV138Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P007Q2 */
      pr_default.execute(0, new Object[] {lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, lV97Pacientewwds_1_filterfulltext, Integer.valueOf(AV98Pacientewwds_2_tfpacienteid), Integer.valueOf(AV99Pacientewwds_3_tfpacienteid_to), lV100Pacientewwds_4_tfpacienteapellidopaterno, AV101Pacientewwds_5_tfpacienteapellidopaterno_sel, lV102Pacientewwds_6_tfpacienteapellidomaterno, AV103Pacientewwds_7_tfpacienteapellidomaterno_sel, lV104Pacientewwds_8_tfpacientenombres, AV105Pacientewwds_9_tfpacientenombres_sel, lV106Pacientewwds_10_tfpacientenombrecompleto, AV107Pacientewwds_11_tfpacientenombrecompleto_sel, AV108Pacientewwds_12_tfpacientefechanacimiento, AV109Pacientewwds_13_tfpacientefechanacimiento_to, lV111Pacientewwds_15_tfpacientenrodocumento, AV112Pacientewwds_16_tfpacientenrodocumento_sel, lV113Pacientewwds_17_tfpacientedireccion, AV114Pacientewwds_18_tfpacientedireccion_sel, lV116Pacientewwds_20_tfpacientecorreo, AV117Pacientewwds_21_tfpacientecorreo_sel, lV118Pacientewwds_22_tfpacientetelefono, AV119Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV120Pacientewwds_24_tfpaisid), Short.valueOf(AV121Pacientewwds_25_tfpaisid_to), lV122Pacientewwds_26_tfpaisdescripcion, AV123Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV125Pacientewwds_29_tfsecuserid), Short.valueOf(AV126Pacientewwds_30_tfsecuserid_to), lV127Pacientewwds_31_tfubigeocode, AV128Pacientewwds_32_tfubigeocode_sel, lV129Pacientewwds_33_tfubigeonombre, AV130Pacientewwds_34_tfubigeonombre_sel, AV131Pacientewwds_35_tfpacienteestatura, AV132Pacientewwds_36_tfpacienteestatura_to, AV133Pacientewwds_37_tfpacientepeso, AV134Pacientewwds_38_tfpacientepeso_to, lV135Pacientewwds_39_tfpacientenombreanexo, AV136Pacientewwds_40_tfpacientenombreanexo_sel, lV138Pacientewwds_42_tfpacienteespecifique, AV139Pacientewwds_43_tfpacienteespecifique_sel, AV140Pacientewwds_44_tfpacientefecharegistro, AV141Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A226PacienteFechaRegistro = P007Q2_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P007Q2_A221PacientePeso[0] ;
         A220PacienteEstatura = P007Q2_A220PacienteEstatura[0] ;
         A6SecUserId = P007Q2_A6SecUserId[0] ;
         n6SecUserId = P007Q2_n6SecUserId[0] ;
         A43PaisId = P007Q2_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P007Q2_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P007Q2_A20PacienteId[0] ;
         A225PacienteEspecifique = P007Q2_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P007Q2_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P007Q2_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P007Q2_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P007Q2_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P007Q2_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P007Q2_A44UbigeoCode[0] ;
         n44UbigeoCode = P007Q2_n44UbigeoCode[0] ;
         A219PacienteEstado = P007Q2_A219PacienteEstado[0] ;
         A184PaisDescripcion = P007Q2_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P007Q2_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P007Q2_A217PacienteCorreo[0] ;
         A216PacienteSexo = P007Q2_A216PacienteSexo[0] ;
         A215PacienteDireccion = P007Q2_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P007Q2_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P007Q2_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P007Q2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P007Q2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P007Q2_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P007Q2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007Q2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007Q2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P007Q2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P007Q2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P007Q2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P007Q2_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A20PacienteId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A103PacienteApellidoPaterno, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A104PacienteApellidoMaterno, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A105PacienteNombres, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A212PacienteNombreCompleto, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A213PacienteFechaNacimiento );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A214PacienteTipoDocumento) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A106PacienteNroDocumento, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A215PacienteDireccion, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainsexo.getDescription(httpContext,(String)A216PacienteSexo) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A217PacienteCorreo, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A218PacienteTelefono, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A43PaisId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A184PaisDescripcion, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestadopaciente.getDescription(httpContext,(String)A219PacienteEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A6SecUserId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A44UbigeoCode, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A185UbigeoNombre, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A220PacienteEstatura)) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A221PacientePeso)) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A222PacienteNombreAnexo, GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainorigenpaciente.getDescription(httpContext,(String)A224PacienteEnterarse) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A225PacienteEspecifique, 1, 1000), GXv_char7) ;
            pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( A226PacienteFechaRegistro );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoPaterno", "", "Apellido Paterno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteApellidoMaterno", "", "Apellido Materno", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombres", "", "Nombres", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombreCompleto", "", "Nombre Completo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteFechaNacimiento", "", "Fecha Nacimiento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteTipoDocumento", "", "Tipo Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNroDocumento", "", "Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteDireccion", "", "Direccion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteSexo", "", "Sexo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteCorreo", "", "Correo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteTelefono", "", "Telefono", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisId", "", "Pais Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PaisDescripcion", "", "Pais Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SecUserId", "", "User Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEstatura", "", "Estatura", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacientePeso", "", "Peso", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteNombreAnexo", "", "Nombre Anexo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteAnexos", "", "Anexos", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEnterarse", "", "Enterarse", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteEspecifique", "", "Especifique", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PacienteFechaRegistro", "", "Fecha Registro", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PacienteWWColumnsSelector", GXv_char7) ;
      pacientewwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("PacienteWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PacienteWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PacienteWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV142GXV6 = 1 ;
      while ( AV142GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV142GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV35TFPacienteId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPacienteId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV37TFPacienteApellidoPaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV38TFPacienteApellidoPaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV39TFPacienteApellidoMaterno = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV40TFPacienteApellidoMaterno_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV41TFPacienteNombres = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV42TFPacienteNombres_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO") == 0 )
         {
            AV43TFPacienteNombreCompleto = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO_SEL") == 0 )
         {
            AV44TFPacienteNombreCompleto_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHANACIMIENTO") == 0 )
         {
            AV45TFPacienteFechaNacimiento = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV46TFPacienteFechaNacimiento_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETIPODOCUMENTO_SEL") == 0 )
         {
            AV47TFPacienteTipoDocumento_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPacienteTipoDocumento_Sels.fromJSonString(AV47TFPacienteTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV50TFPacienteNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV51TFPacienteNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION") == 0 )
         {
            AV52TFPacienteDireccion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION_SEL") == 0 )
         {
            AV53TFPacienteDireccion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTESEXO_SEL") == 0 )
         {
            AV57TFPacienteSexo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFPacienteSexo_Sels.fromJSonString(AV57TFPacienteSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO") == 0 )
         {
            AV60TFPacienteCorreo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO_SEL") == 0 )
         {
            AV61TFPacienteCorreo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO") == 0 )
         {
            AV62TFPacienteTelefono = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO_SEL") == 0 )
         {
            AV63TFPacienteTelefono_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV64TFPaisId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV65TFPaisId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV66TFPaisDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV67TFPaisDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTADO_SEL") == 0 )
         {
            AV68TFPacienteEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV69TFPacienteEstado_Sels.fromJSonString(AV68TFPacienteEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV71TFSecUserId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV72TFSecUserId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV73TFUbigeoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV74TFUbigeoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV75TFUbigeoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV76TFUbigeoNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTATURA") == 0 )
         {
            AV77TFPacienteEstatura = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV78TFPacienteEstatura_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEPESO") == 0 )
         {
            AV79TFPacientePeso = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV80TFPacientePeso_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO") == 0 )
         {
            AV81TFPacienteNombreAnexo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO_SEL") == 0 )
         {
            AV82TFPacienteNombreAnexo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEENTERARSE_SEL") == 0 )
         {
            AV54TFPacienteEnterarse_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFPacienteEnterarse_Sels.fromJSonString(AV54TFPacienteEnterarse_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE") == 0 )
         {
            AV86TFPacienteEspecifique = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE_SEL") == 0 )
         {
            AV87TFPacienteEspecifique_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHAREGISTRO") == 0 )
         {
            AV83TFPacienteFechaRegistro = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV84TFPacienteFechaRegistro_To = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         AV142GXV6 = (int)(AV142GXV6+1) ;
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
      this.aP0[0] = pacientewwexport.this.AV12Filename;
      this.aP1[0] = pacientewwexport.this.AV13ErrorMessage;
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
      AV90Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFPacienteApellidoPaterno_Sel = "" ;
      AV37TFPacienteApellidoPaterno = "" ;
      AV40TFPacienteApellidoMaterno_Sel = "" ;
      AV39TFPacienteApellidoMaterno = "" ;
      AV42TFPacienteNombres_Sel = "" ;
      AV41TFPacienteNombres = "" ;
      AV44TFPacienteNombreCompleto_Sel = "" ;
      AV43TFPacienteNombreCompleto = "" ;
      AV45TFPacienteFechaNacimiento = GXutil.nullDate() ;
      AV46TFPacienteFechaNacimiento_To = GXutil.nullDate() ;
      AV48TFPacienteTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFPacienteTipoDocumento_Sel = "" ;
      AV51TFPacienteNroDocumento_Sel = "" ;
      AV50TFPacienteNroDocumento = "" ;
      AV53TFPacienteDireccion_Sel = "" ;
      AV52TFPacienteDireccion = "" ;
      AV58TFPacienteSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFPacienteSexo_Sel = "" ;
      AV61TFPacienteCorreo_Sel = "" ;
      AV60TFPacienteCorreo = "" ;
      AV63TFPacienteTelefono_Sel = "" ;
      AV62TFPacienteTelefono = "" ;
      AV67TFPaisDescripcion_Sel = "" ;
      AV66TFPaisDescripcion = "" ;
      AV69TFPacienteEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70TFPacienteEstado_Sel = "" ;
      AV74TFUbigeoCode_Sel = "" ;
      AV73TFUbigeoCode = "" ;
      AV76TFUbigeoNombre_Sel = "" ;
      AV75TFUbigeoNombre = "" ;
      AV77TFPacienteEstatura = DecimalUtil.ZERO ;
      AV78TFPacienteEstatura_To = DecimalUtil.ZERO ;
      AV79TFPacientePeso = DecimalUtil.ZERO ;
      AV80TFPacientePeso_To = DecimalUtil.ZERO ;
      AV82TFPacienteNombreAnexo_Sel = "" ;
      AV81TFPacienteNombreAnexo = "" ;
      AV55TFPacienteEnterarse_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFPacienteEnterarse_Sel = "" ;
      AV87TFPacienteEspecifique_Sel = "" ;
      AV86TFPacienteEspecifique = "" ;
      AV83TFPacienteFechaRegistro = GXutil.now( ) ;
      AV84TFPacienteFechaRegistro_To = GXutil.now( ) ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A212PacienteNombreCompleto = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A216PacienteSexo = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A184PaisDescripcion = "" ;
      A219PacienteEstado = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      A224PacienteEnterarse = "" ;
      A225PacienteEspecifique = "" ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      AV97Pacientewwds_1_filterfulltext = "" ;
      AV100Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      AV101Pacientewwds_5_tfpacienteapellidopaterno_sel = "" ;
      AV102Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      AV103Pacientewwds_7_tfpacienteapellidomaterno_sel = "" ;
      AV104Pacientewwds_8_tfpacientenombres = "" ;
      AV105Pacientewwds_9_tfpacientenombres_sel = "" ;
      AV106Pacientewwds_10_tfpacientenombrecompleto = "" ;
      AV107Pacientewwds_11_tfpacientenombrecompleto_sel = "" ;
      AV108Pacientewwds_12_tfpacientefechanacimiento = GXutil.nullDate() ;
      AV109Pacientewwds_13_tfpacientefechanacimiento_to = GXutil.nullDate() ;
      AV110Pacientewwds_14_tfpacientetipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV111Pacientewwds_15_tfpacientenrodocumento = "" ;
      AV112Pacientewwds_16_tfpacientenrodocumento_sel = "" ;
      AV113Pacientewwds_17_tfpacientedireccion = "" ;
      AV114Pacientewwds_18_tfpacientedireccion_sel = "" ;
      AV115Pacientewwds_19_tfpacientesexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV116Pacientewwds_20_tfpacientecorreo = "" ;
      AV117Pacientewwds_21_tfpacientecorreo_sel = "" ;
      AV118Pacientewwds_22_tfpacientetelefono = "" ;
      AV119Pacientewwds_23_tfpacientetelefono_sel = "" ;
      AV122Pacientewwds_26_tfpaisdescripcion = "" ;
      AV123Pacientewwds_27_tfpaisdescripcion_sel = "" ;
      AV124Pacientewwds_28_tfpacienteestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV127Pacientewwds_31_tfubigeocode = "" ;
      AV128Pacientewwds_32_tfubigeocode_sel = "" ;
      AV129Pacientewwds_33_tfubigeonombre = "" ;
      AV130Pacientewwds_34_tfubigeonombre_sel = "" ;
      AV131Pacientewwds_35_tfpacienteestatura = DecimalUtil.ZERO ;
      AV132Pacientewwds_36_tfpacienteestatura_to = DecimalUtil.ZERO ;
      AV133Pacientewwds_37_tfpacientepeso = DecimalUtil.ZERO ;
      AV134Pacientewwds_38_tfpacientepeso_to = DecimalUtil.ZERO ;
      AV135Pacientewwds_39_tfpacientenombreanexo = "" ;
      AV136Pacientewwds_40_tfpacientenombreanexo_sel = "" ;
      AV137Pacientewwds_41_tfpacienteenterarse_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV138Pacientewwds_42_tfpacienteespecifique = "" ;
      AV139Pacientewwds_43_tfpacienteespecifique_sel = "" ;
      AV140Pacientewwds_44_tfpacientefecharegistro = GXutil.resetTime( GXutil.nullDate() );
      AV141Pacientewwds_45_tfpacientefecharegistro_to = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV97Pacientewwds_1_filterfulltext = "" ;
      lV100Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      lV102Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      lV104Pacientewwds_8_tfpacientenombres = "" ;
      lV106Pacientewwds_10_tfpacientenombrecompleto = "" ;
      lV111Pacientewwds_15_tfpacientenrodocumento = "" ;
      lV113Pacientewwds_17_tfpacientedireccion = "" ;
      lV116Pacientewwds_20_tfpacientecorreo = "" ;
      lV118Pacientewwds_22_tfpacientetelefono = "" ;
      lV122Pacientewwds_26_tfpaisdescripcion = "" ;
      lV127Pacientewwds_31_tfubigeocode = "" ;
      lV129Pacientewwds_33_tfubigeonombre = "" ;
      lV135Pacientewwds_39_tfpacientenombreanexo = "" ;
      lV138Pacientewwds_42_tfpacienteespecifique = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P007Q2_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P007Q2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007Q2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007Q2_A6SecUserId = new short[1] ;
      P007Q2_n6SecUserId = new boolean[] {false} ;
      P007Q2_A43PaisId = new short[1] ;
      P007Q2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P007Q2_A20PacienteId = new int[1] ;
      P007Q2_A225PacienteEspecifique = new String[] {""} ;
      P007Q2_n225PacienteEspecifique = new boolean[] {false} ;
      P007Q2_A224PacienteEnterarse = new String[] {""} ;
      P007Q2_n224PacienteEnterarse = new boolean[] {false} ;
      P007Q2_A222PacienteNombreAnexo = new String[] {""} ;
      P007Q2_n222PacienteNombreAnexo = new boolean[] {false} ;
      P007Q2_A44UbigeoCode = new String[] {""} ;
      P007Q2_n44UbigeoCode = new boolean[] {false} ;
      P007Q2_A219PacienteEstado = new String[] {""} ;
      P007Q2_A184PaisDescripcion = new String[] {""} ;
      P007Q2_A218PacienteTelefono = new String[] {""} ;
      P007Q2_A217PacienteCorreo = new String[] {""} ;
      P007Q2_A216PacienteSexo = new String[] {""} ;
      P007Q2_A215PacienteDireccion = new String[] {""} ;
      P007Q2_A106PacienteNroDocumento = new String[] {""} ;
      P007Q2_A214PacienteTipoDocumento = new String[] {""} ;
      P007Q2_A105PacienteNombres = new String[] {""} ;
      P007Q2_A104PacienteApellidoMaterno = new String[] {""} ;
      P007Q2_A103PacienteApellidoPaterno = new String[] {""} ;
      P007Q2_A188UbigeoDistrito = new String[] {""} ;
      P007Q2_A187UbigeoProvincia = new String[] {""} ;
      P007Q2_A186UbigeoDepartamento = new String[] {""} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47TFPacienteTipoDocumento_SelsJson = "" ;
      AV57TFPacienteSexo_SelsJson = "" ;
      AV68TFPacienteEstado_SelsJson = "" ;
      AV54TFPacienteEnterarse_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientewwexport__default(),
         new Object[] {
             new Object[] {
            P007Q2_A226PacienteFechaRegistro, P007Q2_A221PacientePeso, P007Q2_A220PacienteEstatura, P007Q2_A6SecUserId, P007Q2_n6SecUserId, P007Q2_A43PaisId, P007Q2_A213PacienteFechaNacimiento, P007Q2_A20PacienteId, P007Q2_A225PacienteEspecifique, P007Q2_n225PacienteEspecifique,
            P007Q2_A224PacienteEnterarse, P007Q2_n224PacienteEnterarse, P007Q2_A222PacienteNombreAnexo, P007Q2_n222PacienteNombreAnexo, P007Q2_A44UbigeoCode, P007Q2_n44UbigeoCode, P007Q2_A219PacienteEstado, P007Q2_A184PaisDescripcion, P007Q2_A218PacienteTelefono, P007Q2_A217PacienteCorreo,
            P007Q2_A216PacienteSexo, P007Q2_A215PacienteDireccion, P007Q2_A106PacienteNroDocumento, P007Q2_A214PacienteTipoDocumento, P007Q2_A105PacienteNombres, P007Q2_A104PacienteApellidoMaterno, P007Q2_A103PacienteApellidoPaterno, P007Q2_A188UbigeoDistrito, P007Q2_A187UbigeoProvincia, P007Q2_A186UbigeoDepartamento
            }
         }
      );
      AV90Pgmname = "PacienteWWExport" ;
      /* GeneXus formulas. */
      AV90Pgmname = "PacienteWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV64TFPaisId ;
   private short AV65TFPaisId_To ;
   private short AV71TFSecUserId ;
   private short AV72TFSecUserId_To ;
   private short GXv_int5[] ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short AV120Pacientewwds_24_tfpaisid ;
   private short AV121Pacientewwds_25_tfpaisid_to ;
   private short AV125Pacientewwds_29_tfsecuserid ;
   private short AV126Pacientewwds_30_tfsecuserid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFPacienteId ;
   private int AV36TFPacienteId_To ;
   private int AV91GXV1 ;
   private int AV92GXV2 ;
   private int AV93GXV3 ;
   private int AV94GXV4 ;
   private int AV95GXV5 ;
   private int A20PacienteId ;
   private int AV98Pacientewwds_2_tfpacienteid ;
   private int AV99Pacientewwds_3_tfpacienteid_to ;
   private int AV110Pacientewwds_14_tfpacientetipodocumento_sels_size ;
   private int AV115Pacientewwds_19_tfpacientesexo_sels_size ;
   private int AV124Pacientewwds_28_tfpacienteestado_sels_size ;
   private int AV137Pacientewwds_41_tfpacienteenterarse_sels_size ;
   private int AV142GXV6 ;
   private long AV85i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV77TFPacienteEstatura ;
   private java.math.BigDecimal AV78TFPacienteEstatura_To ;
   private java.math.BigDecimal AV79TFPacientePeso ;
   private java.math.BigDecimal AV80TFPacientePeso_To ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private java.math.BigDecimal AV131Pacientewwds_35_tfpacienteestatura ;
   private java.math.BigDecimal AV132Pacientewwds_36_tfpacienteestatura_to ;
   private java.math.BigDecimal AV133Pacientewwds_37_tfpacientepeso ;
   private java.math.BigDecimal AV134Pacientewwds_38_tfpacientepeso_to ;
   private String AV90Pgmname ;
   private String AV49TFPacienteTipoDocumento_Sel ;
   private String AV59TFPacienteSexo_Sel ;
   private String AV63TFPacienteTelefono_Sel ;
   private String AV62TFPacienteTelefono ;
   private String AV70TFPacienteEstado_Sel ;
   private String AV74TFUbigeoCode_Sel ;
   private String AV73TFUbigeoCode ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A218PacienteTelefono ;
   private String A219PacienteEstado ;
   private String A44UbigeoCode ;
   private String AV118Pacientewwds_22_tfpacientetelefono ;
   private String AV119Pacientewwds_23_tfpacientetelefono_sel ;
   private String AV127Pacientewwds_31_tfubigeocode ;
   private String AV128Pacientewwds_32_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV118Pacientewwds_22_tfpacientetelefono ;
   private String lV127Pacientewwds_31_tfubigeocode ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV83TFPacienteFechaRegistro ;
   private java.util.Date AV84TFPacienteFechaRegistro_To ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date AV140Pacientewwds_44_tfpacientefecharegistro ;
   private java.util.Date AV141Pacientewwds_45_tfpacientefecharegistro_to ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV45TFPacienteFechaNacimiento ;
   private java.util.Date AV46TFPacienteFechaNacimiento_To ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private java.util.Date AV108Pacientewwds_12_tfpacientefechanacimiento ;
   private java.util.Date AV109Pacientewwds_13_tfpacientefechanacimiento_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n6SecUserId ;
   private boolean n225PacienteEspecifique ;
   private boolean n224PacienteEnterarse ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n44UbigeoCode ;
   private String AV27ColumnsSelectorXML ;
   private String A225PacienteEspecifique ;
   private String AV28UserCustomValue ;
   private String AV47TFPacienteTipoDocumento_SelsJson ;
   private String AV57TFPacienteSexo_SelsJson ;
   private String AV68TFPacienteEstado_SelsJson ;
   private String AV54TFPacienteEnterarse_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFPacienteApellidoPaterno_Sel ;
   private String AV37TFPacienteApellidoPaterno ;
   private String AV40TFPacienteApellidoMaterno_Sel ;
   private String AV39TFPacienteApellidoMaterno ;
   private String AV42TFPacienteNombres_Sel ;
   private String AV41TFPacienteNombres ;
   private String AV44TFPacienteNombreCompleto_Sel ;
   private String AV43TFPacienteNombreCompleto ;
   private String AV51TFPacienteNroDocumento_Sel ;
   private String AV50TFPacienteNroDocumento ;
   private String AV53TFPacienteDireccion_Sel ;
   private String AV52TFPacienteDireccion ;
   private String AV61TFPacienteCorreo_Sel ;
   private String AV60TFPacienteCorreo ;
   private String AV67TFPaisDescripcion_Sel ;
   private String AV66TFPaisDescripcion ;
   private String AV76TFUbigeoNombre_Sel ;
   private String AV75TFUbigeoNombre ;
   private String AV82TFPacienteNombreAnexo_Sel ;
   private String AV81TFPacienteNombreAnexo ;
   private String AV56TFPacienteEnterarse_Sel ;
   private String AV87TFPacienteEspecifique_Sel ;
   private String AV86TFPacienteEspecifique ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A212PacienteNombreCompleto ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A222PacienteNombreAnexo ;
   private String A224PacienteEnterarse ;
   private String AV97Pacientewwds_1_filterfulltext ;
   private String AV100Pacientewwds_4_tfpacienteapellidopaterno ;
   private String AV101Pacientewwds_5_tfpacienteapellidopaterno_sel ;
   private String AV102Pacientewwds_6_tfpacienteapellidomaterno ;
   private String AV103Pacientewwds_7_tfpacienteapellidomaterno_sel ;
   private String AV104Pacientewwds_8_tfpacientenombres ;
   private String AV105Pacientewwds_9_tfpacientenombres_sel ;
   private String AV106Pacientewwds_10_tfpacientenombrecompleto ;
   private String AV107Pacientewwds_11_tfpacientenombrecompleto_sel ;
   private String AV111Pacientewwds_15_tfpacientenrodocumento ;
   private String AV112Pacientewwds_16_tfpacientenrodocumento_sel ;
   private String AV113Pacientewwds_17_tfpacientedireccion ;
   private String AV114Pacientewwds_18_tfpacientedireccion_sel ;
   private String AV116Pacientewwds_20_tfpacientecorreo ;
   private String AV117Pacientewwds_21_tfpacientecorreo_sel ;
   private String AV122Pacientewwds_26_tfpaisdescripcion ;
   private String AV123Pacientewwds_27_tfpaisdescripcion_sel ;
   private String AV129Pacientewwds_33_tfubigeonombre ;
   private String AV130Pacientewwds_34_tfubigeonombre_sel ;
   private String AV135Pacientewwds_39_tfpacientenombreanexo ;
   private String AV136Pacientewwds_40_tfpacientenombreanexo_sel ;
   private String AV138Pacientewwds_42_tfpacienteespecifique ;
   private String AV139Pacientewwds_43_tfpacienteespecifique_sel ;
   private String lV97Pacientewwds_1_filterfulltext ;
   private String lV100Pacientewwds_4_tfpacienteapellidopaterno ;
   private String lV102Pacientewwds_6_tfpacienteapellidomaterno ;
   private String lV104Pacientewwds_8_tfpacientenombres ;
   private String lV106Pacientewwds_10_tfpacientenombrecompleto ;
   private String lV111Pacientewwds_15_tfpacientenrodocumento ;
   private String lV113Pacientewwds_17_tfpacientedireccion ;
   private String lV116Pacientewwds_20_tfpacientecorreo ;
   private String lV122Pacientewwds_26_tfpaisdescripcion ;
   private String lV129Pacientewwds_33_tfubigeonombre ;
   private String lV135Pacientewwds_39_tfpacientenombreanexo ;
   private String lV138Pacientewwds_42_tfpacienteespecifique ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV48TFPacienteTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV58TFPacienteSexo_Sels ;
   private GXSimpleCollection<String> AV69TFPacienteEstado_Sels ;
   private GXSimpleCollection<String> AV55TFPacienteEnterarse_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P007Q2_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P007Q2_A221PacientePeso ;
   private java.math.BigDecimal[] P007Q2_A220PacienteEstatura ;
   private short[] P007Q2_A6SecUserId ;
   private boolean[] P007Q2_n6SecUserId ;
   private short[] P007Q2_A43PaisId ;
   private java.util.Date[] P007Q2_A213PacienteFechaNacimiento ;
   private int[] P007Q2_A20PacienteId ;
   private String[] P007Q2_A225PacienteEspecifique ;
   private boolean[] P007Q2_n225PacienteEspecifique ;
   private String[] P007Q2_A224PacienteEnterarse ;
   private boolean[] P007Q2_n224PacienteEnterarse ;
   private String[] P007Q2_A222PacienteNombreAnexo ;
   private boolean[] P007Q2_n222PacienteNombreAnexo ;
   private String[] P007Q2_A44UbigeoCode ;
   private boolean[] P007Q2_n44UbigeoCode ;
   private String[] P007Q2_A219PacienteEstado ;
   private String[] P007Q2_A184PaisDescripcion ;
   private String[] P007Q2_A218PacienteTelefono ;
   private String[] P007Q2_A217PacienteCorreo ;
   private String[] P007Q2_A216PacienteSexo ;
   private String[] P007Q2_A215PacienteDireccion ;
   private String[] P007Q2_A106PacienteNroDocumento ;
   private String[] P007Q2_A214PacienteTipoDocumento ;
   private String[] P007Q2_A105PacienteNombres ;
   private String[] P007Q2_A104PacienteApellidoMaterno ;
   private String[] P007Q2_A103PacienteApellidoPaterno ;
   private String[] P007Q2_A188UbigeoDistrito ;
   private String[] P007Q2_A187UbigeoProvincia ;
   private String[] P007Q2_A186UbigeoDepartamento ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV110Pacientewwds_14_tfpacientetipodocumento_sels ;
   private GXSimpleCollection<String> AV115Pacientewwds_19_tfpacientesexo_sels ;
   private GXSimpleCollection<String> AV124Pacientewwds_28_tfpacienteestado_sels ;
   private GXSimpleCollection<String> AV137Pacientewwds_41_tfpacienteenterarse_sels ;
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

final  class pacientewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV110Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV115Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV124Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV137Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV97Pacientewwds_1_filterfulltext ,
                                          int AV98Pacientewwds_2_tfpacienteid ,
                                          int AV99Pacientewwds_3_tfpacienteid_to ,
                                          String AV101Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV100Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV103Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV102Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV105Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV104Pacientewwds_8_tfpacientenombres ,
                                          String AV107Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV106Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV108Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV109Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV110Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV112Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV111Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV114Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV113Pacientewwds_17_tfpacientedireccion ,
                                          int AV115Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV117Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV116Pacientewwds_20_tfpacientecorreo ,
                                          String AV119Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV118Pacientewwds_22_tfpacientetelefono ,
                                          short AV120Pacientewwds_24_tfpaisid ,
                                          short AV121Pacientewwds_25_tfpaisid_to ,
                                          String AV123Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV122Pacientewwds_26_tfpaisdescripcion ,
                                          int AV124Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV125Pacientewwds_29_tfsecuserid ,
                                          short AV126Pacientewwds_30_tfsecuserid_to ,
                                          String AV128Pacientewwds_32_tfubigeocode_sel ,
                                          String AV127Pacientewwds_31_tfubigeocode ,
                                          String AV130Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV129Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV131Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV132Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV133Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV134Pacientewwds_38_tfpacientepeso_to ,
                                          String AV136Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV135Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV137Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV139Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV138Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV140Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV141Pacientewwds_45_tfpacientefecharegistro_to ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A106PacienteNroDocumento ,
                                          String A215PacienteDireccion ,
                                          String A217PacienteCorreo ,
                                          String A218PacienteTelefono ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion ,
                                          short A6SecUserId ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          java.math.BigDecimal A220PacienteEstatura ,
                                          java.math.BigDecimal A221PacientePeso ,
                                          String A222PacienteNombreAnexo ,
                                          String A225PacienteEspecifique ,
                                          java.util.Date A213PacienteFechaNacimiento ,
                                          java.util.Date A226PacienteFechaRegistro ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[76];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
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
         GXv_int11[29] = (byte)(1) ;
         GXv_int11[30] = (byte)(1) ;
         GXv_int11[31] = (byte)(1) ;
         GXv_int11[32] = (byte)(1) ;
         GXv_int11[33] = (byte)(1) ;
         GXv_int11[34] = (byte)(1) ;
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (0==AV98Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( ! (0==AV99Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV101Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV100Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV101Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV102Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV105Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV104Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV106Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV108Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV109Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int11[47] = (byte)(1) ;
      }
      if ( AV110Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV110Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV112Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV111Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int11[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int11[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV113Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int11[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int11[51] = (byte)(1) ;
      }
      if ( AV115Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV117Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV116Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int11[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV117Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int11[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV119Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV118Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int11[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int11[55] = (byte)(1) ;
      }
      if ( ! (0==AV120Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int11[56] = (byte)(1) ;
      }
      if ( ! (0==AV121Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int11[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV122Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int11[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int11[59] = (byte)(1) ;
      }
      if ( AV124Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV124Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV125Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int11[60] = (byte)(1) ;
      }
      if ( ! (0==AV126Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int11[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV127Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int11[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int11[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int11[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int11[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV131Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int11[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV132Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int11[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV133Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int11[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV134Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int11[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV135Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int11[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int11[71] = (byte)(1) ;
      }
      if ( AV137Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV137Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV139Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV138Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int11[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int11[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV140Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int11[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV141Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int11[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombres]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombres] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaNacimiento]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaNacimiento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteTipoDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteTipoDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteSexo]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteSexo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteCorreo]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteCorreo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteTelefono]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteTelefono] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PaisId]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PaisId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PaisDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstado]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstatura]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEstatura] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacientePeso]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacientePeso] DESC" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombreAnexo]" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteNombreAnexo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEnterarse]" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEnterarse] DESC" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteEspecifique]" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteEspecifique] DESC" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaRegistro]" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PacienteFechaRegistro] DESC" ;
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
                  return conditional_P007Q2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] , ((Number) dynConstraints[74]).shortValue() , ((Boolean) dynConstraints[75]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 1);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(15);
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((String[]) buf[25])[0] = rslt.getVarchar(21);
               ((String[]) buf[26])[0] = rslt.getVarchar(22);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((String[]) buf[28])[0] = rslt.getVarchar(24);
               ((String[]) buf[29])[0] = rslt.getVarchar(25);
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
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[116], 100);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[117], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[118], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[119], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[122]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[123]);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 15);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 15);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 500);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 500);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[130], 20);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[131], 20);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[132]).shortValue());
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[133]).shortValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 80);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 80);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[136]).shortValue());
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[137]).shortValue());
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[138], 10);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[139], 10);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 100);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 100);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[142], 2);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[143], 2);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[144], 2);
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[145], 2);
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[146], 100);
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[147], 100);
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 200);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 200);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[150], false);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[151], false);
               }
               return;
      }
   }

}

