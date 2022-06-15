package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pagowwexport extends GXProcedure
{
   public pagowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagowwexport.class ), "" );
   }

   public pagowwexport( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      pagowwexport.this.aP1 = new String[] {""};
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
      pagowwexport.this.aP0 = aP0;
      pagowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago", GXv_boolean2) ;
      pagowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV98Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PagoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFPagoId) && (0==AV36TFPagoId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPagoId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPagoId_To );
      }
      if ( ! ( (0==AV37TFCitaId) && (0==AV38TFCitaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cita Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFCitaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFCitaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV40TFCitaCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cita Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFCitaCode_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFCitaCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cita Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFCitaCode, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFSGCitaDisponibilidadFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFSGCitaDisponibilidadFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "SGCita Disponibilidad Fecha") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV41TFSGCitaDisponibilidadFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV42TFSGCitaDisponibilidadFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFPagoMonto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFPagoMonto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Monto") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV43TFPagoMonto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV44TFPagoMonto_To)) );
      }
      if ( ! ( (GXutil.strcmp("", AV46TFPagoToken_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Token") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFPagoToken_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFPagoToken)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Token") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFPagoToken, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV48TFPagoTipoDocumentoCliente_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Documento Cliente") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV81i = 1 ;
         AV99GXV1 = 1 ;
         while ( AV99GXV1 <= AV48TFPagoTipoDocumentoCliente_Sels.size() )
         {
            AV49TFPagoTipoDocumentoCliente_Sel = (String)AV48TFPagoTipoDocumentoCliente_Sels.elementAt(-1+AV99GXV1) ;
            if ( AV81i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumentocliente.getDescription(httpContext,(String)AV49TFPagoTipoDocumentoCliente_Sel) );
            AV81i = (long)(AV81i+1) ;
            AV99GXV1 = (int)(AV99GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV51TFPagoClienteNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFPagoClienteNroDocumento_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFPagoClienteNroDocumento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFPagoClienteNroDocumento, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV53TFPagoClienteDenominacion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Denominacion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFPagoClienteDenominacion_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFPagoClienteDenominacion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Denominacion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFPagoClienteDenominacion, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV55TFPagoClienteDireccion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Direccion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFPagoClienteDireccion_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV54TFPagoClienteDireccion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Direccion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFPagoClienteDireccion, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV57TFPagoClienteEmail_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Email") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFPagoClienteEmail_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFPagoClienteEmail)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Cliente Email") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFPagoClienteEmail, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV59TFPagoTipoDocumento_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV81i = 1 ;
         AV100GXV2 = 1 ;
         while ( AV100GXV2 <= AV59TFPagoTipoDocumento_Sels.size() )
         {
            AV60TFPagoTipoDocumento_Sel = ((Number) AV59TFPagoTipoDocumento_Sels.elementAt(-1+AV100GXV2)).shortValue() ;
            if ( AV81i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumentopago.getDescription(httpContext,(short)AV60TFPagoTipoDocumento_Sel) );
            AV81i = (long)(AV81i+1) ;
            AV100GXV2 = (int)(AV100GXV2+1) ;
         }
      }
      if ( ! ( (0==AV61TFPagoNumero) && (0==AV62TFPagoNumero_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Numero") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV61TFPagoNumero );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV62TFPagoNumero_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63TFPagoFechaEmision)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64TFPagoFechaEmision_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Fecha Emision") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV63TFPagoFechaEmision );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV64TFPagoFechaEmision_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV66TFPagoMoneda_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Moneda") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV81i = 1 ;
         AV101GXV3 = 1 ;
         while ( AV101GXV3 <= AV66TFPagoMoneda_Sels.size() )
         {
            AV67TFPagoMoneda_Sel = ((Number) AV66TFPagoMoneda_Sels.elementAt(-1+AV101GXV3)).shortValue() ;
            if ( AV81i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)AV67TFPagoMoneda_Sel) );
            AV81i = (long)(AV81i+1) ;
            AV101GXV3 = (int)(AV101GXV3+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV75TFPagoNubefactRequest_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nubefact Request") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV75TFPagoNubefactRequest_Sel, 1, 1000), GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV74TFPagoNubefactRequest)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nubefact Request") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV74TFPagoNubefactRequest, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV77TFPagoNubefactResponse_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nubefact Response") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV77TFPagoNubefactResponse_Sel, 1, 1000), GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV76TFPagoNubefactResponse)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nubefact Response") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV76TFPagoNubefactResponse, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV83TFPagoRequest_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Request") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV83TFPagoRequest_Sel, 1, 1000), GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV82TFPagoRequest)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Request") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV82TFPagoRequest, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV85TFPagoResponse_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Response") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV85TFPagoResponse_Sel, 1, 1000), GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV84TFPagoResponse)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Response") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( AV84TFPagoResponse, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV87TFPagoPasarelaId_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pasarela Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV87TFPagoPasarelaId_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV86TFPagoPasarelaId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Pasarela Id") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV86TFPagoPasarelaId, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV88TFPagoStatusCode) && (0==AV89TFPagoStatusCode_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Status Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV88TFPagoStatusCode );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV89TFPagoStatusCode_To );
      }
      if ( ! ( (0==AV90TFDisponibilidadId) && (0==AV91TFDisponibilidadId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Disponibilidad Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV90TFDisponibilidadId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV91TFDisponibilidadId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV93TFPagoEnlacePDF_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Enlace PDF") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV93TFPagoEnlacePDF_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV92TFPagoEnlacePDF)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Enlace PDF") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV92TFPagoEnlacePDF, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV95TFPagoEnlaceXML_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Enlace XML") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV95TFPagoEnlaceXML_Sel, GXv_char7) ;
         pagowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV94TFPagoEnlaceXML)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Enlace XML") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            pagowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV94TFPagoEnlaceXML, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV79TFPagoEstadoR_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado R") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         pagowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV81i = 1 ;
         AV102GXV4 = 1 ;
         while ( AV102GXV4 <= AV79TFPagoEstadoR_Sels.size() )
         {
            AV80TFPagoEstadoR_Sel = (String)AV79TFPagoEstadoR_Sels.elementAt(-1+AV102GXV4) ;
            if ( AV81i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV80TFPagoEstadoR_Sel) );
            AV81i = (long)(AV81i+1) ;
            AV102GXV4 = (int)(AV102GXV4+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PagoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PagoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV103GXV5 = 1 ;
      while ( AV103GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV103GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV103GXV5 = (int)(AV103GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV105Pagowwds_1_filterfulltext = AV19FilterFullText ;
      AV106Pagowwds_2_tfpagoid = AV35TFPagoId ;
      AV107Pagowwds_3_tfpagoid_to = AV36TFPagoId_To ;
      AV108Pagowwds_4_tfcitaid = AV37TFCitaId ;
      AV109Pagowwds_5_tfcitaid_to = AV38TFCitaId_To ;
      AV110Pagowwds_6_tfcitacode = AV39TFCitaCode ;
      AV111Pagowwds_7_tfcitacode_sel = AV40TFCitaCode_Sel ;
      AV112Pagowwds_8_tfsgcitadisponibilidadfecha = AV41TFSGCitaDisponibilidadFecha ;
      AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV42TFSGCitaDisponibilidadFecha_To ;
      AV114Pagowwds_10_tfpagomonto = AV43TFPagoMonto ;
      AV115Pagowwds_11_tfpagomonto_to = AV44TFPagoMonto_To ;
      AV116Pagowwds_12_tfpagotoken = AV45TFPagoToken ;
      AV117Pagowwds_13_tfpagotoken_sel = AV46TFPagoToken_Sel ;
      AV118Pagowwds_14_tfpagotipodocumentocliente_sels = AV48TFPagoTipoDocumentoCliente_Sels ;
      AV119Pagowwds_15_tfpagoclientenrodocumento = AV50TFPagoClienteNroDocumento ;
      AV120Pagowwds_16_tfpagoclientenrodocumento_sel = AV51TFPagoClienteNroDocumento_Sel ;
      AV121Pagowwds_17_tfpagoclientedenominacion = AV52TFPagoClienteDenominacion ;
      AV122Pagowwds_18_tfpagoclientedenominacion_sel = AV53TFPagoClienteDenominacion_Sel ;
      AV123Pagowwds_19_tfpagoclientedireccion = AV54TFPagoClienteDireccion ;
      AV124Pagowwds_20_tfpagoclientedireccion_sel = AV55TFPagoClienteDireccion_Sel ;
      AV125Pagowwds_21_tfpagoclienteemail = AV56TFPagoClienteEmail ;
      AV126Pagowwds_22_tfpagoclienteemail_sel = AV57TFPagoClienteEmail_Sel ;
      AV127Pagowwds_23_tfpagotipodocumento_sels = AV59TFPagoTipoDocumento_Sels ;
      AV128Pagowwds_24_tfpagonumero = AV61TFPagoNumero ;
      AV129Pagowwds_25_tfpagonumero_to = AV62TFPagoNumero_To ;
      AV130Pagowwds_26_tfpagofechaemision = AV63TFPagoFechaEmision ;
      AV131Pagowwds_27_tfpagofechaemision_to = AV64TFPagoFechaEmision_To ;
      AV132Pagowwds_28_tfpagomoneda_sels = AV66TFPagoMoneda_Sels ;
      AV133Pagowwds_29_tfpagonubefactrequest = AV74TFPagoNubefactRequest ;
      AV134Pagowwds_30_tfpagonubefactrequest_sel = AV75TFPagoNubefactRequest_Sel ;
      AV135Pagowwds_31_tfpagonubefactresponse = AV76TFPagoNubefactResponse ;
      AV136Pagowwds_32_tfpagonubefactresponse_sel = AV77TFPagoNubefactResponse_Sel ;
      AV137Pagowwds_33_tfpagorequest = AV82TFPagoRequest ;
      AV138Pagowwds_34_tfpagorequest_sel = AV83TFPagoRequest_Sel ;
      AV139Pagowwds_35_tfpagoresponse = AV84TFPagoResponse ;
      AV140Pagowwds_36_tfpagoresponse_sel = AV85TFPagoResponse_Sel ;
      AV141Pagowwds_37_tfpagopasarelaid = AV86TFPagoPasarelaId ;
      AV142Pagowwds_38_tfpagopasarelaid_sel = AV87TFPagoPasarelaId_Sel ;
      AV143Pagowwds_39_tfpagostatuscode = AV88TFPagoStatusCode ;
      AV144Pagowwds_40_tfpagostatuscode_to = AV89TFPagoStatusCode_To ;
      AV145Pagowwds_41_tfdisponibilidadid = AV90TFDisponibilidadId ;
      AV146Pagowwds_42_tfdisponibilidadid_to = AV91TFDisponibilidadId_To ;
      AV147Pagowwds_43_tfpagoenlacepdf = AV92TFPagoEnlacePDF ;
      AV148Pagowwds_44_tfpagoenlacepdf_sel = AV93TFPagoEnlacePDF_Sel ;
      AV149Pagowwds_45_tfpagoenlacexml = AV94TFPagoEnlaceXML ;
      AV150Pagowwds_46_tfpagoenlacexml_sel = AV95TFPagoEnlaceXML_Sel ;
      AV151Pagowwds_47_tfpagoestador_sels = AV79TFPagoEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV118Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV127Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV132Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV151Pagowwds_47_tfpagoestador_sels ,
                                           AV105Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV106Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV107Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV108Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV109Pagowwds_5_tfcitaid_to) ,
                                           AV111Pagowwds_7_tfcitacode_sel ,
                                           AV110Pagowwds_6_tfcitacode ,
                                           AV112Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV114Pagowwds_10_tfpagomonto ,
                                           AV115Pagowwds_11_tfpagomonto_to ,
                                           AV117Pagowwds_13_tfpagotoken_sel ,
                                           AV116Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV118Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV120Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV119Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV122Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV121Pagowwds_17_tfpagoclientedenominacion ,
                                           AV124Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV123Pagowwds_19_tfpagoclientedireccion ,
                                           AV126Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV125Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV127Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV128Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV129Pagowwds_25_tfpagonumero_to) ,
                                           AV130Pagowwds_26_tfpagofechaemision ,
                                           AV131Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV132Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV134Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV133Pagowwds_29_tfpagonubefactrequest ,
                                           AV136Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV135Pagowwds_31_tfpagonubefactresponse ,
                                           AV138Pagowwds_34_tfpagorequest_sel ,
                                           AV137Pagowwds_33_tfpagorequest ,
                                           AV140Pagowwds_36_tfpagoresponse_sel ,
                                           AV139Pagowwds_35_tfpagoresponse ,
                                           AV142Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV141Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV143Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV144Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV145Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV146Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV148Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV147Pagowwds_43_tfpagoenlacepdf ,
                                           AV150Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV149Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV151Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV105Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV105Pagowwds_1_filterfulltext), "%", "") ;
      lV110Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV110Pagowwds_6_tfcitacode), "%", "") ;
      lV116Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV116Pagowwds_12_tfpagotoken), "%", "") ;
      lV119Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV119Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV121Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV121Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV123Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV123Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV125Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV125Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV133Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV133Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV135Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV135Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV137Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV137Pagowwds_33_tfpagorequest), "%", "") ;
      lV139Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV139Pagowwds_35_tfpagoresponse), "%", "") ;
      lV141Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV141Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV147Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV147Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV149Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV149Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P004R2 */
      pr_default.execute(0, new Object[] {lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, lV105Pagowwds_1_filterfulltext, Integer.valueOf(AV106Pagowwds_2_tfpagoid), Integer.valueOf(AV107Pagowwds_3_tfpagoid_to), Integer.valueOf(AV108Pagowwds_4_tfcitaid), Integer.valueOf(AV109Pagowwds_5_tfcitaid_to), lV110Pagowwds_6_tfcitacode, AV111Pagowwds_7_tfcitacode_sel, AV112Pagowwds_8_tfsgcitadisponibilidadfecha, AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV114Pagowwds_10_tfpagomonto, AV115Pagowwds_11_tfpagomonto_to, lV116Pagowwds_12_tfpagotoken, AV117Pagowwds_13_tfpagotoken_sel, lV119Pagowwds_15_tfpagoclientenrodocumento, AV120Pagowwds_16_tfpagoclientenrodocumento_sel, lV121Pagowwds_17_tfpagoclientedenominacion, AV122Pagowwds_18_tfpagoclientedenominacion_sel, lV123Pagowwds_19_tfpagoclientedireccion, AV124Pagowwds_20_tfpagoclientedireccion_sel, lV125Pagowwds_21_tfpagoclienteemail, AV126Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV128Pagowwds_24_tfpagonumero), Integer.valueOf(AV129Pagowwds_25_tfpagonumero_to), AV130Pagowwds_26_tfpagofechaemision, AV131Pagowwds_27_tfpagofechaemision_to, lV133Pagowwds_29_tfpagonubefactrequest, AV134Pagowwds_30_tfpagonubefactrequest_sel, lV135Pagowwds_31_tfpagonubefactresponse, AV136Pagowwds_32_tfpagonubefactresponse_sel, lV137Pagowwds_33_tfpagorequest, AV138Pagowwds_34_tfpagorequest_sel, lV139Pagowwds_35_tfpagoresponse, AV140Pagowwds_36_tfpagoresponse_sel, lV141Pagowwds_37_tfpagopasarelaid, AV142Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV143Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV144Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV145Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV146Pagowwds_42_tfdisponibilidadid_to), lV147Pagowwds_43_tfpagoenlacepdf, AV148Pagowwds_44_tfpagoenlacepdf_sel, lV149Pagowwds_45_tfpagoenlacexml, AV150Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A21SGCitaDisponibilidadId = P004R2_A21SGCitaDisponibilidadId[0] ;
         A34DisponibilidadId = P004R2_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P004R2_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P004R2_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P004R2_A252PagoFechaEmision[0] ;
         A245PagoNumero = P004R2_A245PagoNumero[0] ;
         A242PagoMonto = P004R2_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P004R2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004R2_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P004R2_A19CitaId[0] ;
         n19CitaId = P004R2_n19CitaId[0] ;
         A47PagoId = P004R2_A47PagoId[0] ;
         A246PagoEstadoR = P004R2_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P004R2_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P004R2_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P004R2_A310PagoPasarelaId[0] ;
         A309PagoResponse = P004R2_A309PagoResponse[0] ;
         A308PagoRequest = P004R2_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P004R2_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P004R2_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P004R2_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P004R2_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P004R2_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P004R2_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P004R2_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P004R2_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P004R2_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P004R2_A243PagoToken[0] ;
         A64CitaCode = P004R2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P004R2_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P004R2_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P004R2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P004R2_n66SGCitaDisponibilidadFecha[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A47PagoId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A19CitaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A64CitaCode, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A66SGCitaDisponibilidadFecha );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A242PagoMonto)) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A243PagoToken, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumentocliente.getDescription(httpContext,(String)A247PagoTipoDocumentoCliente) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A248PagoClienteNroDocumento, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A249PagoClienteDenominacion, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A250PagoClienteDireccion, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A251PagoClienteEmail, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumentopago.getDescription(httpContext,(short)A244PagoTipoDocumento) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A245PagoNumero );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_dtime8 = GXutil.resetTime( A252PagoFechaEmision );
            AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)A253PagoMoneda) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A256PagoNubefactRequest, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A257PagoNubefactResponse, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A308PagoRequest, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A309PagoResponse, 1, 1000), GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A310PagoPasarelaId, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A311PagoStatusCode );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A34DisponibilidadId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A338PagoEnlacePDF, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A339PagoEnlaceXML, GXv_char7) ;
            pagowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestador.getDescription(httpContext,(String)A246PagoEstadoR) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaId", "", "Cita Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "CitaCode", "", "Cita Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "SGCitaDisponibilidadFecha", "", "SGCita Disponibilidad Fecha", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoMonto", "", "Monto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoToken", "", "Token", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoTipoDocumentoCliente", "", "Documento Cliente", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteNroDocumento", "", "Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteDenominacion", "", "Cliente Denominacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteDireccion", "", "Cliente Direccion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoClienteEmail", "", "Cliente Email", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoTipoDocumento", "", "Tipo Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNumero", "", "Numero", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoFechaEmision", "", "Fecha Emision", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoMoneda", "", "Moneda", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNubefactRequest", "", "Nubefact Request", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoNubefactResponse", "", "Nubefact Response", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoRequest", "", "Request", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoResponse", "", "Response", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoPasarelaId", "", "Pasarela Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoStatusCode", "", "Status Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "DisponibilidadId", "", "Disponibilidad Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEnlacePDF", "", "Enlace PDF", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEnlaceXML", "", "Enlace XML", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "PagoEstadoR", "", "Estado R", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PagoWWColumnsSelector", GXv_char7) ;
      pagowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("PagoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PagoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PagoWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV152GXV6 = 1 ;
      while ( AV152GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV152GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOID") == 0 )
         {
            AV35TFPagoId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPagoId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV37TFCitaId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFCitaId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV39TFCitaCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV40TFCitaCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV41TFSGCitaDisponibilidadFecha = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV42TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONTO") == 0 )
         {
            AV43TFPagoMonto = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV44TFPagoMonto_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN") == 0 )
         {
            AV45TFPagoToken = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN_SEL") == 0 )
         {
            AV46TFPagoToken_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTOCLIENTE_SEL") == 0 )
         {
            AV47TFPagoTipoDocumentoCliente_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV47TFPagoTipoDocumentoCliente_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO") == 0 )
         {
            AV50TFPagoClienteNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV51TFPagoClienteNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION") == 0 )
         {
            AV52TFPagoClienteDenominacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION_SEL") == 0 )
         {
            AV53TFPagoClienteDenominacion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION") == 0 )
         {
            AV54TFPagoClienteDireccion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION_SEL") == 0 )
         {
            AV55TFPagoClienteDireccion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL") == 0 )
         {
            AV56TFPagoClienteEmail = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL_SEL") == 0 )
         {
            AV57TFPagoClienteEmail_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTO_SEL") == 0 )
         {
            AV58TFPagoTipoDocumento_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFPagoTipoDocumento_Sels.fromJSonString(AV58TFPagoTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUMERO") == 0 )
         {
            AV61TFPagoNumero = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV62TFPagoNumero_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOFECHAEMISION") == 0 )
         {
            AV63TFPagoFechaEmision = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV64TFPagoFechaEmision_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONEDA_SEL") == 0 )
         {
            AV65TFPagoMoneda_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFPagoMoneda_Sels.fromJSonString(AV65TFPagoMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST") == 0 )
         {
            AV74TFPagoNubefactRequest = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST_SEL") == 0 )
         {
            AV75TFPagoNubefactRequest_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE") == 0 )
         {
            AV76TFPagoNubefactResponse = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE_SEL") == 0 )
         {
            AV77TFPagoNubefactResponse_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST") == 0 )
         {
            AV82TFPagoRequest = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST_SEL") == 0 )
         {
            AV83TFPagoRequest_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE") == 0 )
         {
            AV84TFPagoResponse = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE_SEL") == 0 )
         {
            AV85TFPagoResponse_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID") == 0 )
         {
            AV86TFPagoPasarelaId = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID_SEL") == 0 )
         {
            AV87TFPagoPasarelaId_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOSTATUSCODE") == 0 )
         {
            AV88TFPagoStatusCode = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV89TFPagoStatusCode_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV90TFDisponibilidadId = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV91TFDisponibilidadId_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF") == 0 )
         {
            AV92TFPagoEnlacePDF = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF_SEL") == 0 )
         {
            AV93TFPagoEnlacePDF_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML") == 0 )
         {
            AV94TFPagoEnlaceXML = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML_SEL") == 0 )
         {
            AV95TFPagoEnlaceXML_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOESTADOR_SEL") == 0 )
         {
            AV78TFPagoEstadoR_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV79TFPagoEstadoR_Sels.fromJSonString(AV78TFPagoEstadoR_SelsJson, null);
         }
         AV152GXV6 = (int)(AV152GXV6+1) ;
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
      this.aP0[0] = pagowwexport.this.AV12Filename;
      this.aP1[0] = pagowwexport.this.AV13ErrorMessage;
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
      AV98Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV40TFCitaCode_Sel = "" ;
      AV39TFCitaCode = "" ;
      AV41TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV42TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV43TFPagoMonto = DecimalUtil.ZERO ;
      AV44TFPagoMonto_To = DecimalUtil.ZERO ;
      AV46TFPagoToken_Sel = "" ;
      AV45TFPagoToken = "" ;
      AV48TFPagoTipoDocumentoCliente_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFPagoTipoDocumentoCliente_Sel = "" ;
      AV51TFPagoClienteNroDocumento_Sel = "" ;
      AV50TFPagoClienteNroDocumento = "" ;
      AV53TFPagoClienteDenominacion_Sel = "" ;
      AV52TFPagoClienteDenominacion = "" ;
      AV55TFPagoClienteDireccion_Sel = "" ;
      AV54TFPagoClienteDireccion = "" ;
      AV57TFPagoClienteEmail_Sel = "" ;
      AV56TFPagoClienteEmail = "" ;
      AV59TFPagoTipoDocumento_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV63TFPagoFechaEmision = GXutil.nullDate() ;
      AV64TFPagoFechaEmision_To = GXutil.nullDate() ;
      AV66TFPagoMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV75TFPagoNubefactRequest_Sel = "" ;
      AV74TFPagoNubefactRequest = "" ;
      AV77TFPagoNubefactResponse_Sel = "" ;
      AV76TFPagoNubefactResponse = "" ;
      AV83TFPagoRequest_Sel = "" ;
      AV82TFPagoRequest = "" ;
      AV85TFPagoResponse_Sel = "" ;
      AV84TFPagoResponse = "" ;
      AV87TFPagoPasarelaId_Sel = "" ;
      AV86TFPagoPasarelaId = "" ;
      AV93TFPagoEnlacePDF_Sel = "" ;
      AV92TFPagoEnlacePDF = "" ;
      AV95TFPagoEnlaceXML_Sel = "" ;
      AV94TFPagoEnlaceXML = "" ;
      AV79TFPagoEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV80TFPagoEstadoR_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      A246PagoEstadoR = "" ;
      AV105Pagowwds_1_filterfulltext = "" ;
      AV110Pagowwds_6_tfcitacode = "" ;
      AV111Pagowwds_7_tfcitacode_sel = "" ;
      AV112Pagowwds_8_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV114Pagowwds_10_tfpagomonto = DecimalUtil.ZERO ;
      AV115Pagowwds_11_tfpagomonto_to = DecimalUtil.ZERO ;
      AV116Pagowwds_12_tfpagotoken = "" ;
      AV117Pagowwds_13_tfpagotoken_sel = "" ;
      AV118Pagowwds_14_tfpagotipodocumentocliente_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV119Pagowwds_15_tfpagoclientenrodocumento = "" ;
      AV120Pagowwds_16_tfpagoclientenrodocumento_sel = "" ;
      AV121Pagowwds_17_tfpagoclientedenominacion = "" ;
      AV122Pagowwds_18_tfpagoclientedenominacion_sel = "" ;
      AV123Pagowwds_19_tfpagoclientedireccion = "" ;
      AV124Pagowwds_20_tfpagoclientedireccion_sel = "" ;
      AV125Pagowwds_21_tfpagoclienteemail = "" ;
      AV126Pagowwds_22_tfpagoclienteemail_sel = "" ;
      AV127Pagowwds_23_tfpagotipodocumento_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV130Pagowwds_26_tfpagofechaemision = GXutil.nullDate() ;
      AV131Pagowwds_27_tfpagofechaemision_to = GXutil.nullDate() ;
      AV132Pagowwds_28_tfpagomoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV133Pagowwds_29_tfpagonubefactrequest = "" ;
      AV134Pagowwds_30_tfpagonubefactrequest_sel = "" ;
      AV135Pagowwds_31_tfpagonubefactresponse = "" ;
      AV136Pagowwds_32_tfpagonubefactresponse_sel = "" ;
      AV137Pagowwds_33_tfpagorequest = "" ;
      AV138Pagowwds_34_tfpagorequest_sel = "" ;
      AV139Pagowwds_35_tfpagoresponse = "" ;
      AV140Pagowwds_36_tfpagoresponse_sel = "" ;
      AV141Pagowwds_37_tfpagopasarelaid = "" ;
      AV142Pagowwds_38_tfpagopasarelaid_sel = "" ;
      AV147Pagowwds_43_tfpagoenlacepdf = "" ;
      AV148Pagowwds_44_tfpagoenlacepdf_sel = "" ;
      AV149Pagowwds_45_tfpagoenlacexml = "" ;
      AV150Pagowwds_46_tfpagoenlacexml_sel = "" ;
      AV151Pagowwds_47_tfpagoestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV105Pagowwds_1_filterfulltext = "" ;
      lV110Pagowwds_6_tfcitacode = "" ;
      lV116Pagowwds_12_tfpagotoken = "" ;
      lV119Pagowwds_15_tfpagoclientenrodocumento = "" ;
      lV121Pagowwds_17_tfpagoclientedenominacion = "" ;
      lV123Pagowwds_19_tfpagoclientedireccion = "" ;
      lV125Pagowwds_21_tfpagoclienteemail = "" ;
      lV133Pagowwds_29_tfpagonubefactrequest = "" ;
      lV135Pagowwds_31_tfpagonubefactresponse = "" ;
      lV137Pagowwds_33_tfpagorequest = "" ;
      lV139Pagowwds_35_tfpagoresponse = "" ;
      lV141Pagowwds_37_tfpagopasarelaid = "" ;
      lV147Pagowwds_43_tfpagoenlacepdf = "" ;
      lV149Pagowwds_45_tfpagoenlacexml = "" ;
      P004R2_A21SGCitaDisponibilidadId = new int[1] ;
      P004R2_A34DisponibilidadId = new int[1] ;
      P004R2_n34DisponibilidadId = new boolean[] {false} ;
      P004R2_A311PagoStatusCode = new int[1] ;
      P004R2_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P004R2_A245PagoNumero = new int[1] ;
      P004R2_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004R2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004R2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P004R2_A19CitaId = new int[1] ;
      P004R2_n19CitaId = new boolean[] {false} ;
      P004R2_A47PagoId = new int[1] ;
      P004R2_A246PagoEstadoR = new String[] {""} ;
      P004R2_A339PagoEnlaceXML = new String[] {""} ;
      P004R2_A338PagoEnlacePDF = new String[] {""} ;
      P004R2_A310PagoPasarelaId = new String[] {""} ;
      P004R2_A309PagoResponse = new String[] {""} ;
      P004R2_A308PagoRequest = new String[] {""} ;
      P004R2_A257PagoNubefactResponse = new String[] {""} ;
      P004R2_A256PagoNubefactRequest = new String[] {""} ;
      P004R2_A253PagoMoneda = new short[1] ;
      P004R2_A244PagoTipoDocumento = new short[1] ;
      P004R2_A251PagoClienteEmail = new String[] {""} ;
      P004R2_A250PagoClienteDireccion = new String[] {""} ;
      P004R2_A249PagoClienteDenominacion = new String[] {""} ;
      P004R2_A248PagoClienteNroDocumento = new String[] {""} ;
      P004R2_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P004R2_A243PagoToken = new String[] {""} ;
      P004R2_A64CitaCode = new String[] {""} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47TFPagoTipoDocumentoCliente_SelsJson = "" ;
      AV58TFPagoTipoDocumento_SelsJson = "" ;
      AV65TFPagoMoneda_SelsJson = "" ;
      AV78TFPagoEstadoR_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagowwexport__default(),
         new Object[] {
             new Object[] {
            P004R2_A21SGCitaDisponibilidadId, P004R2_A34DisponibilidadId, P004R2_n34DisponibilidadId, P004R2_A311PagoStatusCode, P004R2_A252PagoFechaEmision, P004R2_A245PagoNumero, P004R2_A242PagoMonto, P004R2_A66SGCitaDisponibilidadFecha, P004R2_n66SGCitaDisponibilidadFecha, P004R2_A19CitaId,
            P004R2_n19CitaId, P004R2_A47PagoId, P004R2_A246PagoEstadoR, P004R2_A339PagoEnlaceXML, P004R2_A338PagoEnlacePDF, P004R2_A310PagoPasarelaId, P004R2_A309PagoResponse, P004R2_A308PagoRequest, P004R2_A257PagoNubefactResponse, P004R2_A256PagoNubefactRequest,
            P004R2_A253PagoMoneda, P004R2_A244PagoTipoDocumento, P004R2_A251PagoClienteEmail, P004R2_A250PagoClienteDireccion, P004R2_A249PagoClienteDenominacion, P004R2_A248PagoClienteNroDocumento, P004R2_A247PagoTipoDocumentoCliente, P004R2_A243PagoToken, P004R2_A64CitaCode
            }
         }
      );
      AV98Pgmname = "PagoWWExport" ;
      /* GeneXus formulas. */
      AV98Pgmname = "PagoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV60TFPagoTipoDocumento_Sel ;
   private short AV67TFPagoMoneda_Sel ;
   private short GXv_int5[] ;
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFPagoId ;
   private int AV36TFPagoId_To ;
   private int AV37TFCitaId ;
   private int AV38TFCitaId_To ;
   private int AV99GXV1 ;
   private int AV100GXV2 ;
   private int AV61TFPagoNumero ;
   private int AV62TFPagoNumero_To ;
   private int AV101GXV3 ;
   private int AV88TFPagoStatusCode ;
   private int AV89TFPagoStatusCode_To ;
   private int AV90TFDisponibilidadId ;
   private int AV91TFDisponibilidadId_To ;
   private int AV102GXV4 ;
   private int AV103GXV5 ;
   private int A47PagoId ;
   private int A19CitaId ;
   private int A245PagoNumero ;
   private int A311PagoStatusCode ;
   private int A34DisponibilidadId ;
   private int AV106Pagowwds_2_tfpagoid ;
   private int AV107Pagowwds_3_tfpagoid_to ;
   private int AV108Pagowwds_4_tfcitaid ;
   private int AV109Pagowwds_5_tfcitaid_to ;
   private int AV128Pagowwds_24_tfpagonumero ;
   private int AV129Pagowwds_25_tfpagonumero_to ;
   private int AV143Pagowwds_39_tfpagostatuscode ;
   private int AV144Pagowwds_40_tfpagostatuscode_to ;
   private int AV145Pagowwds_41_tfdisponibilidadid ;
   private int AV146Pagowwds_42_tfdisponibilidadid_to ;
   private int AV118Pagowwds_14_tfpagotipodocumentocliente_sels_size ;
   private int AV127Pagowwds_23_tfpagotipodocumento_sels_size ;
   private int AV132Pagowwds_28_tfpagomoneda_sels_size ;
   private int AV151Pagowwds_47_tfpagoestador_sels_size ;
   private int A21SGCitaDisponibilidadId ;
   private int AV152GXV6 ;
   private long AV81i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV43TFPagoMonto ;
   private java.math.BigDecimal AV44TFPagoMonto_To ;
   private java.math.BigDecimal A242PagoMonto ;
   private java.math.BigDecimal AV114Pagowwds_10_tfpagomonto ;
   private java.math.BigDecimal AV115Pagowwds_11_tfpagomonto_to ;
   private String AV98Pgmname ;
   private String AV49TFPagoTipoDocumentoCliente_Sel ;
   private String AV80TFPagoEstadoR_Sel ;
   private String A247PagoTipoDocumentoCliente ;
   private String A246PagoEstadoR ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV41TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV42TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV63TFPagoFechaEmision ;
   private java.util.Date AV64TFPagoFechaEmision_To ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private java.util.Date AV112Pagowwds_8_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date AV130Pagowwds_26_tfpagofechaemision ;
   private java.util.Date AV131Pagowwds_27_tfpagofechaemision_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n34DisponibilidadId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n19CitaId ;
   private String AV27ColumnsSelectorXML ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV28UserCustomValue ;
   private String AV47TFPagoTipoDocumentoCliente_SelsJson ;
   private String AV58TFPagoTipoDocumento_SelsJson ;
   private String AV65TFPagoMoneda_SelsJson ;
   private String AV78TFPagoEstadoR_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV40TFCitaCode_Sel ;
   private String AV39TFCitaCode ;
   private String AV46TFPagoToken_Sel ;
   private String AV45TFPagoToken ;
   private String AV51TFPagoClienteNroDocumento_Sel ;
   private String AV50TFPagoClienteNroDocumento ;
   private String AV53TFPagoClienteDenominacion_Sel ;
   private String AV52TFPagoClienteDenominacion ;
   private String AV55TFPagoClienteDireccion_Sel ;
   private String AV54TFPagoClienteDireccion ;
   private String AV57TFPagoClienteEmail_Sel ;
   private String AV56TFPagoClienteEmail ;
   private String AV75TFPagoNubefactRequest_Sel ;
   private String AV74TFPagoNubefactRequest ;
   private String AV77TFPagoNubefactResponse_Sel ;
   private String AV76TFPagoNubefactResponse ;
   private String AV83TFPagoRequest_Sel ;
   private String AV82TFPagoRequest ;
   private String AV85TFPagoResponse_Sel ;
   private String AV84TFPagoResponse ;
   private String AV87TFPagoPasarelaId_Sel ;
   private String AV86TFPagoPasarelaId ;
   private String AV93TFPagoEnlacePDF_Sel ;
   private String AV92TFPagoEnlacePDF ;
   private String AV95TFPagoEnlaceXML_Sel ;
   private String AV94TFPagoEnlaceXML ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String AV105Pagowwds_1_filterfulltext ;
   private String AV110Pagowwds_6_tfcitacode ;
   private String AV111Pagowwds_7_tfcitacode_sel ;
   private String AV116Pagowwds_12_tfpagotoken ;
   private String AV117Pagowwds_13_tfpagotoken_sel ;
   private String AV119Pagowwds_15_tfpagoclientenrodocumento ;
   private String AV120Pagowwds_16_tfpagoclientenrodocumento_sel ;
   private String AV121Pagowwds_17_tfpagoclientedenominacion ;
   private String AV122Pagowwds_18_tfpagoclientedenominacion_sel ;
   private String AV123Pagowwds_19_tfpagoclientedireccion ;
   private String AV124Pagowwds_20_tfpagoclientedireccion_sel ;
   private String AV125Pagowwds_21_tfpagoclienteemail ;
   private String AV126Pagowwds_22_tfpagoclienteemail_sel ;
   private String AV133Pagowwds_29_tfpagonubefactrequest ;
   private String AV134Pagowwds_30_tfpagonubefactrequest_sel ;
   private String AV135Pagowwds_31_tfpagonubefactresponse ;
   private String AV136Pagowwds_32_tfpagonubefactresponse_sel ;
   private String AV137Pagowwds_33_tfpagorequest ;
   private String AV138Pagowwds_34_tfpagorequest_sel ;
   private String AV139Pagowwds_35_tfpagoresponse ;
   private String AV140Pagowwds_36_tfpagoresponse_sel ;
   private String AV141Pagowwds_37_tfpagopasarelaid ;
   private String AV142Pagowwds_38_tfpagopasarelaid_sel ;
   private String AV147Pagowwds_43_tfpagoenlacepdf ;
   private String AV148Pagowwds_44_tfpagoenlacepdf_sel ;
   private String AV149Pagowwds_45_tfpagoenlacexml ;
   private String AV150Pagowwds_46_tfpagoenlacexml_sel ;
   private String lV105Pagowwds_1_filterfulltext ;
   private String lV110Pagowwds_6_tfcitacode ;
   private String lV116Pagowwds_12_tfpagotoken ;
   private String lV119Pagowwds_15_tfpagoclientenrodocumento ;
   private String lV121Pagowwds_17_tfpagoclientedenominacion ;
   private String lV123Pagowwds_19_tfpagoclientedireccion ;
   private String lV125Pagowwds_21_tfpagoclienteemail ;
   private String lV133Pagowwds_29_tfpagonubefactrequest ;
   private String lV135Pagowwds_31_tfpagonubefactresponse ;
   private String lV137Pagowwds_33_tfpagorequest ;
   private String lV139Pagowwds_35_tfpagoresponse ;
   private String lV141Pagowwds_37_tfpagopasarelaid ;
   private String lV147Pagowwds_43_tfpagoenlacepdf ;
   private String lV149Pagowwds_45_tfpagoenlacexml ;
   private GXSimpleCollection<Short> AV59TFPagoTipoDocumento_Sels ;
   private GXSimpleCollection<Short> AV66TFPagoMoneda_Sels ;
   private GXSimpleCollection<Short> AV127Pagowwds_23_tfpagotipodocumento_sels ;
   private GXSimpleCollection<Short> AV132Pagowwds_28_tfpagomoneda_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV48TFPagoTipoDocumentoCliente_Sels ;
   private GXSimpleCollection<String> AV79TFPagoEstadoR_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P004R2_A21SGCitaDisponibilidadId ;
   private int[] P004R2_A34DisponibilidadId ;
   private boolean[] P004R2_n34DisponibilidadId ;
   private int[] P004R2_A311PagoStatusCode ;
   private java.util.Date[] P004R2_A252PagoFechaEmision ;
   private int[] P004R2_A245PagoNumero ;
   private java.math.BigDecimal[] P004R2_A242PagoMonto ;
   private java.util.Date[] P004R2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P004R2_n66SGCitaDisponibilidadFecha ;
   private int[] P004R2_A19CitaId ;
   private boolean[] P004R2_n19CitaId ;
   private int[] P004R2_A47PagoId ;
   private String[] P004R2_A246PagoEstadoR ;
   private String[] P004R2_A339PagoEnlaceXML ;
   private String[] P004R2_A338PagoEnlacePDF ;
   private String[] P004R2_A310PagoPasarelaId ;
   private String[] P004R2_A309PagoResponse ;
   private String[] P004R2_A308PagoRequest ;
   private String[] P004R2_A257PagoNubefactResponse ;
   private String[] P004R2_A256PagoNubefactRequest ;
   private short[] P004R2_A253PagoMoneda ;
   private short[] P004R2_A244PagoTipoDocumento ;
   private String[] P004R2_A251PagoClienteEmail ;
   private String[] P004R2_A250PagoClienteDireccion ;
   private String[] P004R2_A249PagoClienteDenominacion ;
   private String[] P004R2_A248PagoClienteNroDocumento ;
   private String[] P004R2_A247PagoTipoDocumentoCliente ;
   private String[] P004R2_A243PagoToken ;
   private String[] P004R2_A64CitaCode ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV118Pagowwds_14_tfpagotipodocumentocliente_sels ;
   private GXSimpleCollection<String> AV151Pagowwds_47_tfpagoestador_sels ;
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

final  class pagowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV118Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV127Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV132Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV151Pagowwds_47_tfpagoestador_sels ,
                                          String AV105Pagowwds_1_filterfulltext ,
                                          int AV106Pagowwds_2_tfpagoid ,
                                          int AV107Pagowwds_3_tfpagoid_to ,
                                          int AV108Pagowwds_4_tfcitaid ,
                                          int AV109Pagowwds_5_tfcitaid_to ,
                                          String AV111Pagowwds_7_tfcitacode_sel ,
                                          String AV110Pagowwds_6_tfcitacode ,
                                          java.util.Date AV112Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV114Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV115Pagowwds_11_tfpagomonto_to ,
                                          String AV117Pagowwds_13_tfpagotoken_sel ,
                                          String AV116Pagowwds_12_tfpagotoken ,
                                          int AV118Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV120Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV119Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV122Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV121Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV124Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV123Pagowwds_19_tfpagoclientedireccion ,
                                          String AV126Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV125Pagowwds_21_tfpagoclienteemail ,
                                          int AV127Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV128Pagowwds_24_tfpagonumero ,
                                          int AV129Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV130Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV131Pagowwds_27_tfpagofechaemision_to ,
                                          int AV132Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV134Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV133Pagowwds_29_tfpagonubefactrequest ,
                                          String AV136Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV135Pagowwds_31_tfpagonubefactresponse ,
                                          String AV138Pagowwds_34_tfpagorequest_sel ,
                                          String AV137Pagowwds_33_tfpagorequest ,
                                          String AV140Pagowwds_36_tfpagoresponse_sel ,
                                          String AV139Pagowwds_35_tfpagoresponse ,
                                          String AV142Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV141Pagowwds_37_tfpagopasarelaid ,
                                          int AV143Pagowwds_39_tfpagostatuscode ,
                                          int AV144Pagowwds_40_tfpagostatuscode_to ,
                                          int AV145Pagowwds_41_tfdisponibilidadid ,
                                          int AV146Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV148Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV147Pagowwds_43_tfpagoenlacepdf ,
                                          String AV150Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV149Pagowwds_45_tfpagoenlacexml ,
                                          int AV151Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[76];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoMonto]," ;
      scmdbuf += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV105Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
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
      }
      if ( ! (0==AV106Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( ! (0==AV107Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (0==AV108Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( ! (0==AV109Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV112Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV113Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV114Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV115Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV117Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV116Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV117Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( AV118Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV118Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV120Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV119Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int11[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV122Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV121Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int11[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV122Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int11[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV124Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV123Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int11[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int11[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV125Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int11[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int11[53] = (byte)(1) ;
      }
      if ( AV127Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV127Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV128Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int11[54] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int11[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV130Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int11[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV131Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int11[57] = (byte)(1) ;
      }
      if ( AV132Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV134Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV133Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int11[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV134Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int11[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV135Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int11[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int11[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV138Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV137Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int11[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV138Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int11[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV140Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV139Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int11[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV140Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int11[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV142Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV141Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int11[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV142Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int11[67] = (byte)(1) ;
      }
      if ( ! (0==AV143Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int11[68] = (byte)(1) ;
      }
      if ( ! (0==AV144Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int11[69] = (byte)(1) ;
      }
      if ( ! (0==AV145Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int11[70] = (byte)(1) ;
      }
      if ( ! (0==AV146Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int11[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV148Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV147Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int11[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV148Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int11[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV150Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV149Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int11[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV150Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int11[75] = (byte)(1) ;
      }
      if ( AV151Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV151Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoMonto]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoMonto] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoId] DESC" ;
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
         scmdbuf += " ORDER BY T2.[CitaCode]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[CitaCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[DisponibilidadFecha]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoToken]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoToken] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumentoCliente]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumentoCliente] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDenominacion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDenominacion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteEmail]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoClienteEmail] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoTipoDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNumero]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNumero] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoFechaEmision]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoFechaEmision] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoMoneda]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoMoneda] DESC" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactRequest]" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactRequest] DESC" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactResponse]" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoNubefactResponse] DESC" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoRequest]" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoRequest] DESC" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoResponse]" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoResponse] DESC" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoPasarelaId]" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoPasarelaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoStatusCode]" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoStatusCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId]" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DisponibilidadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlacePDF]" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlacePDF] DESC" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlaceXML]" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEnlaceXML] DESC" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PagoEstadoR]" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PagoEstadoR] DESC" ;
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
                  return conditional_P004R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] , ((Number) dynConstraints[76]).shortValue() , ((Boolean) dynConstraints[77]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
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
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
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
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
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
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
      }
   }

}

