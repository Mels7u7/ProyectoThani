package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pacientewwgetfilterdata extends GXProcedure
{
   public pacientewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacientewwgetfilterdata.class ), "" );
   }

   public pacientewwgetfilterdata( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      pacientewwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      pacientewwgetfilterdata.this.AV59DDOName = aP0;
      pacientewwgetfilterdata.this.AV57SearchTxt = aP1;
      pacientewwgetfilterdata.this.AV58SearchTxtTo = aP2;
      pacientewwgetfilterdata.this.aP3 = aP3;
      pacientewwgetfilterdata.this.aP4 = aP4;
      pacientewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV62Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      pacientewwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTEAPELLIDOPATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTEAPELLIDOMATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTENOMBRES") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTENOMBRESOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTENOMBRECOMPLETO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTENOMBRECOMPLETOOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTENRODOCUMENTO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTENRODOCUMENTOOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTEDIRECCION") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEDIRECCIONOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTECORREO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTECORREOOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTETELEFONO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTETELEFONOOPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PAISDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADPAISDESCRIPCIONOPTIONS' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_UBIGEOCODE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEOCODEOPTIONS' */
            S211 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_UBIGEONOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADUBIGEONOMBREOPTIONS' */
            S221 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTENOMBREANEXO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTENOMBREANEXOOPTIONS' */
            S231 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PACIENTEESPECIFIQUE") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEESPECIFIQUEOPTIONS' */
            S241 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV63OptionsJson = AV62Options.toJSonString(false) ;
      AV66OptionsDescJson = AV65OptionsDesc.toJSonString(false) ;
      AV68OptionIndexesJson = AV67OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV70Session.getValue("PacienteWWGridState"), "") == 0 )
      {
         AV72GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PacienteWWGridState"), null, null);
      }
      else
      {
         AV72GridState.fromxml(AV70Session.getValue("PacienteWWGridState"), null, null);
      }
      AV80GXV1 = 1 ;
      while ( AV80GXV1 <= AV72GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV73GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV72GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV1));
         if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV75FilterFullText = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV11TFPacienteId = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPacienteId_To = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV13TFPacienteApellidoPaterno = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV14TFPacienteApellidoPaterno_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV15TFPacienteApellidoMaterno = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV16TFPacienteApellidoMaterno_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV17TFPacienteNombres = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV18TFPacienteNombres_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO") == 0 )
         {
            AV19TFPacienteNombreCompleto = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRECOMPLETO_SEL") == 0 )
         {
            AV20TFPacienteNombreCompleto_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHANACIMIENTO") == 0 )
         {
            AV21TFPacienteFechaNacimiento = localUtil.ctod( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV22TFPacienteFechaNacimiento_To = localUtil.ctod( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETIPODOCUMENTO_SEL") == 0 )
         {
            AV23TFPacienteTipoDocumento_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFPacienteTipoDocumento_Sels.fromJSonString(AV23TFPacienteTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV25TFPacienteNroDocumento = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV26TFPacienteNroDocumento_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION") == 0 )
         {
            AV27TFPacienteDireccion = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEDIRECCION_SEL") == 0 )
         {
            AV28TFPacienteDireccion_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTESEXO_SEL") == 0 )
         {
            AV31TFPacienteSexo_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV32TFPacienteSexo_Sels.fromJSonString(AV31TFPacienteSexo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO") == 0 )
         {
            AV33TFPacienteCorreo = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTECORREO_SEL") == 0 )
         {
            AV34TFPacienteCorreo_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO") == 0 )
         {
            AV35TFPacienteTelefono = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTETELEFONO_SEL") == 0 )
         {
            AV36TFPacienteTelefono_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV37TFPaisId = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFPaisId_To = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV39TFPaisDescripcion = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV40TFPaisDescripcion_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTADO_SEL") == 0 )
         {
            AV41TFPacienteEstado_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFPacienteEstado_Sels.fromJSonString(AV41TFPacienteEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV43TFSecUserId = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV44TFSecUserId_To = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV45TFUbigeoCode = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV46TFUbigeoCode_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV47TFUbigeoNombre = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV48TFUbigeoNombre_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESTATURA") == 0 )
         {
            AV49TFPacienteEstatura = CommonUtil.decimalVal( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFPacienteEstatura_To = CommonUtil.decimalVal( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEPESO") == 0 )
         {
            AV51TFPacientePeso = CommonUtil.decimalVal( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFPacientePeso_To = CommonUtil.decimalVal( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO") == 0 )
         {
            AV53TFPacienteNombreAnexo = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBREANEXO_SEL") == 0 )
         {
            AV54TFPacienteNombreAnexo_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEENTERARSE_SEL") == 0 )
         {
            AV29TFPacienteEnterarse_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFPacienteEnterarse_Sels.fromJSonString(AV29TFPacienteEnterarse_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE") == 0 )
         {
            AV76TFPacienteEspecifique = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEESPECIFIQUE_SEL") == 0 )
         {
            AV77TFPacienteEspecifique_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEFECHAREGISTRO") == 0 )
         {
            AV55TFPacienteFechaRegistro = localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV56TFPacienteFechaRegistro_To = localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         AV80GXV1 = (int)(AV80GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV13TFPacienteApellidoPaterno = AV57SearchTxt ;
      AV14TFPacienteApellidoPaterno_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P2 */
      pr_default.execute(0, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2P2 = false ;
         A226PacienteFechaRegistro = P002P2_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P2_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P2_A220PacienteEstatura[0] ;
         A6SecUserId = P002P2_A6SecUserId[0] ;
         n6SecUserId = P002P2_n6SecUserId[0] ;
         A43PaisId = P002P2_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P2_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P2_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P2_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P2_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P2_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P2_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P2_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P2_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P2_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P2_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P2_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P2_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P2_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P2_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P2_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P2_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P2_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P2_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P2_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P2_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P2_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P2_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P2_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P2_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002P2_A103PacienteApellidoPaterno[0], A103PacienteApellidoPaterno) == 0 ) )
         {
            brk2P2 = false ;
            A20PacienteId = P002P2_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A103PacienteApellidoPaterno)==0) )
         {
            AV61Option = A103PacienteApellidoPaterno ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P2 )
         {
            brk2P2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV15TFPacienteApellidoMaterno = AV57SearchTxt ;
      AV16TFPacienteApellidoMaterno_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P3 */
      pr_default.execute(1, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2P4 = false ;
         A226PacienteFechaRegistro = P002P3_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P3_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P3_A220PacienteEstatura[0] ;
         A6SecUserId = P002P3_A6SecUserId[0] ;
         n6SecUserId = P002P3_n6SecUserId[0] ;
         A43PaisId = P002P3_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P3_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P3_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P3_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P3_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P3_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P3_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P3_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P3_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P3_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P3_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P3_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P3_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P3_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P3_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P3_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P3_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P3_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P3_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P3_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P3_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P3_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P3_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P3_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P3_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P3_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P3_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P3_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P3_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002P3_A104PacienteApellidoMaterno[0], A104PacienteApellidoMaterno) == 0 ) )
         {
            brk2P4 = false ;
            A20PacienteId = P002P3_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A104PacienteApellidoMaterno)==0) )
         {
            AV61Option = A104PacienteApellidoMaterno ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P4 )
         {
            brk2P4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPACIENTENOMBRESOPTIONS' Routine */
      returnInSub = false ;
      AV17TFPacienteNombres = AV57SearchTxt ;
      AV18TFPacienteNombres_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P4 */
      pr_default.execute(2, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2P6 = false ;
         A226PacienteFechaRegistro = P002P4_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P4_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P4_A220PacienteEstatura[0] ;
         A6SecUserId = P002P4_A6SecUserId[0] ;
         n6SecUserId = P002P4_n6SecUserId[0] ;
         A43PaisId = P002P4_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P4_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P4_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P4_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P4_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P4_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P4_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P4_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P4_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P4_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P4_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P4_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P4_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P4_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P4_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P4_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P4_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P4_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P4_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P4_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P4_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P4_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P4_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P4_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P4_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P4_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P4_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P4_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P4_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P002P4_A105PacienteNombres[0], A105PacienteNombres) == 0 ) )
         {
            brk2P6 = false ;
            A20PacienteId = P002P4_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A105PacienteNombres)==0) )
         {
            AV61Option = A105PacienteNombres ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P6 )
         {
            brk2P6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPACIENTENOMBRECOMPLETOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFPacienteNombreCompleto = AV57SearchTxt ;
      AV20TFPacienteNombreCompleto_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P5 */
      pr_default.execute(3, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A226PacienteFechaRegistro = P002P5_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P5_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P5_A220PacienteEstatura[0] ;
         A6SecUserId = P002P5_A6SecUserId[0] ;
         n6SecUserId = P002P5_n6SecUserId[0] ;
         A43PaisId = P002P5_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P5_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P5_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P5_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P5_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P5_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P5_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P5_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P5_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P5_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P5_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P5_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P5_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P5_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P5_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P5_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P5_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P5_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P5_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P5_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P5_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P5_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P5_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P5_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P5_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P5_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P5_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P5_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P5_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         if ( ! (GXutil.strcmp("", A212PacienteNombreCompleto)==0) )
         {
            AV61Option = A212PacienteNombreCompleto ;
            AV60InsertIndex = 1 ;
            while ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) < 0 ) )
            {
               AV60InsertIndex = (int)(AV60InsertIndex+1) ;
            }
            if ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) == 0 ) )
            {
               AV69count = GXutil.lval( (String)AV67OptionIndexes.elementAt(-1+AV60InsertIndex)) ;
               AV69count = (long)(AV69count+1) ;
               AV67OptionIndexes.removeItem(AV60InsertIndex);
               AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), AV60InsertIndex);
            }
            else
            {
               AV62Options.add(AV61Option, AV60InsertIndex);
               AV67OptionIndexes.add("1", AV60InsertIndex);
            }
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADPACIENTENRODOCUMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV25TFPacienteNroDocumento = AV57SearchTxt ;
      AV26TFPacienteNroDocumento_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P6 */
      pr_default.execute(4, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk2P9 = false ;
         A106PacienteNroDocumento = P002P6_A106PacienteNroDocumento[0] ;
         A226PacienteFechaRegistro = P002P6_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P6_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P6_A220PacienteEstatura[0] ;
         A6SecUserId = P002P6_A6SecUserId[0] ;
         n6SecUserId = P002P6_n6SecUserId[0] ;
         A43PaisId = P002P6_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P6_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P6_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P6_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P6_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P6_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P6_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P6_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P6_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P6_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P6_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P6_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P6_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P6_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P6_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P6_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P6_A215PacienteDireccion[0] ;
         A214PacienteTipoDocumento = P002P6_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P6_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P6_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P6_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P6_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P6_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P6_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P6_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P6_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P6_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P6_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P002P6_A106PacienteNroDocumento[0], A106PacienteNroDocumento) == 0 ) )
         {
            brk2P9 = false ;
            A20PacienteId = P002P6_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P9 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A106PacienteNroDocumento)==0) )
         {
            AV61Option = A106PacienteNroDocumento ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P9 )
         {
            brk2P9 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADPACIENTEDIRECCIONOPTIONS' Routine */
      returnInSub = false ;
      AV27TFPacienteDireccion = AV57SearchTxt ;
      AV28TFPacienteDireccion_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P7 */
      pr_default.execute(5, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk2P11 = false ;
         A215PacienteDireccion = P002P7_A215PacienteDireccion[0] ;
         A226PacienteFechaRegistro = P002P7_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P7_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P7_A220PacienteEstatura[0] ;
         A6SecUserId = P002P7_A6SecUserId[0] ;
         n6SecUserId = P002P7_n6SecUserId[0] ;
         A43PaisId = P002P7_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P7_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P7_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P7_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P7_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P7_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P7_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P7_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P7_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P7_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P7_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P7_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P7_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P7_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P7_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P7_A216PacienteSexo[0] ;
         A106PacienteNroDocumento = P002P7_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P7_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P7_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P7_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P7_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P7_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P7_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P7_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P7_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P7_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P7_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P7_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P002P7_A215PacienteDireccion[0], A215PacienteDireccion) == 0 ) )
         {
            brk2P11 = false ;
            A20PacienteId = P002P7_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P11 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A215PacienteDireccion)==0) )
         {
            AV61Option = A215PacienteDireccion ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P11 )
         {
            brk2P11 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADPACIENTECORREOOPTIONS' Routine */
      returnInSub = false ;
      AV33TFPacienteCorreo = AV57SearchTxt ;
      AV34TFPacienteCorreo_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P8 */
      pr_default.execute(6, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk2P13 = false ;
         A217PacienteCorreo = P002P8_A217PacienteCorreo[0] ;
         A226PacienteFechaRegistro = P002P8_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P8_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P8_A220PacienteEstatura[0] ;
         A6SecUserId = P002P8_A6SecUserId[0] ;
         n6SecUserId = P002P8_n6SecUserId[0] ;
         A43PaisId = P002P8_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P8_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P8_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P8_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P8_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P8_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P8_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P8_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P8_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P8_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P8_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P8_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P8_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P8_A218PacienteTelefono[0] ;
         A216PacienteSexo = P002P8_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P8_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P8_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P8_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P8_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P8_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P8_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P8_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P8_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P8_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P8_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P8_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P8_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P8_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P002P8_A217PacienteCorreo[0], A217PacienteCorreo) == 0 ) )
         {
            brk2P13 = false ;
            A20PacienteId = P002P8_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P13 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A217PacienteCorreo)==0) )
         {
            AV61Option = A217PacienteCorreo ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P13 )
         {
            brk2P13 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADPACIENTETELEFONOOPTIONS' Routine */
      returnInSub = false ;
      AV35TFPacienteTelefono = AV57SearchTxt ;
      AV36TFPacienteTelefono_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P9 */
      pr_default.execute(7, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk2P15 = false ;
         A218PacienteTelefono = P002P9_A218PacienteTelefono[0] ;
         A226PacienteFechaRegistro = P002P9_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P9_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P9_A220PacienteEstatura[0] ;
         A6SecUserId = P002P9_A6SecUserId[0] ;
         n6SecUserId = P002P9_n6SecUserId[0] ;
         A43PaisId = P002P9_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P9_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P9_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P9_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P9_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P9_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P9_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P9_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P9_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P9_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P9_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P9_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P9_A184PaisDescripcion[0] ;
         A217PacienteCorreo = P002P9_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P9_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P9_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P9_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P9_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P9_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P9_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P9_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P9_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P9_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P9_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P9_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P9_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P9_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P9_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P002P9_A218PacienteTelefono[0], A218PacienteTelefono) == 0 ) )
         {
            brk2P15 = false ;
            A20PacienteId = P002P9_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P15 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A218PacienteTelefono)==0) )
         {
            AV61Option = A218PacienteTelefono ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P15 )
         {
            brk2P15 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADPAISDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV39TFPaisDescripcion = AV57SearchTxt ;
      AV40TFPaisDescripcion_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P10 */
      pr_default.execute(8, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(8) != 101) )
      {
         brk2P17 = false ;
         A43PaisId = P002P10_A43PaisId[0] ;
         A226PacienteFechaRegistro = P002P10_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P10_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P10_A220PacienteEstatura[0] ;
         A6SecUserId = P002P10_A6SecUserId[0] ;
         n6SecUserId = P002P10_n6SecUserId[0] ;
         A213PacienteFechaNacimiento = P002P10_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P10_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P10_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P10_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P10_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P10_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P10_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P10_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P10_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P10_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P10_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P10_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P10_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P10_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P10_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P10_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P10_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P10_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P10_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P10_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P10_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P10_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P10_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P10_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P10_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P10_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P10_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P10_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(8) != 101) && ( P002P10_A43PaisId[0] == A43PaisId ) )
         {
            brk2P17 = false ;
            A20PacienteId = P002P10_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P17 = true ;
            pr_default.readNext(8);
         }
         if ( ! (GXutil.strcmp("", A184PaisDescripcion)==0) )
         {
            AV61Option = A184PaisDescripcion ;
            AV60InsertIndex = 1 ;
            while ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) < 0 ) )
            {
               AV60InsertIndex = (int)(AV60InsertIndex+1) ;
            }
            AV62Options.add(AV61Option, AV60InsertIndex);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), AV60InsertIndex);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P17 )
         {
            brk2P17 = true ;
            pr_default.readNext(8);
         }
      }
      pr_default.close(8);
   }

   public void S211( )
   {
      /* 'LOADUBIGEOCODEOPTIONS' Routine */
      returnInSub = false ;
      AV45TFUbigeoCode = AV57SearchTxt ;
      AV46TFUbigeoCode_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P11 */
      pr_default.execute(9, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(9) != 101) )
      {
         brk2P19 = false ;
         A44UbigeoCode = P002P11_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P11_n44UbigeoCode[0] ;
         A226PacienteFechaRegistro = P002P11_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P11_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P11_A220PacienteEstatura[0] ;
         A6SecUserId = P002P11_A6SecUserId[0] ;
         n6SecUserId = P002P11_n6SecUserId[0] ;
         A43PaisId = P002P11_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P11_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P11_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P11_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P11_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P11_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P11_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P11_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P11_n222PacienteNombreAnexo[0] ;
         A219PacienteEstado = P002P11_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P11_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P11_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P11_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P11_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P11_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P11_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P11_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P11_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P11_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P11_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P11_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P11_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P11_A186UbigeoDepartamento[0] ;
         A188UbigeoDistrito = P002P11_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P11_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P11_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P11_A184PaisDescripcion[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(9) != 101) && ( GXutil.strcmp(P002P11_A44UbigeoCode[0], A44UbigeoCode) == 0 ) )
         {
            brk2P19 = false ;
            A20PacienteId = P002P11_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P19 = true ;
            pr_default.readNext(9);
         }
         if ( ! (GXutil.strcmp("", A44UbigeoCode)==0) )
         {
            AV61Option = A44UbigeoCode ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P19 )
         {
            brk2P19 = true ;
            pr_default.readNext(9);
         }
      }
      pr_default.close(9);
   }

   public void S221( )
   {
      /* 'LOADUBIGEONOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV47TFUbigeoNombre = AV57SearchTxt ;
      AV48TFUbigeoNombre_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(10, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P12 */
      pr_default.execute(10, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(10) != 101) )
      {
         brk2P21 = false ;
         A44UbigeoCode = P002P12_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P12_n44UbigeoCode[0] ;
         A226PacienteFechaRegistro = P002P12_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P12_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P12_A220PacienteEstatura[0] ;
         A6SecUserId = P002P12_A6SecUserId[0] ;
         n6SecUserId = P002P12_n6SecUserId[0] ;
         A43PaisId = P002P12_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P12_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P12_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P12_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P12_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P12_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P12_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P12_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P12_n222PacienteNombreAnexo[0] ;
         A219PacienteEstado = P002P12_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P12_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P12_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P12_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P12_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P12_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P12_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P12_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P12_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P12_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P12_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P12_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P12_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P12_A186UbigeoDepartamento[0] ;
         A188UbigeoDistrito = P002P12_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P12_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P12_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P12_A184PaisDescripcion[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(10) != 101) && ( GXutil.strcmp(P002P12_A44UbigeoCode[0], A44UbigeoCode) == 0 ) )
         {
            brk2P21 = false ;
            A20PacienteId = P002P12_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P21 = true ;
            pr_default.readNext(10);
         }
         if ( ! (GXutil.strcmp("", A185UbigeoNombre)==0) )
         {
            AV61Option = A185UbigeoNombre ;
            AV60InsertIndex = 1 ;
            while ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) < 0 ) )
            {
               AV60InsertIndex = (int)(AV60InsertIndex+1) ;
            }
            AV62Options.add(AV61Option, AV60InsertIndex);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), AV60InsertIndex);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P21 )
         {
            brk2P21 = true ;
            pr_default.readNext(10);
         }
      }
      pr_default.close(10);
   }

   public void S231( )
   {
      /* 'LOADPACIENTENOMBREANEXOOPTIONS' Routine */
      returnInSub = false ;
      AV53TFPacienteNombreAnexo = AV57SearchTxt ;
      AV54TFPacienteNombreAnexo_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(11, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P13 */
      pr_default.execute(11, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(11) != 101) )
      {
         brk2P23 = false ;
         A222PacienteNombreAnexo = P002P13_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P13_n222PacienteNombreAnexo[0] ;
         A226PacienteFechaRegistro = P002P13_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P13_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P13_A220PacienteEstatura[0] ;
         A6SecUserId = P002P13_A6SecUserId[0] ;
         n6SecUserId = P002P13_n6SecUserId[0] ;
         A43PaisId = P002P13_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P13_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P13_A20PacienteId[0] ;
         A225PacienteEspecifique = P002P13_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P13_n225PacienteEspecifique[0] ;
         A224PacienteEnterarse = P002P13_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P13_n224PacienteEnterarse[0] ;
         A44UbigeoCode = P002P13_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P13_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P13_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P13_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P13_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P13_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P13_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P13_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P13_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P13_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P13_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P13_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P13_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P13_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P13_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P13_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P13_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P13_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P13_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P13_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(11) != 101) && ( GXutil.strcmp(P002P13_A222PacienteNombreAnexo[0], A222PacienteNombreAnexo) == 0 ) )
         {
            brk2P23 = false ;
            A20PacienteId = P002P13_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P23 = true ;
            pr_default.readNext(11);
         }
         if ( ! (GXutil.strcmp("", A222PacienteNombreAnexo)==0) )
         {
            AV61Option = A222PacienteNombreAnexo ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P23 )
         {
            brk2P23 = true ;
            pr_default.readNext(11);
         }
      }
      pr_default.close(11);
   }

   public void S241( )
   {
      /* 'LOADPACIENTEESPECIFIQUEOPTIONS' Routine */
      returnInSub = false ;
      AV76TFPacienteEspecifique = AV57SearchTxt ;
      AV77TFPacienteEspecifique_Sel = "" ;
      AV82Pacientewwds_1_filterfulltext = AV75FilterFullText ;
      AV83Pacientewwds_2_tfpacienteid = AV11TFPacienteId ;
      AV84Pacientewwds_3_tfpacienteid_to = AV12TFPacienteId_To ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = AV13TFPacienteApellidoPaterno ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = AV14TFPacienteApellidoPaterno_Sel ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = AV15TFPacienteApellidoMaterno ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = AV16TFPacienteApellidoMaterno_Sel ;
      AV89Pacientewwds_8_tfpacientenombres = AV17TFPacienteNombres ;
      AV90Pacientewwds_9_tfpacientenombres_sel = AV18TFPacienteNombres_Sel ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = AV19TFPacienteNombreCompleto ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = AV20TFPacienteNombreCompleto_Sel ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = AV21TFPacienteFechaNacimiento ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = AV22TFPacienteFechaNacimiento_To ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = AV24TFPacienteTipoDocumento_Sels ;
      AV96Pacientewwds_15_tfpacientenrodocumento = AV25TFPacienteNroDocumento ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = AV26TFPacienteNroDocumento_Sel ;
      AV98Pacientewwds_17_tfpacientedireccion = AV27TFPacienteDireccion ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = AV28TFPacienteDireccion_Sel ;
      AV100Pacientewwds_19_tfpacientesexo_sels = AV32TFPacienteSexo_Sels ;
      AV101Pacientewwds_20_tfpacientecorreo = AV33TFPacienteCorreo ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = AV34TFPacienteCorreo_Sel ;
      AV103Pacientewwds_22_tfpacientetelefono = AV35TFPacienteTelefono ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = AV36TFPacienteTelefono_Sel ;
      AV105Pacientewwds_24_tfpaisid = AV37TFPaisId ;
      AV106Pacientewwds_25_tfpaisid_to = AV38TFPaisId_To ;
      AV107Pacientewwds_26_tfpaisdescripcion = AV39TFPaisDescripcion ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = AV40TFPaisDescripcion_Sel ;
      AV109Pacientewwds_28_tfpacienteestado_sels = AV42TFPacienteEstado_Sels ;
      AV110Pacientewwds_29_tfsecuserid = AV43TFSecUserId ;
      AV111Pacientewwds_30_tfsecuserid_to = AV44TFSecUserId_To ;
      AV112Pacientewwds_31_tfubigeocode = AV45TFUbigeoCode ;
      AV113Pacientewwds_32_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV114Pacientewwds_33_tfubigeonombre = AV47TFUbigeoNombre ;
      AV115Pacientewwds_34_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV116Pacientewwds_35_tfpacienteestatura = AV49TFPacienteEstatura ;
      AV117Pacientewwds_36_tfpacienteestatura_to = AV50TFPacienteEstatura_To ;
      AV118Pacientewwds_37_tfpacientepeso = AV51TFPacientePeso ;
      AV119Pacientewwds_38_tfpacientepeso_to = AV52TFPacientePeso_To ;
      AV120Pacientewwds_39_tfpacientenombreanexo = AV53TFPacienteNombreAnexo ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = AV54TFPacienteNombreAnexo_Sel ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = AV30TFPacienteEnterarse_Sels ;
      AV123Pacientewwds_42_tfpacienteespecifique = AV76TFPacienteEspecifique ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = AV77TFPacienteEspecifique_Sel ;
      AV125Pacientewwds_44_tfpacientefecharegistro = AV55TFPacienteFechaRegistro ;
      AV126Pacientewwds_45_tfpacientefecharegistro_to = AV56TFPacienteFechaRegistro_To ;
      pr_default.dynParam(12, new Object[]{ new Object[]{
                                           A214PacienteTipoDocumento ,
                                           AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           A216PacienteSexo ,
                                           AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           A219PacienteEstado ,
                                           AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           A224PacienteEnterarse ,
                                           AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           AV82Pacientewwds_1_filterfulltext ,
                                           Integer.valueOf(AV83Pacientewwds_2_tfpacienteid) ,
                                           Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to) ,
                                           AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           AV89Pacientewwds_8_tfpacientenombres ,
                                           AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           Integer.valueOf(AV95Pacientewwds_14_tfpacientetipodocumento_sels.size()) ,
                                           AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           AV98Pacientewwds_17_tfpacientedireccion ,
                                           Integer.valueOf(AV100Pacientewwds_19_tfpacientesexo_sels.size()) ,
                                           AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           AV101Pacientewwds_20_tfpacientecorreo ,
                                           AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           AV103Pacientewwds_22_tfpacientetelefono ,
                                           Short.valueOf(AV105Pacientewwds_24_tfpaisid) ,
                                           Short.valueOf(AV106Pacientewwds_25_tfpaisid_to) ,
                                           AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           AV107Pacientewwds_26_tfpaisdescripcion ,
                                           Integer.valueOf(AV109Pacientewwds_28_tfpacienteestado_sels.size()) ,
                                           Short.valueOf(AV110Pacientewwds_29_tfsecuserid) ,
                                           Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to) ,
                                           AV113Pacientewwds_32_tfubigeocode_sel ,
                                           AV112Pacientewwds_31_tfubigeocode ,
                                           AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           AV114Pacientewwds_33_tfubigeonombre ,
                                           AV116Pacientewwds_35_tfpacienteestatura ,
                                           AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           AV118Pacientewwds_37_tfpacientepeso ,
                                           AV119Pacientewwds_38_tfpacientepeso_to ,
                                           AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           Integer.valueOf(AV122Pacientewwds_41_tfpacienteenterarse_sels.size()) ,
                                           AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           AV123Pacientewwds_42_tfpacienteespecifique ,
                                           AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           A226PacienteFechaRegistro } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV82Pacientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Pacientewwds_1_filterfulltext), "%", "") ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV85Pacientewwds_4_tfpacienteapellidopaterno), "%", "") ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV87Pacientewwds_6_tfpacienteapellidomaterno), "%", "") ;
      lV89Pacientewwds_8_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV89Pacientewwds_8_tfpacientenombres), "%", "") ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = GXutil.concat( GXutil.rtrim( AV91Pacientewwds_10_tfpacientenombrecompleto), "%", "") ;
      lV96Pacientewwds_15_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV96Pacientewwds_15_tfpacientenrodocumento), "%", "") ;
      lV98Pacientewwds_17_tfpacientedireccion = GXutil.concat( GXutil.rtrim( AV98Pacientewwds_17_tfpacientedireccion), "%", "") ;
      lV101Pacientewwds_20_tfpacientecorreo = GXutil.concat( GXutil.rtrim( AV101Pacientewwds_20_tfpacientecorreo), "%", "") ;
      lV103Pacientewwds_22_tfpacientetelefono = GXutil.padr( GXutil.rtrim( AV103Pacientewwds_22_tfpacientetelefono), 20, "%") ;
      lV107Pacientewwds_26_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV107Pacientewwds_26_tfpaisdescripcion), "%", "") ;
      lV112Pacientewwds_31_tfubigeocode = GXutil.padr( GXutil.rtrim( AV112Pacientewwds_31_tfubigeocode), 10, "%") ;
      lV114Pacientewwds_33_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV114Pacientewwds_33_tfubigeonombre), "%", "") ;
      lV120Pacientewwds_39_tfpacientenombreanexo = GXutil.concat( GXutil.rtrim( AV120Pacientewwds_39_tfpacientenombreanexo), "%", "") ;
      lV123Pacientewwds_42_tfpacienteespecifique = GXutil.concat( GXutil.rtrim( AV123Pacientewwds_42_tfpacienteespecifique), "%", "") ;
      /* Using cursor P002P14 */
      pr_default.execute(12, new Object[] {lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, lV82Pacientewwds_1_filterfulltext, Integer.valueOf(AV83Pacientewwds_2_tfpacienteid), Integer.valueOf(AV84Pacientewwds_3_tfpacienteid_to), lV85Pacientewwds_4_tfpacienteapellidopaterno, AV86Pacientewwds_5_tfpacienteapellidopaterno_sel, lV87Pacientewwds_6_tfpacienteapellidomaterno, AV88Pacientewwds_7_tfpacienteapellidomaterno_sel, lV89Pacientewwds_8_tfpacientenombres, AV90Pacientewwds_9_tfpacientenombres_sel, lV91Pacientewwds_10_tfpacientenombrecompleto, AV92Pacientewwds_11_tfpacientenombrecompleto_sel, AV93Pacientewwds_12_tfpacientefechanacimiento, AV94Pacientewwds_13_tfpacientefechanacimiento_to, lV96Pacientewwds_15_tfpacientenrodocumento, AV97Pacientewwds_16_tfpacientenrodocumento_sel, lV98Pacientewwds_17_tfpacientedireccion, AV99Pacientewwds_18_tfpacientedireccion_sel, lV101Pacientewwds_20_tfpacientecorreo, AV102Pacientewwds_21_tfpacientecorreo_sel, lV103Pacientewwds_22_tfpacientetelefono, AV104Pacientewwds_23_tfpacientetelefono_sel, Short.valueOf(AV105Pacientewwds_24_tfpaisid), Short.valueOf(AV106Pacientewwds_25_tfpaisid_to), lV107Pacientewwds_26_tfpaisdescripcion, AV108Pacientewwds_27_tfpaisdescripcion_sel, Short.valueOf(AV110Pacientewwds_29_tfsecuserid), Short.valueOf(AV111Pacientewwds_30_tfsecuserid_to), lV112Pacientewwds_31_tfubigeocode, AV113Pacientewwds_32_tfubigeocode_sel, lV114Pacientewwds_33_tfubigeonombre, AV115Pacientewwds_34_tfubigeonombre_sel, AV116Pacientewwds_35_tfpacienteestatura, AV117Pacientewwds_36_tfpacienteestatura_to, AV118Pacientewwds_37_tfpacientepeso, AV119Pacientewwds_38_tfpacientepeso_to, lV120Pacientewwds_39_tfpacientenombreanexo, AV121Pacientewwds_40_tfpacientenombreanexo_sel, lV123Pacientewwds_42_tfpacienteespecifique, AV124Pacientewwds_43_tfpacienteespecifique_sel, AV125Pacientewwds_44_tfpacientefecharegistro, AV126Pacientewwds_45_tfpacientefecharegistro_to});
      while ( (pr_default.getStatus(12) != 101) )
      {
         brk2P25 = false ;
         A225PacienteEspecifique = P002P14_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = P002P14_n225PacienteEspecifique[0] ;
         A226PacienteFechaRegistro = P002P14_A226PacienteFechaRegistro[0] ;
         A221PacientePeso = P002P14_A221PacientePeso[0] ;
         A220PacienteEstatura = P002P14_A220PacienteEstatura[0] ;
         A6SecUserId = P002P14_A6SecUserId[0] ;
         n6SecUserId = P002P14_n6SecUserId[0] ;
         A43PaisId = P002P14_A43PaisId[0] ;
         A213PacienteFechaNacimiento = P002P14_A213PacienteFechaNacimiento[0] ;
         A20PacienteId = P002P14_A20PacienteId[0] ;
         A224PacienteEnterarse = P002P14_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = P002P14_n224PacienteEnterarse[0] ;
         A222PacienteNombreAnexo = P002P14_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = P002P14_n222PacienteNombreAnexo[0] ;
         A44UbigeoCode = P002P14_A44UbigeoCode[0] ;
         n44UbigeoCode = P002P14_n44UbigeoCode[0] ;
         A219PacienteEstado = P002P14_A219PacienteEstado[0] ;
         A184PaisDescripcion = P002P14_A184PaisDescripcion[0] ;
         A218PacienteTelefono = P002P14_A218PacienteTelefono[0] ;
         A217PacienteCorreo = P002P14_A217PacienteCorreo[0] ;
         A216PacienteSexo = P002P14_A216PacienteSexo[0] ;
         A215PacienteDireccion = P002P14_A215PacienteDireccion[0] ;
         A106PacienteNroDocumento = P002P14_A106PacienteNroDocumento[0] ;
         A214PacienteTipoDocumento = P002P14_A214PacienteTipoDocumento[0] ;
         A105PacienteNombres = P002P14_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P002P14_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P002P14_A103PacienteApellidoPaterno[0] ;
         A188UbigeoDistrito = P002P14_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P14_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P14_A186UbigeoDepartamento[0] ;
         A184PaisDescripcion = P002P14_A184PaisDescripcion[0] ;
         A188UbigeoDistrito = P002P14_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P002P14_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P002P14_A186UbigeoDepartamento[0] ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(12) != 101) && ( GXutil.strcmp(P002P14_A225PacienteEspecifique[0], A225PacienteEspecifique) == 0 ) )
         {
            brk2P25 = false ;
            A20PacienteId = P002P14_A20PacienteId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2P25 = true ;
            pr_default.readNext(12);
         }
         if ( ! (GXutil.strcmp("", A225PacienteEspecifique)==0) )
         {
            AV61Option = A225PacienteEspecifique ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2P25 )
         {
            brk2P25 = true ;
            pr_default.readNext(12);
         }
      }
      pr_default.close(12);
   }

   protected void cleanup( )
   {
      this.aP3[0] = pacientewwgetfilterdata.this.AV63OptionsJson;
      this.aP4[0] = pacientewwgetfilterdata.this.AV66OptionsDescJson;
      this.aP5[0] = pacientewwgetfilterdata.this.AV68OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV63OptionsJson = "" ;
      AV66OptionsDescJson = "" ;
      AV68OptionIndexesJson = "" ;
      AV62Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV70Session = httpContext.getWebSession();
      AV72GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV73GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV75FilterFullText = "" ;
      AV13TFPacienteApellidoPaterno = "" ;
      AV14TFPacienteApellidoPaterno_Sel = "" ;
      AV15TFPacienteApellidoMaterno = "" ;
      AV16TFPacienteApellidoMaterno_Sel = "" ;
      AV17TFPacienteNombres = "" ;
      AV18TFPacienteNombres_Sel = "" ;
      AV19TFPacienteNombreCompleto = "" ;
      AV20TFPacienteNombreCompleto_Sel = "" ;
      AV21TFPacienteFechaNacimiento = GXutil.nullDate() ;
      AV22TFPacienteFechaNacimiento_To = GXutil.nullDate() ;
      AV23TFPacienteTipoDocumento_SelsJson = "" ;
      AV24TFPacienteTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFPacienteNroDocumento = "" ;
      AV26TFPacienteNroDocumento_Sel = "" ;
      AV27TFPacienteDireccion = "" ;
      AV28TFPacienteDireccion_Sel = "" ;
      AV31TFPacienteSexo_SelsJson = "" ;
      AV32TFPacienteSexo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33TFPacienteCorreo = "" ;
      AV34TFPacienteCorreo_Sel = "" ;
      AV35TFPacienteTelefono = "" ;
      AV36TFPacienteTelefono_Sel = "" ;
      AV39TFPaisDescripcion = "" ;
      AV40TFPaisDescripcion_Sel = "" ;
      AV41TFPacienteEstado_SelsJson = "" ;
      AV42TFPacienteEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFUbigeoCode = "" ;
      AV46TFUbigeoCode_Sel = "" ;
      AV47TFUbigeoNombre = "" ;
      AV48TFUbigeoNombre_Sel = "" ;
      AV49TFPacienteEstatura = DecimalUtil.ZERO ;
      AV50TFPacienteEstatura_To = DecimalUtil.ZERO ;
      AV51TFPacientePeso = DecimalUtil.ZERO ;
      AV52TFPacientePeso_To = DecimalUtil.ZERO ;
      AV53TFPacienteNombreAnexo = "" ;
      AV54TFPacienteNombreAnexo_Sel = "" ;
      AV29TFPacienteEnterarse_SelsJson = "" ;
      AV30TFPacienteEnterarse_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFPacienteEspecifique = "" ;
      AV77TFPacienteEspecifique_Sel = "" ;
      AV55TFPacienteFechaRegistro = GXutil.now( ) ;
      AV56TFPacienteFechaRegistro_To = GXutil.now( ) ;
      A103PacienteApellidoPaterno = "" ;
      AV82Pacientewwds_1_filterfulltext = "" ;
      AV85Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      AV86Pacientewwds_5_tfpacienteapellidopaterno_sel = "" ;
      AV87Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      AV88Pacientewwds_7_tfpacienteapellidomaterno_sel = "" ;
      AV89Pacientewwds_8_tfpacientenombres = "" ;
      AV90Pacientewwds_9_tfpacientenombres_sel = "" ;
      AV91Pacientewwds_10_tfpacientenombrecompleto = "" ;
      AV92Pacientewwds_11_tfpacientenombrecompleto_sel = "" ;
      AV93Pacientewwds_12_tfpacientefechanacimiento = GXutil.nullDate() ;
      AV94Pacientewwds_13_tfpacientefechanacimiento_to = GXutil.nullDate() ;
      AV95Pacientewwds_14_tfpacientetipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Pacientewwds_15_tfpacientenrodocumento = "" ;
      AV97Pacientewwds_16_tfpacientenrodocumento_sel = "" ;
      AV98Pacientewwds_17_tfpacientedireccion = "" ;
      AV99Pacientewwds_18_tfpacientedireccion_sel = "" ;
      AV100Pacientewwds_19_tfpacientesexo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101Pacientewwds_20_tfpacientecorreo = "" ;
      AV102Pacientewwds_21_tfpacientecorreo_sel = "" ;
      AV103Pacientewwds_22_tfpacientetelefono = "" ;
      AV104Pacientewwds_23_tfpacientetelefono_sel = "" ;
      AV107Pacientewwds_26_tfpaisdescripcion = "" ;
      AV108Pacientewwds_27_tfpaisdescripcion_sel = "" ;
      AV109Pacientewwds_28_tfpacienteestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV112Pacientewwds_31_tfubigeocode = "" ;
      AV113Pacientewwds_32_tfubigeocode_sel = "" ;
      AV114Pacientewwds_33_tfubigeonombre = "" ;
      AV115Pacientewwds_34_tfubigeonombre_sel = "" ;
      AV116Pacientewwds_35_tfpacienteestatura = DecimalUtil.ZERO ;
      AV117Pacientewwds_36_tfpacienteestatura_to = DecimalUtil.ZERO ;
      AV118Pacientewwds_37_tfpacientepeso = DecimalUtil.ZERO ;
      AV119Pacientewwds_38_tfpacientepeso_to = DecimalUtil.ZERO ;
      AV120Pacientewwds_39_tfpacientenombreanexo = "" ;
      AV121Pacientewwds_40_tfpacientenombreanexo_sel = "" ;
      AV122Pacientewwds_41_tfpacienteenterarse_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123Pacientewwds_42_tfpacienteespecifique = "" ;
      AV124Pacientewwds_43_tfpacienteespecifique_sel = "" ;
      AV125Pacientewwds_44_tfpacientefecharegistro = GXutil.resetTime( GXutil.nullDate() );
      AV126Pacientewwds_45_tfpacientefecharegistro_to = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV82Pacientewwds_1_filterfulltext = "" ;
      lV85Pacientewwds_4_tfpacienteapellidopaterno = "" ;
      lV87Pacientewwds_6_tfpacienteapellidomaterno = "" ;
      lV89Pacientewwds_8_tfpacientenombres = "" ;
      lV91Pacientewwds_10_tfpacientenombrecompleto = "" ;
      lV96Pacientewwds_15_tfpacientenrodocumento = "" ;
      lV98Pacientewwds_17_tfpacientedireccion = "" ;
      lV101Pacientewwds_20_tfpacientecorreo = "" ;
      lV103Pacientewwds_22_tfpacientetelefono = "" ;
      lV107Pacientewwds_26_tfpaisdescripcion = "" ;
      lV112Pacientewwds_31_tfubigeocode = "" ;
      lV114Pacientewwds_33_tfubigeonombre = "" ;
      lV120Pacientewwds_39_tfpacientenombreanexo = "" ;
      lV123Pacientewwds_42_tfpacienteespecifique = "" ;
      A214PacienteTipoDocumento = "" ;
      A216PacienteSexo = "" ;
      A219PacienteEstado = "" ;
      A224PacienteEnterarse = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      A225PacienteEspecifique = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      P002P2_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P2_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P2_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P2_A6SecUserId = new short[1] ;
      P002P2_n6SecUserId = new boolean[] {false} ;
      P002P2_A43PaisId = new short[1] ;
      P002P2_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P2_A20PacienteId = new int[1] ;
      P002P2_A225PacienteEspecifique = new String[] {""} ;
      P002P2_n225PacienteEspecifique = new boolean[] {false} ;
      P002P2_A224PacienteEnterarse = new String[] {""} ;
      P002P2_n224PacienteEnterarse = new boolean[] {false} ;
      P002P2_A222PacienteNombreAnexo = new String[] {""} ;
      P002P2_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P2_A44UbigeoCode = new String[] {""} ;
      P002P2_n44UbigeoCode = new boolean[] {false} ;
      P002P2_A219PacienteEstado = new String[] {""} ;
      P002P2_A184PaisDescripcion = new String[] {""} ;
      P002P2_A218PacienteTelefono = new String[] {""} ;
      P002P2_A217PacienteCorreo = new String[] {""} ;
      P002P2_A216PacienteSexo = new String[] {""} ;
      P002P2_A215PacienteDireccion = new String[] {""} ;
      P002P2_A106PacienteNroDocumento = new String[] {""} ;
      P002P2_A214PacienteTipoDocumento = new String[] {""} ;
      P002P2_A105PacienteNombres = new String[] {""} ;
      P002P2_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P2_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P2_A188UbigeoDistrito = new String[] {""} ;
      P002P2_A187UbigeoProvincia = new String[] {""} ;
      P002P2_A186UbigeoDepartamento = new String[] {""} ;
      A212PacienteNombreCompleto = "" ;
      A185UbigeoNombre = "" ;
      AV61Option = "" ;
      P002P3_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P3_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P3_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P3_A6SecUserId = new short[1] ;
      P002P3_n6SecUserId = new boolean[] {false} ;
      P002P3_A43PaisId = new short[1] ;
      P002P3_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P3_A20PacienteId = new int[1] ;
      P002P3_A225PacienteEspecifique = new String[] {""} ;
      P002P3_n225PacienteEspecifique = new boolean[] {false} ;
      P002P3_A224PacienteEnterarse = new String[] {""} ;
      P002P3_n224PacienteEnterarse = new boolean[] {false} ;
      P002P3_A222PacienteNombreAnexo = new String[] {""} ;
      P002P3_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P3_A44UbigeoCode = new String[] {""} ;
      P002P3_n44UbigeoCode = new boolean[] {false} ;
      P002P3_A219PacienteEstado = new String[] {""} ;
      P002P3_A184PaisDescripcion = new String[] {""} ;
      P002P3_A218PacienteTelefono = new String[] {""} ;
      P002P3_A217PacienteCorreo = new String[] {""} ;
      P002P3_A216PacienteSexo = new String[] {""} ;
      P002P3_A215PacienteDireccion = new String[] {""} ;
      P002P3_A106PacienteNroDocumento = new String[] {""} ;
      P002P3_A214PacienteTipoDocumento = new String[] {""} ;
      P002P3_A105PacienteNombres = new String[] {""} ;
      P002P3_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P3_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P3_A188UbigeoDistrito = new String[] {""} ;
      P002P3_A187UbigeoProvincia = new String[] {""} ;
      P002P3_A186UbigeoDepartamento = new String[] {""} ;
      P002P4_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P4_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P4_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P4_A6SecUserId = new short[1] ;
      P002P4_n6SecUserId = new boolean[] {false} ;
      P002P4_A43PaisId = new short[1] ;
      P002P4_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P4_A20PacienteId = new int[1] ;
      P002P4_A225PacienteEspecifique = new String[] {""} ;
      P002P4_n225PacienteEspecifique = new boolean[] {false} ;
      P002P4_A224PacienteEnterarse = new String[] {""} ;
      P002P4_n224PacienteEnterarse = new boolean[] {false} ;
      P002P4_A222PacienteNombreAnexo = new String[] {""} ;
      P002P4_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P4_A44UbigeoCode = new String[] {""} ;
      P002P4_n44UbigeoCode = new boolean[] {false} ;
      P002P4_A219PacienteEstado = new String[] {""} ;
      P002P4_A184PaisDescripcion = new String[] {""} ;
      P002P4_A218PacienteTelefono = new String[] {""} ;
      P002P4_A217PacienteCorreo = new String[] {""} ;
      P002P4_A216PacienteSexo = new String[] {""} ;
      P002P4_A215PacienteDireccion = new String[] {""} ;
      P002P4_A106PacienteNroDocumento = new String[] {""} ;
      P002P4_A214PacienteTipoDocumento = new String[] {""} ;
      P002P4_A105PacienteNombres = new String[] {""} ;
      P002P4_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P4_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P4_A188UbigeoDistrito = new String[] {""} ;
      P002P4_A187UbigeoProvincia = new String[] {""} ;
      P002P4_A186UbigeoDepartamento = new String[] {""} ;
      P002P5_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P5_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P5_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P5_A6SecUserId = new short[1] ;
      P002P5_n6SecUserId = new boolean[] {false} ;
      P002P5_A43PaisId = new short[1] ;
      P002P5_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P5_A20PacienteId = new int[1] ;
      P002P5_A225PacienteEspecifique = new String[] {""} ;
      P002P5_n225PacienteEspecifique = new boolean[] {false} ;
      P002P5_A224PacienteEnterarse = new String[] {""} ;
      P002P5_n224PacienteEnterarse = new boolean[] {false} ;
      P002P5_A222PacienteNombreAnexo = new String[] {""} ;
      P002P5_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P5_A44UbigeoCode = new String[] {""} ;
      P002P5_n44UbigeoCode = new boolean[] {false} ;
      P002P5_A219PacienteEstado = new String[] {""} ;
      P002P5_A184PaisDescripcion = new String[] {""} ;
      P002P5_A218PacienteTelefono = new String[] {""} ;
      P002P5_A217PacienteCorreo = new String[] {""} ;
      P002P5_A216PacienteSexo = new String[] {""} ;
      P002P5_A215PacienteDireccion = new String[] {""} ;
      P002P5_A106PacienteNroDocumento = new String[] {""} ;
      P002P5_A214PacienteTipoDocumento = new String[] {""} ;
      P002P5_A105PacienteNombres = new String[] {""} ;
      P002P5_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P5_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P5_A188UbigeoDistrito = new String[] {""} ;
      P002P5_A187UbigeoProvincia = new String[] {""} ;
      P002P5_A186UbigeoDepartamento = new String[] {""} ;
      P002P6_A106PacienteNroDocumento = new String[] {""} ;
      P002P6_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P6_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P6_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P6_A6SecUserId = new short[1] ;
      P002P6_n6SecUserId = new boolean[] {false} ;
      P002P6_A43PaisId = new short[1] ;
      P002P6_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P6_A20PacienteId = new int[1] ;
      P002P6_A225PacienteEspecifique = new String[] {""} ;
      P002P6_n225PacienteEspecifique = new boolean[] {false} ;
      P002P6_A224PacienteEnterarse = new String[] {""} ;
      P002P6_n224PacienteEnterarse = new boolean[] {false} ;
      P002P6_A222PacienteNombreAnexo = new String[] {""} ;
      P002P6_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P6_A44UbigeoCode = new String[] {""} ;
      P002P6_n44UbigeoCode = new boolean[] {false} ;
      P002P6_A219PacienteEstado = new String[] {""} ;
      P002P6_A184PaisDescripcion = new String[] {""} ;
      P002P6_A218PacienteTelefono = new String[] {""} ;
      P002P6_A217PacienteCorreo = new String[] {""} ;
      P002P6_A216PacienteSexo = new String[] {""} ;
      P002P6_A215PacienteDireccion = new String[] {""} ;
      P002P6_A214PacienteTipoDocumento = new String[] {""} ;
      P002P6_A105PacienteNombres = new String[] {""} ;
      P002P6_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P6_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P6_A188UbigeoDistrito = new String[] {""} ;
      P002P6_A187UbigeoProvincia = new String[] {""} ;
      P002P6_A186UbigeoDepartamento = new String[] {""} ;
      P002P7_A215PacienteDireccion = new String[] {""} ;
      P002P7_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P7_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P7_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P7_A6SecUserId = new short[1] ;
      P002P7_n6SecUserId = new boolean[] {false} ;
      P002P7_A43PaisId = new short[1] ;
      P002P7_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P7_A20PacienteId = new int[1] ;
      P002P7_A225PacienteEspecifique = new String[] {""} ;
      P002P7_n225PacienteEspecifique = new boolean[] {false} ;
      P002P7_A224PacienteEnterarse = new String[] {""} ;
      P002P7_n224PacienteEnterarse = new boolean[] {false} ;
      P002P7_A222PacienteNombreAnexo = new String[] {""} ;
      P002P7_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P7_A44UbigeoCode = new String[] {""} ;
      P002P7_n44UbigeoCode = new boolean[] {false} ;
      P002P7_A219PacienteEstado = new String[] {""} ;
      P002P7_A184PaisDescripcion = new String[] {""} ;
      P002P7_A218PacienteTelefono = new String[] {""} ;
      P002P7_A217PacienteCorreo = new String[] {""} ;
      P002P7_A216PacienteSexo = new String[] {""} ;
      P002P7_A106PacienteNroDocumento = new String[] {""} ;
      P002P7_A214PacienteTipoDocumento = new String[] {""} ;
      P002P7_A105PacienteNombres = new String[] {""} ;
      P002P7_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P7_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P7_A188UbigeoDistrito = new String[] {""} ;
      P002P7_A187UbigeoProvincia = new String[] {""} ;
      P002P7_A186UbigeoDepartamento = new String[] {""} ;
      P002P8_A217PacienteCorreo = new String[] {""} ;
      P002P8_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P8_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P8_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P8_A6SecUserId = new short[1] ;
      P002P8_n6SecUserId = new boolean[] {false} ;
      P002P8_A43PaisId = new short[1] ;
      P002P8_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P8_A20PacienteId = new int[1] ;
      P002P8_A225PacienteEspecifique = new String[] {""} ;
      P002P8_n225PacienteEspecifique = new boolean[] {false} ;
      P002P8_A224PacienteEnterarse = new String[] {""} ;
      P002P8_n224PacienteEnterarse = new boolean[] {false} ;
      P002P8_A222PacienteNombreAnexo = new String[] {""} ;
      P002P8_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P8_A44UbigeoCode = new String[] {""} ;
      P002P8_n44UbigeoCode = new boolean[] {false} ;
      P002P8_A219PacienteEstado = new String[] {""} ;
      P002P8_A184PaisDescripcion = new String[] {""} ;
      P002P8_A218PacienteTelefono = new String[] {""} ;
      P002P8_A216PacienteSexo = new String[] {""} ;
      P002P8_A215PacienteDireccion = new String[] {""} ;
      P002P8_A106PacienteNroDocumento = new String[] {""} ;
      P002P8_A214PacienteTipoDocumento = new String[] {""} ;
      P002P8_A105PacienteNombres = new String[] {""} ;
      P002P8_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P8_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P8_A188UbigeoDistrito = new String[] {""} ;
      P002P8_A187UbigeoProvincia = new String[] {""} ;
      P002P8_A186UbigeoDepartamento = new String[] {""} ;
      P002P9_A218PacienteTelefono = new String[] {""} ;
      P002P9_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P9_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P9_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P9_A6SecUserId = new short[1] ;
      P002P9_n6SecUserId = new boolean[] {false} ;
      P002P9_A43PaisId = new short[1] ;
      P002P9_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P9_A20PacienteId = new int[1] ;
      P002P9_A225PacienteEspecifique = new String[] {""} ;
      P002P9_n225PacienteEspecifique = new boolean[] {false} ;
      P002P9_A224PacienteEnterarse = new String[] {""} ;
      P002P9_n224PacienteEnterarse = new boolean[] {false} ;
      P002P9_A222PacienteNombreAnexo = new String[] {""} ;
      P002P9_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P9_A44UbigeoCode = new String[] {""} ;
      P002P9_n44UbigeoCode = new boolean[] {false} ;
      P002P9_A219PacienteEstado = new String[] {""} ;
      P002P9_A184PaisDescripcion = new String[] {""} ;
      P002P9_A217PacienteCorreo = new String[] {""} ;
      P002P9_A216PacienteSexo = new String[] {""} ;
      P002P9_A215PacienteDireccion = new String[] {""} ;
      P002P9_A106PacienteNroDocumento = new String[] {""} ;
      P002P9_A214PacienteTipoDocumento = new String[] {""} ;
      P002P9_A105PacienteNombres = new String[] {""} ;
      P002P9_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P9_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P9_A188UbigeoDistrito = new String[] {""} ;
      P002P9_A187UbigeoProvincia = new String[] {""} ;
      P002P9_A186UbigeoDepartamento = new String[] {""} ;
      P002P10_A43PaisId = new short[1] ;
      P002P10_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P10_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P10_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P10_A6SecUserId = new short[1] ;
      P002P10_n6SecUserId = new boolean[] {false} ;
      P002P10_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P10_A20PacienteId = new int[1] ;
      P002P10_A225PacienteEspecifique = new String[] {""} ;
      P002P10_n225PacienteEspecifique = new boolean[] {false} ;
      P002P10_A224PacienteEnterarse = new String[] {""} ;
      P002P10_n224PacienteEnterarse = new boolean[] {false} ;
      P002P10_A222PacienteNombreAnexo = new String[] {""} ;
      P002P10_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P10_A44UbigeoCode = new String[] {""} ;
      P002P10_n44UbigeoCode = new boolean[] {false} ;
      P002P10_A219PacienteEstado = new String[] {""} ;
      P002P10_A184PaisDescripcion = new String[] {""} ;
      P002P10_A218PacienteTelefono = new String[] {""} ;
      P002P10_A217PacienteCorreo = new String[] {""} ;
      P002P10_A216PacienteSexo = new String[] {""} ;
      P002P10_A215PacienteDireccion = new String[] {""} ;
      P002P10_A106PacienteNroDocumento = new String[] {""} ;
      P002P10_A214PacienteTipoDocumento = new String[] {""} ;
      P002P10_A105PacienteNombres = new String[] {""} ;
      P002P10_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P10_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P10_A188UbigeoDistrito = new String[] {""} ;
      P002P10_A187UbigeoProvincia = new String[] {""} ;
      P002P10_A186UbigeoDepartamento = new String[] {""} ;
      P002P11_A44UbigeoCode = new String[] {""} ;
      P002P11_n44UbigeoCode = new boolean[] {false} ;
      P002P11_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P11_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P11_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P11_A6SecUserId = new short[1] ;
      P002P11_n6SecUserId = new boolean[] {false} ;
      P002P11_A43PaisId = new short[1] ;
      P002P11_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P11_A20PacienteId = new int[1] ;
      P002P11_A225PacienteEspecifique = new String[] {""} ;
      P002P11_n225PacienteEspecifique = new boolean[] {false} ;
      P002P11_A224PacienteEnterarse = new String[] {""} ;
      P002P11_n224PacienteEnterarse = new boolean[] {false} ;
      P002P11_A222PacienteNombreAnexo = new String[] {""} ;
      P002P11_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P11_A219PacienteEstado = new String[] {""} ;
      P002P11_A184PaisDescripcion = new String[] {""} ;
      P002P11_A218PacienteTelefono = new String[] {""} ;
      P002P11_A217PacienteCorreo = new String[] {""} ;
      P002P11_A216PacienteSexo = new String[] {""} ;
      P002P11_A215PacienteDireccion = new String[] {""} ;
      P002P11_A106PacienteNroDocumento = new String[] {""} ;
      P002P11_A214PacienteTipoDocumento = new String[] {""} ;
      P002P11_A105PacienteNombres = new String[] {""} ;
      P002P11_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P11_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P11_A188UbigeoDistrito = new String[] {""} ;
      P002P11_A187UbigeoProvincia = new String[] {""} ;
      P002P11_A186UbigeoDepartamento = new String[] {""} ;
      P002P12_A44UbigeoCode = new String[] {""} ;
      P002P12_n44UbigeoCode = new boolean[] {false} ;
      P002P12_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P12_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P12_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P12_A6SecUserId = new short[1] ;
      P002P12_n6SecUserId = new boolean[] {false} ;
      P002P12_A43PaisId = new short[1] ;
      P002P12_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P12_A20PacienteId = new int[1] ;
      P002P12_A225PacienteEspecifique = new String[] {""} ;
      P002P12_n225PacienteEspecifique = new boolean[] {false} ;
      P002P12_A224PacienteEnterarse = new String[] {""} ;
      P002P12_n224PacienteEnterarse = new boolean[] {false} ;
      P002P12_A222PacienteNombreAnexo = new String[] {""} ;
      P002P12_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P12_A219PacienteEstado = new String[] {""} ;
      P002P12_A184PaisDescripcion = new String[] {""} ;
      P002P12_A218PacienteTelefono = new String[] {""} ;
      P002P12_A217PacienteCorreo = new String[] {""} ;
      P002P12_A216PacienteSexo = new String[] {""} ;
      P002P12_A215PacienteDireccion = new String[] {""} ;
      P002P12_A106PacienteNroDocumento = new String[] {""} ;
      P002P12_A214PacienteTipoDocumento = new String[] {""} ;
      P002P12_A105PacienteNombres = new String[] {""} ;
      P002P12_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P12_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P12_A188UbigeoDistrito = new String[] {""} ;
      P002P12_A187UbigeoProvincia = new String[] {""} ;
      P002P12_A186UbigeoDepartamento = new String[] {""} ;
      P002P13_A222PacienteNombreAnexo = new String[] {""} ;
      P002P13_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P13_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P13_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P13_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P13_A6SecUserId = new short[1] ;
      P002P13_n6SecUserId = new boolean[] {false} ;
      P002P13_A43PaisId = new short[1] ;
      P002P13_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P13_A20PacienteId = new int[1] ;
      P002P13_A225PacienteEspecifique = new String[] {""} ;
      P002P13_n225PacienteEspecifique = new boolean[] {false} ;
      P002P13_A224PacienteEnterarse = new String[] {""} ;
      P002P13_n224PacienteEnterarse = new boolean[] {false} ;
      P002P13_A44UbigeoCode = new String[] {""} ;
      P002P13_n44UbigeoCode = new boolean[] {false} ;
      P002P13_A219PacienteEstado = new String[] {""} ;
      P002P13_A184PaisDescripcion = new String[] {""} ;
      P002P13_A218PacienteTelefono = new String[] {""} ;
      P002P13_A217PacienteCorreo = new String[] {""} ;
      P002P13_A216PacienteSexo = new String[] {""} ;
      P002P13_A215PacienteDireccion = new String[] {""} ;
      P002P13_A106PacienteNroDocumento = new String[] {""} ;
      P002P13_A214PacienteTipoDocumento = new String[] {""} ;
      P002P13_A105PacienteNombres = new String[] {""} ;
      P002P13_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P13_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P13_A188UbigeoDistrito = new String[] {""} ;
      P002P13_A187UbigeoProvincia = new String[] {""} ;
      P002P13_A186UbigeoDepartamento = new String[] {""} ;
      P002P14_A225PacienteEspecifique = new String[] {""} ;
      P002P14_n225PacienteEspecifique = new boolean[] {false} ;
      P002P14_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      P002P14_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P14_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P002P14_A6SecUserId = new short[1] ;
      P002P14_n6SecUserId = new boolean[] {false} ;
      P002P14_A43PaisId = new short[1] ;
      P002P14_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      P002P14_A20PacienteId = new int[1] ;
      P002P14_A224PacienteEnterarse = new String[] {""} ;
      P002P14_n224PacienteEnterarse = new boolean[] {false} ;
      P002P14_A222PacienteNombreAnexo = new String[] {""} ;
      P002P14_n222PacienteNombreAnexo = new boolean[] {false} ;
      P002P14_A44UbigeoCode = new String[] {""} ;
      P002P14_n44UbigeoCode = new boolean[] {false} ;
      P002P14_A219PacienteEstado = new String[] {""} ;
      P002P14_A184PaisDescripcion = new String[] {""} ;
      P002P14_A218PacienteTelefono = new String[] {""} ;
      P002P14_A217PacienteCorreo = new String[] {""} ;
      P002P14_A216PacienteSexo = new String[] {""} ;
      P002P14_A215PacienteDireccion = new String[] {""} ;
      P002P14_A106PacienteNroDocumento = new String[] {""} ;
      P002P14_A214PacienteTipoDocumento = new String[] {""} ;
      P002P14_A105PacienteNombres = new String[] {""} ;
      P002P14_A104PacienteApellidoMaterno = new String[] {""} ;
      P002P14_A103PacienteApellidoPaterno = new String[] {""} ;
      P002P14_A188UbigeoDistrito = new String[] {""} ;
      P002P14_A187UbigeoProvincia = new String[] {""} ;
      P002P14_A186UbigeoDepartamento = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002P2_A226PacienteFechaRegistro, P002P2_A221PacientePeso, P002P2_A220PacienteEstatura, P002P2_A6SecUserId, P002P2_n6SecUserId, P002P2_A43PaisId, P002P2_A213PacienteFechaNacimiento, P002P2_A20PacienteId, P002P2_A225PacienteEspecifique, P002P2_n225PacienteEspecifique,
            P002P2_A224PacienteEnterarse, P002P2_n224PacienteEnterarse, P002P2_A222PacienteNombreAnexo, P002P2_n222PacienteNombreAnexo, P002P2_A44UbigeoCode, P002P2_n44UbigeoCode, P002P2_A219PacienteEstado, P002P2_A184PaisDescripcion, P002P2_A218PacienteTelefono, P002P2_A217PacienteCorreo,
            P002P2_A216PacienteSexo, P002P2_A215PacienteDireccion, P002P2_A106PacienteNroDocumento, P002P2_A214PacienteTipoDocumento, P002P2_A105PacienteNombres, P002P2_A104PacienteApellidoMaterno, P002P2_A103PacienteApellidoPaterno, P002P2_A188UbigeoDistrito, P002P2_A187UbigeoProvincia, P002P2_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P3_A226PacienteFechaRegistro, P002P3_A221PacientePeso, P002P3_A220PacienteEstatura, P002P3_A6SecUserId, P002P3_n6SecUserId, P002P3_A43PaisId, P002P3_A213PacienteFechaNacimiento, P002P3_A20PacienteId, P002P3_A225PacienteEspecifique, P002P3_n225PacienteEspecifique,
            P002P3_A224PacienteEnterarse, P002P3_n224PacienteEnterarse, P002P3_A222PacienteNombreAnexo, P002P3_n222PacienteNombreAnexo, P002P3_A44UbigeoCode, P002P3_n44UbigeoCode, P002P3_A219PacienteEstado, P002P3_A184PaisDescripcion, P002P3_A218PacienteTelefono, P002P3_A217PacienteCorreo,
            P002P3_A216PacienteSexo, P002P3_A215PacienteDireccion, P002P3_A106PacienteNroDocumento, P002P3_A214PacienteTipoDocumento, P002P3_A105PacienteNombres, P002P3_A104PacienteApellidoMaterno, P002P3_A103PacienteApellidoPaterno, P002P3_A188UbigeoDistrito, P002P3_A187UbigeoProvincia, P002P3_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P4_A226PacienteFechaRegistro, P002P4_A221PacientePeso, P002P4_A220PacienteEstatura, P002P4_A6SecUserId, P002P4_n6SecUserId, P002P4_A43PaisId, P002P4_A213PacienteFechaNacimiento, P002P4_A20PacienteId, P002P4_A225PacienteEspecifique, P002P4_n225PacienteEspecifique,
            P002P4_A224PacienteEnterarse, P002P4_n224PacienteEnterarse, P002P4_A222PacienteNombreAnexo, P002P4_n222PacienteNombreAnexo, P002P4_A44UbigeoCode, P002P4_n44UbigeoCode, P002P4_A219PacienteEstado, P002P4_A184PaisDescripcion, P002P4_A218PacienteTelefono, P002P4_A217PacienteCorreo,
            P002P4_A216PacienteSexo, P002P4_A215PacienteDireccion, P002P4_A106PacienteNroDocumento, P002P4_A214PacienteTipoDocumento, P002P4_A105PacienteNombres, P002P4_A104PacienteApellidoMaterno, P002P4_A103PacienteApellidoPaterno, P002P4_A188UbigeoDistrito, P002P4_A187UbigeoProvincia, P002P4_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P5_A226PacienteFechaRegistro, P002P5_A221PacientePeso, P002P5_A220PacienteEstatura, P002P5_A6SecUserId, P002P5_n6SecUserId, P002P5_A43PaisId, P002P5_A213PacienteFechaNacimiento, P002P5_A20PacienteId, P002P5_A225PacienteEspecifique, P002P5_n225PacienteEspecifique,
            P002P5_A224PacienteEnterarse, P002P5_n224PacienteEnterarse, P002P5_A222PacienteNombreAnexo, P002P5_n222PacienteNombreAnexo, P002P5_A44UbigeoCode, P002P5_n44UbigeoCode, P002P5_A219PacienteEstado, P002P5_A184PaisDescripcion, P002P5_A218PacienteTelefono, P002P5_A217PacienteCorreo,
            P002P5_A216PacienteSexo, P002P5_A215PacienteDireccion, P002P5_A106PacienteNroDocumento, P002P5_A214PacienteTipoDocumento, P002P5_A105PacienteNombres, P002P5_A104PacienteApellidoMaterno, P002P5_A103PacienteApellidoPaterno, P002P5_A188UbigeoDistrito, P002P5_A187UbigeoProvincia, P002P5_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P6_A106PacienteNroDocumento, P002P6_A226PacienteFechaRegistro, P002P6_A221PacientePeso, P002P6_A220PacienteEstatura, P002P6_A6SecUserId, P002P6_n6SecUserId, P002P6_A43PaisId, P002P6_A213PacienteFechaNacimiento, P002P6_A20PacienteId, P002P6_A225PacienteEspecifique,
            P002P6_n225PacienteEspecifique, P002P6_A224PacienteEnterarse, P002P6_n224PacienteEnterarse, P002P6_A222PacienteNombreAnexo, P002P6_n222PacienteNombreAnexo, P002P6_A44UbigeoCode, P002P6_n44UbigeoCode, P002P6_A219PacienteEstado, P002P6_A184PaisDescripcion, P002P6_A218PacienteTelefono,
            P002P6_A217PacienteCorreo, P002P6_A216PacienteSexo, P002P6_A215PacienteDireccion, P002P6_A214PacienteTipoDocumento, P002P6_A105PacienteNombres, P002P6_A104PacienteApellidoMaterno, P002P6_A103PacienteApellidoPaterno, P002P6_A188UbigeoDistrito, P002P6_A187UbigeoProvincia, P002P6_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P7_A215PacienteDireccion, P002P7_A226PacienteFechaRegistro, P002P7_A221PacientePeso, P002P7_A220PacienteEstatura, P002P7_A6SecUserId, P002P7_n6SecUserId, P002P7_A43PaisId, P002P7_A213PacienteFechaNacimiento, P002P7_A20PacienteId, P002P7_A225PacienteEspecifique,
            P002P7_n225PacienteEspecifique, P002P7_A224PacienteEnterarse, P002P7_n224PacienteEnterarse, P002P7_A222PacienteNombreAnexo, P002P7_n222PacienteNombreAnexo, P002P7_A44UbigeoCode, P002P7_n44UbigeoCode, P002P7_A219PacienteEstado, P002P7_A184PaisDescripcion, P002P7_A218PacienteTelefono,
            P002P7_A217PacienteCorreo, P002P7_A216PacienteSexo, P002P7_A106PacienteNroDocumento, P002P7_A214PacienteTipoDocumento, P002P7_A105PacienteNombres, P002P7_A104PacienteApellidoMaterno, P002P7_A103PacienteApellidoPaterno, P002P7_A188UbigeoDistrito, P002P7_A187UbigeoProvincia, P002P7_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P8_A217PacienteCorreo, P002P8_A226PacienteFechaRegistro, P002P8_A221PacientePeso, P002P8_A220PacienteEstatura, P002P8_A6SecUserId, P002P8_n6SecUserId, P002P8_A43PaisId, P002P8_A213PacienteFechaNacimiento, P002P8_A20PacienteId, P002P8_A225PacienteEspecifique,
            P002P8_n225PacienteEspecifique, P002P8_A224PacienteEnterarse, P002P8_n224PacienteEnterarse, P002P8_A222PacienteNombreAnexo, P002P8_n222PacienteNombreAnexo, P002P8_A44UbigeoCode, P002P8_n44UbigeoCode, P002P8_A219PacienteEstado, P002P8_A184PaisDescripcion, P002P8_A218PacienteTelefono,
            P002P8_A216PacienteSexo, P002P8_A215PacienteDireccion, P002P8_A106PacienteNroDocumento, P002P8_A214PacienteTipoDocumento, P002P8_A105PacienteNombres, P002P8_A104PacienteApellidoMaterno, P002P8_A103PacienteApellidoPaterno, P002P8_A188UbigeoDistrito, P002P8_A187UbigeoProvincia, P002P8_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P9_A218PacienteTelefono, P002P9_A226PacienteFechaRegistro, P002P9_A221PacientePeso, P002P9_A220PacienteEstatura, P002P9_A6SecUserId, P002P9_n6SecUserId, P002P9_A43PaisId, P002P9_A213PacienteFechaNacimiento, P002P9_A20PacienteId, P002P9_A225PacienteEspecifique,
            P002P9_n225PacienteEspecifique, P002P9_A224PacienteEnterarse, P002P9_n224PacienteEnterarse, P002P9_A222PacienteNombreAnexo, P002P9_n222PacienteNombreAnexo, P002P9_A44UbigeoCode, P002P9_n44UbigeoCode, P002P9_A219PacienteEstado, P002P9_A184PaisDescripcion, P002P9_A217PacienteCorreo,
            P002P9_A216PacienteSexo, P002P9_A215PacienteDireccion, P002P9_A106PacienteNroDocumento, P002P9_A214PacienteTipoDocumento, P002P9_A105PacienteNombres, P002P9_A104PacienteApellidoMaterno, P002P9_A103PacienteApellidoPaterno, P002P9_A188UbigeoDistrito, P002P9_A187UbigeoProvincia, P002P9_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P10_A43PaisId, P002P10_A226PacienteFechaRegistro, P002P10_A221PacientePeso, P002P10_A220PacienteEstatura, P002P10_A6SecUserId, P002P10_n6SecUserId, P002P10_A213PacienteFechaNacimiento, P002P10_A20PacienteId, P002P10_A225PacienteEspecifique, P002P10_n225PacienteEspecifique,
            P002P10_A224PacienteEnterarse, P002P10_n224PacienteEnterarse, P002P10_A222PacienteNombreAnexo, P002P10_n222PacienteNombreAnexo, P002P10_A44UbigeoCode, P002P10_n44UbigeoCode, P002P10_A219PacienteEstado, P002P10_A184PaisDescripcion, P002P10_A218PacienteTelefono, P002P10_A217PacienteCorreo,
            P002P10_A216PacienteSexo, P002P10_A215PacienteDireccion, P002P10_A106PacienteNroDocumento, P002P10_A214PacienteTipoDocumento, P002P10_A105PacienteNombres, P002P10_A104PacienteApellidoMaterno, P002P10_A103PacienteApellidoPaterno, P002P10_A188UbigeoDistrito, P002P10_A187UbigeoProvincia, P002P10_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P11_A44UbigeoCode, P002P11_n44UbigeoCode, P002P11_A226PacienteFechaRegistro, P002P11_A221PacientePeso, P002P11_A220PacienteEstatura, P002P11_A6SecUserId, P002P11_n6SecUserId, P002P11_A43PaisId, P002P11_A213PacienteFechaNacimiento, P002P11_A20PacienteId,
            P002P11_A225PacienteEspecifique, P002P11_n225PacienteEspecifique, P002P11_A224PacienteEnterarse, P002P11_n224PacienteEnterarse, P002P11_A222PacienteNombreAnexo, P002P11_n222PacienteNombreAnexo, P002P11_A219PacienteEstado, P002P11_A184PaisDescripcion, P002P11_A218PacienteTelefono, P002P11_A217PacienteCorreo,
            P002P11_A216PacienteSexo, P002P11_A215PacienteDireccion, P002P11_A106PacienteNroDocumento, P002P11_A214PacienteTipoDocumento, P002P11_A105PacienteNombres, P002P11_A104PacienteApellidoMaterno, P002P11_A103PacienteApellidoPaterno, P002P11_A188UbigeoDistrito, P002P11_A187UbigeoProvincia, P002P11_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P12_A44UbigeoCode, P002P12_n44UbigeoCode, P002P12_A226PacienteFechaRegistro, P002P12_A221PacientePeso, P002P12_A220PacienteEstatura, P002P12_A6SecUserId, P002P12_n6SecUserId, P002P12_A43PaisId, P002P12_A213PacienteFechaNacimiento, P002P12_A20PacienteId,
            P002P12_A225PacienteEspecifique, P002P12_n225PacienteEspecifique, P002P12_A224PacienteEnterarse, P002P12_n224PacienteEnterarse, P002P12_A222PacienteNombreAnexo, P002P12_n222PacienteNombreAnexo, P002P12_A219PacienteEstado, P002P12_A184PaisDescripcion, P002P12_A218PacienteTelefono, P002P12_A217PacienteCorreo,
            P002P12_A216PacienteSexo, P002P12_A215PacienteDireccion, P002P12_A106PacienteNroDocumento, P002P12_A214PacienteTipoDocumento, P002P12_A105PacienteNombres, P002P12_A104PacienteApellidoMaterno, P002P12_A103PacienteApellidoPaterno, P002P12_A188UbigeoDistrito, P002P12_A187UbigeoProvincia, P002P12_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P13_A222PacienteNombreAnexo, P002P13_n222PacienteNombreAnexo, P002P13_A226PacienteFechaRegistro, P002P13_A221PacientePeso, P002P13_A220PacienteEstatura, P002P13_A6SecUserId, P002P13_n6SecUserId, P002P13_A43PaisId, P002P13_A213PacienteFechaNacimiento, P002P13_A20PacienteId,
            P002P13_A225PacienteEspecifique, P002P13_n225PacienteEspecifique, P002P13_A224PacienteEnterarse, P002P13_n224PacienteEnterarse, P002P13_A44UbigeoCode, P002P13_n44UbigeoCode, P002P13_A219PacienteEstado, P002P13_A184PaisDescripcion, P002P13_A218PacienteTelefono, P002P13_A217PacienteCorreo,
            P002P13_A216PacienteSexo, P002P13_A215PacienteDireccion, P002P13_A106PacienteNroDocumento, P002P13_A214PacienteTipoDocumento, P002P13_A105PacienteNombres, P002P13_A104PacienteApellidoMaterno, P002P13_A103PacienteApellidoPaterno, P002P13_A188UbigeoDistrito, P002P13_A187UbigeoProvincia, P002P13_A186UbigeoDepartamento
            }
            , new Object[] {
            P002P14_A225PacienteEspecifique, P002P14_n225PacienteEspecifique, P002P14_A226PacienteFechaRegistro, P002P14_A221PacientePeso, P002P14_A220PacienteEstatura, P002P14_A6SecUserId, P002P14_n6SecUserId, P002P14_A43PaisId, P002P14_A213PacienteFechaNacimiento, P002P14_A20PacienteId,
            P002P14_A224PacienteEnterarse, P002P14_n224PacienteEnterarse, P002P14_A222PacienteNombreAnexo, P002P14_n222PacienteNombreAnexo, P002P14_A44UbigeoCode, P002P14_n44UbigeoCode, P002P14_A219PacienteEstado, P002P14_A184PaisDescripcion, P002P14_A218PacienteTelefono, P002P14_A217PacienteCorreo,
            P002P14_A216PacienteSexo, P002P14_A215PacienteDireccion, P002P14_A106PacienteNroDocumento, P002P14_A214PacienteTipoDocumento, P002P14_A105PacienteNombres, P002P14_A104PacienteApellidoMaterno, P002P14_A103PacienteApellidoPaterno, P002P14_A188UbigeoDistrito, P002P14_A187UbigeoProvincia, P002P14_A186UbigeoDepartamento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37TFPaisId ;
   private short AV38TFPaisId_To ;
   private short AV43TFSecUserId ;
   private short AV44TFSecUserId_To ;
   private short AV105Pacientewwds_24_tfpaisid ;
   private short AV106Pacientewwds_25_tfpaisid_to ;
   private short AV110Pacientewwds_29_tfsecuserid ;
   private short AV111Pacientewwds_30_tfsecuserid_to ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short Gx_err ;
   private int AV80GXV1 ;
   private int AV11TFPacienteId ;
   private int AV12TFPacienteId_To ;
   private int AV83Pacientewwds_2_tfpacienteid ;
   private int AV84Pacientewwds_3_tfpacienteid_to ;
   private int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ;
   private int AV100Pacientewwds_19_tfpacientesexo_sels_size ;
   private int AV109Pacientewwds_28_tfpacienteestado_sels_size ;
   private int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ;
   private int A20PacienteId ;
   private int AV60InsertIndex ;
   private long AV69count ;
   private java.math.BigDecimal AV49TFPacienteEstatura ;
   private java.math.BigDecimal AV50TFPacienteEstatura_To ;
   private java.math.BigDecimal AV51TFPacientePeso ;
   private java.math.BigDecimal AV52TFPacientePeso_To ;
   private java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ;
   private java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ;
   private java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ;
   private java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private String AV35TFPacienteTelefono ;
   private String AV36TFPacienteTelefono_Sel ;
   private String AV45TFUbigeoCode ;
   private String AV46TFUbigeoCode_Sel ;
   private String AV103Pacientewwds_22_tfpacientetelefono ;
   private String AV104Pacientewwds_23_tfpacientetelefono_sel ;
   private String AV112Pacientewwds_31_tfubigeocode ;
   private String AV113Pacientewwds_32_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV103Pacientewwds_22_tfpacientetelefono ;
   private String lV112Pacientewwds_31_tfubigeocode ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A219PacienteEstado ;
   private String A218PacienteTelefono ;
   private String A44UbigeoCode ;
   private java.util.Date AV55TFPacienteFechaRegistro ;
   private java.util.Date AV56TFPacienteFechaRegistro_To ;
   private java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ;
   private java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date AV21TFPacienteFechaNacimiento ;
   private java.util.Date AV22TFPacienteFechaNacimiento_To ;
   private java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ;
   private java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2P2 ;
   private boolean n6SecUserId ;
   private boolean n225PacienteEspecifique ;
   private boolean n224PacienteEnterarse ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n44UbigeoCode ;
   private boolean brk2P4 ;
   private boolean brk2P6 ;
   private boolean brk2P9 ;
   private boolean brk2P11 ;
   private boolean brk2P13 ;
   private boolean brk2P15 ;
   private boolean brk2P17 ;
   private boolean brk2P19 ;
   private boolean brk2P21 ;
   private boolean brk2P23 ;
   private boolean brk2P25 ;
   private String AV63OptionsJson ;
   private String AV66OptionsDescJson ;
   private String AV68OptionIndexesJson ;
   private String AV23TFPacienteTipoDocumento_SelsJson ;
   private String AV31TFPacienteSexo_SelsJson ;
   private String AV41TFPacienteEstado_SelsJson ;
   private String AV29TFPacienteEnterarse_SelsJson ;
   private String A225PacienteEspecifique ;
   private String AV59DDOName ;
   private String AV57SearchTxt ;
   private String AV58SearchTxtTo ;
   private String AV75FilterFullText ;
   private String AV13TFPacienteApellidoPaterno ;
   private String AV14TFPacienteApellidoPaterno_Sel ;
   private String AV15TFPacienteApellidoMaterno ;
   private String AV16TFPacienteApellidoMaterno_Sel ;
   private String AV17TFPacienteNombres ;
   private String AV18TFPacienteNombres_Sel ;
   private String AV19TFPacienteNombreCompleto ;
   private String AV20TFPacienteNombreCompleto_Sel ;
   private String AV25TFPacienteNroDocumento ;
   private String AV26TFPacienteNroDocumento_Sel ;
   private String AV27TFPacienteDireccion ;
   private String AV28TFPacienteDireccion_Sel ;
   private String AV33TFPacienteCorreo ;
   private String AV34TFPacienteCorreo_Sel ;
   private String AV39TFPaisDescripcion ;
   private String AV40TFPaisDescripcion_Sel ;
   private String AV47TFUbigeoNombre ;
   private String AV48TFUbigeoNombre_Sel ;
   private String AV53TFPacienteNombreAnexo ;
   private String AV54TFPacienteNombreAnexo_Sel ;
   private String AV76TFPacienteEspecifique ;
   private String AV77TFPacienteEspecifique_Sel ;
   private String A103PacienteApellidoPaterno ;
   private String AV82Pacientewwds_1_filterfulltext ;
   private String AV85Pacientewwds_4_tfpacienteapellidopaterno ;
   private String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ;
   private String AV87Pacientewwds_6_tfpacienteapellidomaterno ;
   private String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ;
   private String AV89Pacientewwds_8_tfpacientenombres ;
   private String AV90Pacientewwds_9_tfpacientenombres_sel ;
   private String AV91Pacientewwds_10_tfpacientenombrecompleto ;
   private String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ;
   private String AV96Pacientewwds_15_tfpacientenrodocumento ;
   private String AV97Pacientewwds_16_tfpacientenrodocumento_sel ;
   private String AV98Pacientewwds_17_tfpacientedireccion ;
   private String AV99Pacientewwds_18_tfpacientedireccion_sel ;
   private String AV101Pacientewwds_20_tfpacientecorreo ;
   private String AV102Pacientewwds_21_tfpacientecorreo_sel ;
   private String AV107Pacientewwds_26_tfpaisdescripcion ;
   private String AV108Pacientewwds_27_tfpaisdescripcion_sel ;
   private String AV114Pacientewwds_33_tfubigeonombre ;
   private String AV115Pacientewwds_34_tfubigeonombre_sel ;
   private String AV120Pacientewwds_39_tfpacientenombreanexo ;
   private String AV121Pacientewwds_40_tfpacientenombreanexo_sel ;
   private String AV123Pacientewwds_42_tfpacienteespecifique ;
   private String AV124Pacientewwds_43_tfpacienteespecifique_sel ;
   private String lV82Pacientewwds_1_filterfulltext ;
   private String lV85Pacientewwds_4_tfpacienteapellidopaterno ;
   private String lV87Pacientewwds_6_tfpacienteapellidomaterno ;
   private String lV89Pacientewwds_8_tfpacientenombres ;
   private String lV91Pacientewwds_10_tfpacientenombrecompleto ;
   private String lV96Pacientewwds_15_tfpacientenrodocumento ;
   private String lV98Pacientewwds_17_tfpacientedireccion ;
   private String lV101Pacientewwds_20_tfpacientecorreo ;
   private String lV107Pacientewwds_26_tfpaisdescripcion ;
   private String lV114Pacientewwds_33_tfubigeonombre ;
   private String lV120Pacientewwds_39_tfpacientenombreanexo ;
   private String lV123Pacientewwds_42_tfpacienteespecifique ;
   private String A224PacienteEnterarse ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A222PacienteNombreAnexo ;
   private String A212PacienteNombreCompleto ;
   private String A185UbigeoNombre ;
   private String AV61Option ;
   private com.genexus.webpanels.WebSession AV70Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P002P2_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P2_A221PacientePeso ;
   private java.math.BigDecimal[] P002P2_A220PacienteEstatura ;
   private short[] P002P2_A6SecUserId ;
   private boolean[] P002P2_n6SecUserId ;
   private short[] P002P2_A43PaisId ;
   private java.util.Date[] P002P2_A213PacienteFechaNacimiento ;
   private int[] P002P2_A20PacienteId ;
   private String[] P002P2_A225PacienteEspecifique ;
   private boolean[] P002P2_n225PacienteEspecifique ;
   private String[] P002P2_A224PacienteEnterarse ;
   private boolean[] P002P2_n224PacienteEnterarse ;
   private String[] P002P2_A222PacienteNombreAnexo ;
   private boolean[] P002P2_n222PacienteNombreAnexo ;
   private String[] P002P2_A44UbigeoCode ;
   private boolean[] P002P2_n44UbigeoCode ;
   private String[] P002P2_A219PacienteEstado ;
   private String[] P002P2_A184PaisDescripcion ;
   private String[] P002P2_A218PacienteTelefono ;
   private String[] P002P2_A217PacienteCorreo ;
   private String[] P002P2_A216PacienteSexo ;
   private String[] P002P2_A215PacienteDireccion ;
   private String[] P002P2_A106PacienteNroDocumento ;
   private String[] P002P2_A214PacienteTipoDocumento ;
   private String[] P002P2_A105PacienteNombres ;
   private String[] P002P2_A104PacienteApellidoMaterno ;
   private String[] P002P2_A103PacienteApellidoPaterno ;
   private String[] P002P2_A188UbigeoDistrito ;
   private String[] P002P2_A187UbigeoProvincia ;
   private String[] P002P2_A186UbigeoDepartamento ;
   private java.util.Date[] P002P3_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P3_A221PacientePeso ;
   private java.math.BigDecimal[] P002P3_A220PacienteEstatura ;
   private short[] P002P3_A6SecUserId ;
   private boolean[] P002P3_n6SecUserId ;
   private short[] P002P3_A43PaisId ;
   private java.util.Date[] P002P3_A213PacienteFechaNacimiento ;
   private int[] P002P3_A20PacienteId ;
   private String[] P002P3_A225PacienteEspecifique ;
   private boolean[] P002P3_n225PacienteEspecifique ;
   private String[] P002P3_A224PacienteEnterarse ;
   private boolean[] P002P3_n224PacienteEnterarse ;
   private String[] P002P3_A222PacienteNombreAnexo ;
   private boolean[] P002P3_n222PacienteNombreAnexo ;
   private String[] P002P3_A44UbigeoCode ;
   private boolean[] P002P3_n44UbigeoCode ;
   private String[] P002P3_A219PacienteEstado ;
   private String[] P002P3_A184PaisDescripcion ;
   private String[] P002P3_A218PacienteTelefono ;
   private String[] P002P3_A217PacienteCorreo ;
   private String[] P002P3_A216PacienteSexo ;
   private String[] P002P3_A215PacienteDireccion ;
   private String[] P002P3_A106PacienteNroDocumento ;
   private String[] P002P3_A214PacienteTipoDocumento ;
   private String[] P002P3_A105PacienteNombres ;
   private String[] P002P3_A104PacienteApellidoMaterno ;
   private String[] P002P3_A103PacienteApellidoPaterno ;
   private String[] P002P3_A188UbigeoDistrito ;
   private String[] P002P3_A187UbigeoProvincia ;
   private String[] P002P3_A186UbigeoDepartamento ;
   private java.util.Date[] P002P4_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P4_A221PacientePeso ;
   private java.math.BigDecimal[] P002P4_A220PacienteEstatura ;
   private short[] P002P4_A6SecUserId ;
   private boolean[] P002P4_n6SecUserId ;
   private short[] P002P4_A43PaisId ;
   private java.util.Date[] P002P4_A213PacienteFechaNacimiento ;
   private int[] P002P4_A20PacienteId ;
   private String[] P002P4_A225PacienteEspecifique ;
   private boolean[] P002P4_n225PacienteEspecifique ;
   private String[] P002P4_A224PacienteEnterarse ;
   private boolean[] P002P4_n224PacienteEnterarse ;
   private String[] P002P4_A222PacienteNombreAnexo ;
   private boolean[] P002P4_n222PacienteNombreAnexo ;
   private String[] P002P4_A44UbigeoCode ;
   private boolean[] P002P4_n44UbigeoCode ;
   private String[] P002P4_A219PacienteEstado ;
   private String[] P002P4_A184PaisDescripcion ;
   private String[] P002P4_A218PacienteTelefono ;
   private String[] P002P4_A217PacienteCorreo ;
   private String[] P002P4_A216PacienteSexo ;
   private String[] P002P4_A215PacienteDireccion ;
   private String[] P002P4_A106PacienteNroDocumento ;
   private String[] P002P4_A214PacienteTipoDocumento ;
   private String[] P002P4_A105PacienteNombres ;
   private String[] P002P4_A104PacienteApellidoMaterno ;
   private String[] P002P4_A103PacienteApellidoPaterno ;
   private String[] P002P4_A188UbigeoDistrito ;
   private String[] P002P4_A187UbigeoProvincia ;
   private String[] P002P4_A186UbigeoDepartamento ;
   private java.util.Date[] P002P5_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P5_A221PacientePeso ;
   private java.math.BigDecimal[] P002P5_A220PacienteEstatura ;
   private short[] P002P5_A6SecUserId ;
   private boolean[] P002P5_n6SecUserId ;
   private short[] P002P5_A43PaisId ;
   private java.util.Date[] P002P5_A213PacienteFechaNacimiento ;
   private int[] P002P5_A20PacienteId ;
   private String[] P002P5_A225PacienteEspecifique ;
   private boolean[] P002P5_n225PacienteEspecifique ;
   private String[] P002P5_A224PacienteEnterarse ;
   private boolean[] P002P5_n224PacienteEnterarse ;
   private String[] P002P5_A222PacienteNombreAnexo ;
   private boolean[] P002P5_n222PacienteNombreAnexo ;
   private String[] P002P5_A44UbigeoCode ;
   private boolean[] P002P5_n44UbigeoCode ;
   private String[] P002P5_A219PacienteEstado ;
   private String[] P002P5_A184PaisDescripcion ;
   private String[] P002P5_A218PacienteTelefono ;
   private String[] P002P5_A217PacienteCorreo ;
   private String[] P002P5_A216PacienteSexo ;
   private String[] P002P5_A215PacienteDireccion ;
   private String[] P002P5_A106PacienteNroDocumento ;
   private String[] P002P5_A214PacienteTipoDocumento ;
   private String[] P002P5_A105PacienteNombres ;
   private String[] P002P5_A104PacienteApellidoMaterno ;
   private String[] P002P5_A103PacienteApellidoPaterno ;
   private String[] P002P5_A188UbigeoDistrito ;
   private String[] P002P5_A187UbigeoProvincia ;
   private String[] P002P5_A186UbigeoDepartamento ;
   private String[] P002P6_A106PacienteNroDocumento ;
   private java.util.Date[] P002P6_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P6_A221PacientePeso ;
   private java.math.BigDecimal[] P002P6_A220PacienteEstatura ;
   private short[] P002P6_A6SecUserId ;
   private boolean[] P002P6_n6SecUserId ;
   private short[] P002P6_A43PaisId ;
   private java.util.Date[] P002P6_A213PacienteFechaNacimiento ;
   private int[] P002P6_A20PacienteId ;
   private String[] P002P6_A225PacienteEspecifique ;
   private boolean[] P002P6_n225PacienteEspecifique ;
   private String[] P002P6_A224PacienteEnterarse ;
   private boolean[] P002P6_n224PacienteEnterarse ;
   private String[] P002P6_A222PacienteNombreAnexo ;
   private boolean[] P002P6_n222PacienteNombreAnexo ;
   private String[] P002P6_A44UbigeoCode ;
   private boolean[] P002P6_n44UbigeoCode ;
   private String[] P002P6_A219PacienteEstado ;
   private String[] P002P6_A184PaisDescripcion ;
   private String[] P002P6_A218PacienteTelefono ;
   private String[] P002P6_A217PacienteCorreo ;
   private String[] P002P6_A216PacienteSexo ;
   private String[] P002P6_A215PacienteDireccion ;
   private String[] P002P6_A214PacienteTipoDocumento ;
   private String[] P002P6_A105PacienteNombres ;
   private String[] P002P6_A104PacienteApellidoMaterno ;
   private String[] P002P6_A103PacienteApellidoPaterno ;
   private String[] P002P6_A188UbigeoDistrito ;
   private String[] P002P6_A187UbigeoProvincia ;
   private String[] P002P6_A186UbigeoDepartamento ;
   private String[] P002P7_A215PacienteDireccion ;
   private java.util.Date[] P002P7_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P7_A221PacientePeso ;
   private java.math.BigDecimal[] P002P7_A220PacienteEstatura ;
   private short[] P002P7_A6SecUserId ;
   private boolean[] P002P7_n6SecUserId ;
   private short[] P002P7_A43PaisId ;
   private java.util.Date[] P002P7_A213PacienteFechaNacimiento ;
   private int[] P002P7_A20PacienteId ;
   private String[] P002P7_A225PacienteEspecifique ;
   private boolean[] P002P7_n225PacienteEspecifique ;
   private String[] P002P7_A224PacienteEnterarse ;
   private boolean[] P002P7_n224PacienteEnterarse ;
   private String[] P002P7_A222PacienteNombreAnexo ;
   private boolean[] P002P7_n222PacienteNombreAnexo ;
   private String[] P002P7_A44UbigeoCode ;
   private boolean[] P002P7_n44UbigeoCode ;
   private String[] P002P7_A219PacienteEstado ;
   private String[] P002P7_A184PaisDescripcion ;
   private String[] P002P7_A218PacienteTelefono ;
   private String[] P002P7_A217PacienteCorreo ;
   private String[] P002P7_A216PacienteSexo ;
   private String[] P002P7_A106PacienteNroDocumento ;
   private String[] P002P7_A214PacienteTipoDocumento ;
   private String[] P002P7_A105PacienteNombres ;
   private String[] P002P7_A104PacienteApellidoMaterno ;
   private String[] P002P7_A103PacienteApellidoPaterno ;
   private String[] P002P7_A188UbigeoDistrito ;
   private String[] P002P7_A187UbigeoProvincia ;
   private String[] P002P7_A186UbigeoDepartamento ;
   private String[] P002P8_A217PacienteCorreo ;
   private java.util.Date[] P002P8_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P8_A221PacientePeso ;
   private java.math.BigDecimal[] P002P8_A220PacienteEstatura ;
   private short[] P002P8_A6SecUserId ;
   private boolean[] P002P8_n6SecUserId ;
   private short[] P002P8_A43PaisId ;
   private java.util.Date[] P002P8_A213PacienteFechaNacimiento ;
   private int[] P002P8_A20PacienteId ;
   private String[] P002P8_A225PacienteEspecifique ;
   private boolean[] P002P8_n225PacienteEspecifique ;
   private String[] P002P8_A224PacienteEnterarse ;
   private boolean[] P002P8_n224PacienteEnterarse ;
   private String[] P002P8_A222PacienteNombreAnexo ;
   private boolean[] P002P8_n222PacienteNombreAnexo ;
   private String[] P002P8_A44UbigeoCode ;
   private boolean[] P002P8_n44UbigeoCode ;
   private String[] P002P8_A219PacienteEstado ;
   private String[] P002P8_A184PaisDescripcion ;
   private String[] P002P8_A218PacienteTelefono ;
   private String[] P002P8_A216PacienteSexo ;
   private String[] P002P8_A215PacienteDireccion ;
   private String[] P002P8_A106PacienteNroDocumento ;
   private String[] P002P8_A214PacienteTipoDocumento ;
   private String[] P002P8_A105PacienteNombres ;
   private String[] P002P8_A104PacienteApellidoMaterno ;
   private String[] P002P8_A103PacienteApellidoPaterno ;
   private String[] P002P8_A188UbigeoDistrito ;
   private String[] P002P8_A187UbigeoProvincia ;
   private String[] P002P8_A186UbigeoDepartamento ;
   private String[] P002P9_A218PacienteTelefono ;
   private java.util.Date[] P002P9_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P9_A221PacientePeso ;
   private java.math.BigDecimal[] P002P9_A220PacienteEstatura ;
   private short[] P002P9_A6SecUserId ;
   private boolean[] P002P9_n6SecUserId ;
   private short[] P002P9_A43PaisId ;
   private java.util.Date[] P002P9_A213PacienteFechaNacimiento ;
   private int[] P002P9_A20PacienteId ;
   private String[] P002P9_A225PacienteEspecifique ;
   private boolean[] P002P9_n225PacienteEspecifique ;
   private String[] P002P9_A224PacienteEnterarse ;
   private boolean[] P002P9_n224PacienteEnterarse ;
   private String[] P002P9_A222PacienteNombreAnexo ;
   private boolean[] P002P9_n222PacienteNombreAnexo ;
   private String[] P002P9_A44UbigeoCode ;
   private boolean[] P002P9_n44UbigeoCode ;
   private String[] P002P9_A219PacienteEstado ;
   private String[] P002P9_A184PaisDescripcion ;
   private String[] P002P9_A217PacienteCorreo ;
   private String[] P002P9_A216PacienteSexo ;
   private String[] P002P9_A215PacienteDireccion ;
   private String[] P002P9_A106PacienteNroDocumento ;
   private String[] P002P9_A214PacienteTipoDocumento ;
   private String[] P002P9_A105PacienteNombres ;
   private String[] P002P9_A104PacienteApellidoMaterno ;
   private String[] P002P9_A103PacienteApellidoPaterno ;
   private String[] P002P9_A188UbigeoDistrito ;
   private String[] P002P9_A187UbigeoProvincia ;
   private String[] P002P9_A186UbigeoDepartamento ;
   private short[] P002P10_A43PaisId ;
   private java.util.Date[] P002P10_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P10_A221PacientePeso ;
   private java.math.BigDecimal[] P002P10_A220PacienteEstatura ;
   private short[] P002P10_A6SecUserId ;
   private boolean[] P002P10_n6SecUserId ;
   private java.util.Date[] P002P10_A213PacienteFechaNacimiento ;
   private int[] P002P10_A20PacienteId ;
   private String[] P002P10_A225PacienteEspecifique ;
   private boolean[] P002P10_n225PacienteEspecifique ;
   private String[] P002P10_A224PacienteEnterarse ;
   private boolean[] P002P10_n224PacienteEnterarse ;
   private String[] P002P10_A222PacienteNombreAnexo ;
   private boolean[] P002P10_n222PacienteNombreAnexo ;
   private String[] P002P10_A44UbigeoCode ;
   private boolean[] P002P10_n44UbigeoCode ;
   private String[] P002P10_A219PacienteEstado ;
   private String[] P002P10_A184PaisDescripcion ;
   private String[] P002P10_A218PacienteTelefono ;
   private String[] P002P10_A217PacienteCorreo ;
   private String[] P002P10_A216PacienteSexo ;
   private String[] P002P10_A215PacienteDireccion ;
   private String[] P002P10_A106PacienteNroDocumento ;
   private String[] P002P10_A214PacienteTipoDocumento ;
   private String[] P002P10_A105PacienteNombres ;
   private String[] P002P10_A104PacienteApellidoMaterno ;
   private String[] P002P10_A103PacienteApellidoPaterno ;
   private String[] P002P10_A188UbigeoDistrito ;
   private String[] P002P10_A187UbigeoProvincia ;
   private String[] P002P10_A186UbigeoDepartamento ;
   private String[] P002P11_A44UbigeoCode ;
   private boolean[] P002P11_n44UbigeoCode ;
   private java.util.Date[] P002P11_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P11_A221PacientePeso ;
   private java.math.BigDecimal[] P002P11_A220PacienteEstatura ;
   private short[] P002P11_A6SecUserId ;
   private boolean[] P002P11_n6SecUserId ;
   private short[] P002P11_A43PaisId ;
   private java.util.Date[] P002P11_A213PacienteFechaNacimiento ;
   private int[] P002P11_A20PacienteId ;
   private String[] P002P11_A225PacienteEspecifique ;
   private boolean[] P002P11_n225PacienteEspecifique ;
   private String[] P002P11_A224PacienteEnterarse ;
   private boolean[] P002P11_n224PacienteEnterarse ;
   private String[] P002P11_A222PacienteNombreAnexo ;
   private boolean[] P002P11_n222PacienteNombreAnexo ;
   private String[] P002P11_A219PacienteEstado ;
   private String[] P002P11_A184PaisDescripcion ;
   private String[] P002P11_A218PacienteTelefono ;
   private String[] P002P11_A217PacienteCorreo ;
   private String[] P002P11_A216PacienteSexo ;
   private String[] P002P11_A215PacienteDireccion ;
   private String[] P002P11_A106PacienteNroDocumento ;
   private String[] P002P11_A214PacienteTipoDocumento ;
   private String[] P002P11_A105PacienteNombres ;
   private String[] P002P11_A104PacienteApellidoMaterno ;
   private String[] P002P11_A103PacienteApellidoPaterno ;
   private String[] P002P11_A188UbigeoDistrito ;
   private String[] P002P11_A187UbigeoProvincia ;
   private String[] P002P11_A186UbigeoDepartamento ;
   private String[] P002P12_A44UbigeoCode ;
   private boolean[] P002P12_n44UbigeoCode ;
   private java.util.Date[] P002P12_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P12_A221PacientePeso ;
   private java.math.BigDecimal[] P002P12_A220PacienteEstatura ;
   private short[] P002P12_A6SecUserId ;
   private boolean[] P002P12_n6SecUserId ;
   private short[] P002P12_A43PaisId ;
   private java.util.Date[] P002P12_A213PacienteFechaNacimiento ;
   private int[] P002P12_A20PacienteId ;
   private String[] P002P12_A225PacienteEspecifique ;
   private boolean[] P002P12_n225PacienteEspecifique ;
   private String[] P002P12_A224PacienteEnterarse ;
   private boolean[] P002P12_n224PacienteEnterarse ;
   private String[] P002P12_A222PacienteNombreAnexo ;
   private boolean[] P002P12_n222PacienteNombreAnexo ;
   private String[] P002P12_A219PacienteEstado ;
   private String[] P002P12_A184PaisDescripcion ;
   private String[] P002P12_A218PacienteTelefono ;
   private String[] P002P12_A217PacienteCorreo ;
   private String[] P002P12_A216PacienteSexo ;
   private String[] P002P12_A215PacienteDireccion ;
   private String[] P002P12_A106PacienteNroDocumento ;
   private String[] P002P12_A214PacienteTipoDocumento ;
   private String[] P002P12_A105PacienteNombres ;
   private String[] P002P12_A104PacienteApellidoMaterno ;
   private String[] P002P12_A103PacienteApellidoPaterno ;
   private String[] P002P12_A188UbigeoDistrito ;
   private String[] P002P12_A187UbigeoProvincia ;
   private String[] P002P12_A186UbigeoDepartamento ;
   private String[] P002P13_A222PacienteNombreAnexo ;
   private boolean[] P002P13_n222PacienteNombreAnexo ;
   private java.util.Date[] P002P13_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P13_A221PacientePeso ;
   private java.math.BigDecimal[] P002P13_A220PacienteEstatura ;
   private short[] P002P13_A6SecUserId ;
   private boolean[] P002P13_n6SecUserId ;
   private short[] P002P13_A43PaisId ;
   private java.util.Date[] P002P13_A213PacienteFechaNacimiento ;
   private int[] P002P13_A20PacienteId ;
   private String[] P002P13_A225PacienteEspecifique ;
   private boolean[] P002P13_n225PacienteEspecifique ;
   private String[] P002P13_A224PacienteEnterarse ;
   private boolean[] P002P13_n224PacienteEnterarse ;
   private String[] P002P13_A44UbigeoCode ;
   private boolean[] P002P13_n44UbigeoCode ;
   private String[] P002P13_A219PacienteEstado ;
   private String[] P002P13_A184PaisDescripcion ;
   private String[] P002P13_A218PacienteTelefono ;
   private String[] P002P13_A217PacienteCorreo ;
   private String[] P002P13_A216PacienteSexo ;
   private String[] P002P13_A215PacienteDireccion ;
   private String[] P002P13_A106PacienteNroDocumento ;
   private String[] P002P13_A214PacienteTipoDocumento ;
   private String[] P002P13_A105PacienteNombres ;
   private String[] P002P13_A104PacienteApellidoMaterno ;
   private String[] P002P13_A103PacienteApellidoPaterno ;
   private String[] P002P13_A188UbigeoDistrito ;
   private String[] P002P13_A187UbigeoProvincia ;
   private String[] P002P13_A186UbigeoDepartamento ;
   private String[] P002P14_A225PacienteEspecifique ;
   private boolean[] P002P14_n225PacienteEspecifique ;
   private java.util.Date[] P002P14_A226PacienteFechaRegistro ;
   private java.math.BigDecimal[] P002P14_A221PacientePeso ;
   private java.math.BigDecimal[] P002P14_A220PacienteEstatura ;
   private short[] P002P14_A6SecUserId ;
   private boolean[] P002P14_n6SecUserId ;
   private short[] P002P14_A43PaisId ;
   private java.util.Date[] P002P14_A213PacienteFechaNacimiento ;
   private int[] P002P14_A20PacienteId ;
   private String[] P002P14_A224PacienteEnterarse ;
   private boolean[] P002P14_n224PacienteEnterarse ;
   private String[] P002P14_A222PacienteNombreAnexo ;
   private boolean[] P002P14_n222PacienteNombreAnexo ;
   private String[] P002P14_A44UbigeoCode ;
   private boolean[] P002P14_n44UbigeoCode ;
   private String[] P002P14_A219PacienteEstado ;
   private String[] P002P14_A184PaisDescripcion ;
   private String[] P002P14_A218PacienteTelefono ;
   private String[] P002P14_A217PacienteCorreo ;
   private String[] P002P14_A216PacienteSexo ;
   private String[] P002P14_A215PacienteDireccion ;
   private String[] P002P14_A106PacienteNroDocumento ;
   private String[] P002P14_A214PacienteTipoDocumento ;
   private String[] P002P14_A105PacienteNombres ;
   private String[] P002P14_A104PacienteApellidoMaterno ;
   private String[] P002P14_A103PacienteApellidoPaterno ;
   private String[] P002P14_A188UbigeoDistrito ;
   private String[] P002P14_A187UbigeoProvincia ;
   private String[] P002P14_A186UbigeoDepartamento ;
   private GXSimpleCollection<String> AV24TFPacienteTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV32TFPacienteSexo_Sels ;
   private GXSimpleCollection<String> AV42TFPacienteEstado_Sels ;
   private GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ;
   private GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ;
   private GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ;
   private GXSimpleCollection<String> AV62Options ;
   private GXSimpleCollection<String> AV65OptionsDesc ;
   private GXSimpleCollection<String> AV67OptionIndexes ;
   private GXSimpleCollection<String> AV30TFPacienteEnterarse_Sels ;
   private GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV72GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV73GridStateFilterValue ;
}

final  class pacientewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[76];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
         GXv_int4[19] = (byte)(1) ;
         GXv_int4[20] = (byte)(1) ;
         GXv_int4[21] = (byte)(1) ;
         GXv_int4[22] = (byte)(1) ;
         GXv_int4[23] = (byte)(1) ;
         GXv_int4[24] = (byte)(1) ;
         GXv_int4[25] = (byte)(1) ;
         GXv_int4[26] = (byte)(1) ;
         GXv_int4[27] = (byte)(1) ;
         GXv_int4[28] = (byte)(1) ;
         GXv_int4[29] = (byte)(1) ;
         GXv_int4[30] = (byte)(1) ;
         GXv_int4[31] = (byte)(1) ;
         GXv_int4[32] = (byte)(1) ;
         GXv_int4[33] = (byte)(1) ;
         GXv_int4[34] = (byte)(1) ;
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int4[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int4[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int4[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int4[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int4[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int4[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int4[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int4[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int4[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int4[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int4[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int4[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int4[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int4[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int4[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int4[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int4[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteApellidoPaterno]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002P3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[76];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
         GXv_int7[8] = (byte)(1) ;
         GXv_int7[9] = (byte)(1) ;
         GXv_int7[10] = (byte)(1) ;
         GXv_int7[11] = (byte)(1) ;
         GXv_int7[12] = (byte)(1) ;
         GXv_int7[13] = (byte)(1) ;
         GXv_int7[14] = (byte)(1) ;
         GXv_int7[15] = (byte)(1) ;
         GXv_int7[16] = (byte)(1) ;
         GXv_int7[17] = (byte)(1) ;
         GXv_int7[18] = (byte)(1) ;
         GXv_int7[19] = (byte)(1) ;
         GXv_int7[20] = (byte)(1) ;
         GXv_int7[21] = (byte)(1) ;
         GXv_int7[22] = (byte)(1) ;
         GXv_int7[23] = (byte)(1) ;
         GXv_int7[24] = (byte)(1) ;
         GXv_int7[25] = (byte)(1) ;
         GXv_int7[26] = (byte)(1) ;
         GXv_int7[27] = (byte)(1) ;
         GXv_int7[28] = (byte)(1) ;
         GXv_int7[29] = (byte)(1) ;
         GXv_int7[30] = (byte)(1) ;
         GXv_int7[31] = (byte)(1) ;
         GXv_int7[32] = (byte)(1) ;
         GXv_int7[33] = (byte)(1) ;
         GXv_int7[34] = (byte)(1) ;
         GXv_int7[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int7[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int7[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int7[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int7[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int7[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int7[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int7[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int7[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int7[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int7[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int7[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int7[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int7[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int7[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int7[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int7[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int7[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int7[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int7[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int7[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int7[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int7[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int7[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int7[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int7[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int7[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int7[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int7[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int7[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int7[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int7[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int7[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int7[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int7[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int7[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int7[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int7[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int7[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteApellidoMaterno]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002P4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[76];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
         GXv_int10[10] = (byte)(1) ;
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
         GXv_int10[13] = (byte)(1) ;
         GXv_int10[14] = (byte)(1) ;
         GXv_int10[15] = (byte)(1) ;
         GXv_int10[16] = (byte)(1) ;
         GXv_int10[17] = (byte)(1) ;
         GXv_int10[18] = (byte)(1) ;
         GXv_int10[19] = (byte)(1) ;
         GXv_int10[20] = (byte)(1) ;
         GXv_int10[21] = (byte)(1) ;
         GXv_int10[22] = (byte)(1) ;
         GXv_int10[23] = (byte)(1) ;
         GXv_int10[24] = (byte)(1) ;
         GXv_int10[25] = (byte)(1) ;
         GXv_int10[26] = (byte)(1) ;
         GXv_int10[27] = (byte)(1) ;
         GXv_int10[28] = (byte)(1) ;
         GXv_int10[29] = (byte)(1) ;
         GXv_int10[30] = (byte)(1) ;
         GXv_int10[31] = (byte)(1) ;
         GXv_int10[32] = (byte)(1) ;
         GXv_int10[33] = (byte)(1) ;
         GXv_int10[34] = (byte)(1) ;
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int10[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int10[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int10[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int10[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int10[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int10[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int10[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int10[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int10[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int10[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int10[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int10[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int10[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int10[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int10[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int10[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int10[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int10[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int10[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int10[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int10[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int10[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int10[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int10[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int10[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int10[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int10[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int10[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int10[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteNombres]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P002P5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[76];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int13[0] = (byte)(1) ;
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
         GXv_int13[9] = (byte)(1) ;
         GXv_int13[10] = (byte)(1) ;
         GXv_int13[11] = (byte)(1) ;
         GXv_int13[12] = (byte)(1) ;
         GXv_int13[13] = (byte)(1) ;
         GXv_int13[14] = (byte)(1) ;
         GXv_int13[15] = (byte)(1) ;
         GXv_int13[16] = (byte)(1) ;
         GXv_int13[17] = (byte)(1) ;
         GXv_int13[18] = (byte)(1) ;
         GXv_int13[19] = (byte)(1) ;
         GXv_int13[20] = (byte)(1) ;
         GXv_int13[21] = (byte)(1) ;
         GXv_int13[22] = (byte)(1) ;
         GXv_int13[23] = (byte)(1) ;
         GXv_int13[24] = (byte)(1) ;
         GXv_int13[25] = (byte)(1) ;
         GXv_int13[26] = (byte)(1) ;
         GXv_int13[27] = (byte)(1) ;
         GXv_int13[28] = (byte)(1) ;
         GXv_int13[29] = (byte)(1) ;
         GXv_int13[30] = (byte)(1) ;
         GXv_int13[31] = (byte)(1) ;
         GXv_int13[32] = (byte)(1) ;
         GXv_int13[33] = (byte)(1) ;
         GXv_int13[34] = (byte)(1) ;
         GXv_int13[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int13[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int13[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int13[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int13[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int13[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int13[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int13[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int13[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int13[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int13[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int13[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int13[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int13[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int13[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int13[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int13[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int13[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int13[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int13[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int13[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int13[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int13[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int13[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int13[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int13[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int13[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int13[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int13[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int13[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int13[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int13[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int13[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int13[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int13[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int13[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int13[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int13[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int13[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteId]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P002P6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[76];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteNroDocumento], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento]," ;
      scmdbuf += " T1.[PacienteId], T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono]," ;
      scmdbuf += " T1.[PacienteCorreo], T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
         GXv_int16[1] = (byte)(1) ;
         GXv_int16[2] = (byte)(1) ;
         GXv_int16[3] = (byte)(1) ;
         GXv_int16[4] = (byte)(1) ;
         GXv_int16[5] = (byte)(1) ;
         GXv_int16[6] = (byte)(1) ;
         GXv_int16[7] = (byte)(1) ;
         GXv_int16[8] = (byte)(1) ;
         GXv_int16[9] = (byte)(1) ;
         GXv_int16[10] = (byte)(1) ;
         GXv_int16[11] = (byte)(1) ;
         GXv_int16[12] = (byte)(1) ;
         GXv_int16[13] = (byte)(1) ;
         GXv_int16[14] = (byte)(1) ;
         GXv_int16[15] = (byte)(1) ;
         GXv_int16[16] = (byte)(1) ;
         GXv_int16[17] = (byte)(1) ;
         GXv_int16[18] = (byte)(1) ;
         GXv_int16[19] = (byte)(1) ;
         GXv_int16[20] = (byte)(1) ;
         GXv_int16[21] = (byte)(1) ;
         GXv_int16[22] = (byte)(1) ;
         GXv_int16[23] = (byte)(1) ;
         GXv_int16[24] = (byte)(1) ;
         GXv_int16[25] = (byte)(1) ;
         GXv_int16[26] = (byte)(1) ;
         GXv_int16[27] = (byte)(1) ;
         GXv_int16[28] = (byte)(1) ;
         GXv_int16[29] = (byte)(1) ;
         GXv_int16[30] = (byte)(1) ;
         GXv_int16[31] = (byte)(1) ;
         GXv_int16[32] = (byte)(1) ;
         GXv_int16[33] = (byte)(1) ;
         GXv_int16[34] = (byte)(1) ;
         GXv_int16[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int16[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int16[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int16[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int16[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int16[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int16[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int16[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int16[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int16[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int16[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int16[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int16[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int16[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int16[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int16[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int16[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int16[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int16[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int16[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int16[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int16[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int16[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int16[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int16[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int16[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int16[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int16[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int16[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int16[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int16[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int16[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int16[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int16[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int16[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int16[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int16[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int16[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int16[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteNroDocumento]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P002P7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[76];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteDireccion], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId]," ;
      scmdbuf += " T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo]," ;
      scmdbuf += " T1.[PacienteSexo], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno], T3.[UbigeoDistrito]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] =" ;
      scmdbuf += " T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
         GXv_int19[1] = (byte)(1) ;
         GXv_int19[2] = (byte)(1) ;
         GXv_int19[3] = (byte)(1) ;
         GXv_int19[4] = (byte)(1) ;
         GXv_int19[5] = (byte)(1) ;
         GXv_int19[6] = (byte)(1) ;
         GXv_int19[7] = (byte)(1) ;
         GXv_int19[8] = (byte)(1) ;
         GXv_int19[9] = (byte)(1) ;
         GXv_int19[10] = (byte)(1) ;
         GXv_int19[11] = (byte)(1) ;
         GXv_int19[12] = (byte)(1) ;
         GXv_int19[13] = (byte)(1) ;
         GXv_int19[14] = (byte)(1) ;
         GXv_int19[15] = (byte)(1) ;
         GXv_int19[16] = (byte)(1) ;
         GXv_int19[17] = (byte)(1) ;
         GXv_int19[18] = (byte)(1) ;
         GXv_int19[19] = (byte)(1) ;
         GXv_int19[20] = (byte)(1) ;
         GXv_int19[21] = (byte)(1) ;
         GXv_int19[22] = (byte)(1) ;
         GXv_int19[23] = (byte)(1) ;
         GXv_int19[24] = (byte)(1) ;
         GXv_int19[25] = (byte)(1) ;
         GXv_int19[26] = (byte)(1) ;
         GXv_int19[27] = (byte)(1) ;
         GXv_int19[28] = (byte)(1) ;
         GXv_int19[29] = (byte)(1) ;
         GXv_int19[30] = (byte)(1) ;
         GXv_int19[31] = (byte)(1) ;
         GXv_int19[32] = (byte)(1) ;
         GXv_int19[33] = (byte)(1) ;
         GXv_int19[34] = (byte)(1) ;
         GXv_int19[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int19[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int19[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int19[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int19[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int19[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int19[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int19[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int19[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int19[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int19[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int19[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int19[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int19[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int19[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int19[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int19[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int19[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int19[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int19[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int19[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int19[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int19[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int19[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int19[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int19[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int19[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int19[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int19[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int19[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int19[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int19[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int19[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int19[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int19[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int19[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int19[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int19[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int19[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteDireccion]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P002P8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[76];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteCorreo], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId]," ;
      scmdbuf += " T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
         GXv_int22[1] = (byte)(1) ;
         GXv_int22[2] = (byte)(1) ;
         GXv_int22[3] = (byte)(1) ;
         GXv_int22[4] = (byte)(1) ;
         GXv_int22[5] = (byte)(1) ;
         GXv_int22[6] = (byte)(1) ;
         GXv_int22[7] = (byte)(1) ;
         GXv_int22[8] = (byte)(1) ;
         GXv_int22[9] = (byte)(1) ;
         GXv_int22[10] = (byte)(1) ;
         GXv_int22[11] = (byte)(1) ;
         GXv_int22[12] = (byte)(1) ;
         GXv_int22[13] = (byte)(1) ;
         GXv_int22[14] = (byte)(1) ;
         GXv_int22[15] = (byte)(1) ;
         GXv_int22[16] = (byte)(1) ;
         GXv_int22[17] = (byte)(1) ;
         GXv_int22[18] = (byte)(1) ;
         GXv_int22[19] = (byte)(1) ;
         GXv_int22[20] = (byte)(1) ;
         GXv_int22[21] = (byte)(1) ;
         GXv_int22[22] = (byte)(1) ;
         GXv_int22[23] = (byte)(1) ;
         GXv_int22[24] = (byte)(1) ;
         GXv_int22[25] = (byte)(1) ;
         GXv_int22[26] = (byte)(1) ;
         GXv_int22[27] = (byte)(1) ;
         GXv_int22[28] = (byte)(1) ;
         GXv_int22[29] = (byte)(1) ;
         GXv_int22[30] = (byte)(1) ;
         GXv_int22[31] = (byte)(1) ;
         GXv_int22[32] = (byte)(1) ;
         GXv_int22[33] = (byte)(1) ;
         GXv_int22[34] = (byte)(1) ;
         GXv_int22[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int22[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int22[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int22[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int22[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int22[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int22[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int22[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int22[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int22[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int22[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int22[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int22[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int22[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int22[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int22[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int22[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int22[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int22[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int22[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int22[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int22[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int22[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int22[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int22[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int22[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int22[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int22[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int22[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int22[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int22[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int22[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int22[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int22[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int22[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int22[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int22[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int22[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int22[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int22[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int22[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteCorreo]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P002P9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A214PacienteTipoDocumento ,
                                          GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                          String A216PacienteSexo ,
                                          GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                          String A219PacienteEstado ,
                                          GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                          String A224PacienteEnterarse ,
                                          GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                          String AV82Pacientewwds_1_filterfulltext ,
                                          int AV83Pacientewwds_2_tfpacienteid ,
                                          int AV84Pacientewwds_3_tfpacienteid_to ,
                                          String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                          String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                          String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                          String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                          String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                          String AV89Pacientewwds_8_tfpacientenombres ,
                                          String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                          String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                          java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                          java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                          int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                          String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                          String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                          String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                          String AV98Pacientewwds_17_tfpacientedireccion ,
                                          int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                          String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                          String AV101Pacientewwds_20_tfpacientecorreo ,
                                          String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                          String AV103Pacientewwds_22_tfpacientetelefono ,
                                          short AV105Pacientewwds_24_tfpaisid ,
                                          short AV106Pacientewwds_25_tfpaisid_to ,
                                          String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                          String AV107Pacientewwds_26_tfpaisdescripcion ,
                                          int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                          short AV110Pacientewwds_29_tfsecuserid ,
                                          short AV111Pacientewwds_30_tfsecuserid_to ,
                                          String AV113Pacientewwds_32_tfubigeocode_sel ,
                                          String AV112Pacientewwds_31_tfubigeocode ,
                                          String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                          String AV114Pacientewwds_33_tfubigeonombre ,
                                          java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                          java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                          java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                          java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                          String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                          String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                          int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                          String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                          String AV123Pacientewwds_42_tfpacienteespecifique ,
                                          java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                          java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                          java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[76];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteTelefono], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId]," ;
      scmdbuf += " T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
         GXv_int25[1] = (byte)(1) ;
         GXv_int25[2] = (byte)(1) ;
         GXv_int25[3] = (byte)(1) ;
         GXv_int25[4] = (byte)(1) ;
         GXv_int25[5] = (byte)(1) ;
         GXv_int25[6] = (byte)(1) ;
         GXv_int25[7] = (byte)(1) ;
         GXv_int25[8] = (byte)(1) ;
         GXv_int25[9] = (byte)(1) ;
         GXv_int25[10] = (byte)(1) ;
         GXv_int25[11] = (byte)(1) ;
         GXv_int25[12] = (byte)(1) ;
         GXv_int25[13] = (byte)(1) ;
         GXv_int25[14] = (byte)(1) ;
         GXv_int25[15] = (byte)(1) ;
         GXv_int25[16] = (byte)(1) ;
         GXv_int25[17] = (byte)(1) ;
         GXv_int25[18] = (byte)(1) ;
         GXv_int25[19] = (byte)(1) ;
         GXv_int25[20] = (byte)(1) ;
         GXv_int25[21] = (byte)(1) ;
         GXv_int25[22] = (byte)(1) ;
         GXv_int25[23] = (byte)(1) ;
         GXv_int25[24] = (byte)(1) ;
         GXv_int25[25] = (byte)(1) ;
         GXv_int25[26] = (byte)(1) ;
         GXv_int25[27] = (byte)(1) ;
         GXv_int25[28] = (byte)(1) ;
         GXv_int25[29] = (byte)(1) ;
         GXv_int25[30] = (byte)(1) ;
         GXv_int25[31] = (byte)(1) ;
         GXv_int25[32] = (byte)(1) ;
         GXv_int25[33] = (byte)(1) ;
         GXv_int25[34] = (byte)(1) ;
         GXv_int25[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int25[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int25[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int25[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int25[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int25[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int25[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int25[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int25[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int25[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int25[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int25[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int25[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int25[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int25[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int25[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int25[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int25[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int25[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int25[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int25[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int25[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int25[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int25[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int25[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int25[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int25[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int25[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int25[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int25[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int25[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int25[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int25[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int25[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int25[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int25[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int25[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int25[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int25[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int25[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int25[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteTelefono]" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_P002P10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A214PacienteTipoDocumento ,
                                           GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           String A216PacienteSexo ,
                                           GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           String A219PacienteEstado ,
                                           GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           String A224PacienteEnterarse ,
                                           GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           String AV82Pacientewwds_1_filterfulltext ,
                                           int AV83Pacientewwds_2_tfpacienteid ,
                                           int AV84Pacientewwds_3_tfpacienteid_to ,
                                           String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           String AV89Pacientewwds_8_tfpacientenombres ,
                                           String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                           String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           String AV98Pacientewwds_17_tfpacientedireccion ,
                                           int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                           String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           String AV101Pacientewwds_20_tfpacientecorreo ,
                                           String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           String AV103Pacientewwds_22_tfpacientetelefono ,
                                           short AV105Pacientewwds_24_tfpaisid ,
                                           short AV106Pacientewwds_25_tfpaisid_to ,
                                           String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           String AV107Pacientewwds_26_tfpaisdescripcion ,
                                           int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                           short AV110Pacientewwds_29_tfsecuserid ,
                                           short AV111Pacientewwds_30_tfsecuserid_to ,
                                           String AV113Pacientewwds_32_tfubigeocode_sel ,
                                           String AV112Pacientewwds_31_tfubigeocode ,
                                           String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           String AV114Pacientewwds_33_tfubigeonombre ,
                                           java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                           java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                           java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                           String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                           String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           String AV123Pacientewwds_42_tfpacienteespecifique ,
                                           java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[76];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT T1.[PaisId], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PacienteFechaNacimiento], T1.[PacienteId], T1.[PacienteEspecifique]," ;
      scmdbuf += " T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo]," ;
      scmdbuf += " T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int28[0] = (byte)(1) ;
         GXv_int28[1] = (byte)(1) ;
         GXv_int28[2] = (byte)(1) ;
         GXv_int28[3] = (byte)(1) ;
         GXv_int28[4] = (byte)(1) ;
         GXv_int28[5] = (byte)(1) ;
         GXv_int28[6] = (byte)(1) ;
         GXv_int28[7] = (byte)(1) ;
         GXv_int28[8] = (byte)(1) ;
         GXv_int28[9] = (byte)(1) ;
         GXv_int28[10] = (byte)(1) ;
         GXv_int28[11] = (byte)(1) ;
         GXv_int28[12] = (byte)(1) ;
         GXv_int28[13] = (byte)(1) ;
         GXv_int28[14] = (byte)(1) ;
         GXv_int28[15] = (byte)(1) ;
         GXv_int28[16] = (byte)(1) ;
         GXv_int28[17] = (byte)(1) ;
         GXv_int28[18] = (byte)(1) ;
         GXv_int28[19] = (byte)(1) ;
         GXv_int28[20] = (byte)(1) ;
         GXv_int28[21] = (byte)(1) ;
         GXv_int28[22] = (byte)(1) ;
         GXv_int28[23] = (byte)(1) ;
         GXv_int28[24] = (byte)(1) ;
         GXv_int28[25] = (byte)(1) ;
         GXv_int28[26] = (byte)(1) ;
         GXv_int28[27] = (byte)(1) ;
         GXv_int28[28] = (byte)(1) ;
         GXv_int28[29] = (byte)(1) ;
         GXv_int28[30] = (byte)(1) ;
         GXv_int28[31] = (byte)(1) ;
         GXv_int28[32] = (byte)(1) ;
         GXv_int28[33] = (byte)(1) ;
         GXv_int28[34] = (byte)(1) ;
         GXv_int28[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int28[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int28[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int28[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int28[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int28[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int28[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int28[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int28[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int28[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int28[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int28[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int28[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int28[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int28[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int28[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int28[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int28[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int28[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int28[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int28[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int28[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int28[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int28[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int28[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int28[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int28[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int28[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int28[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int28[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int28[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int28[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int28[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int28[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int28[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int28[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int28[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int28[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int28[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int28[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int28[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PaisId]" ;
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
   }

   protected Object[] conditional_P002P11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A214PacienteTipoDocumento ,
                                           GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           String A216PacienteSexo ,
                                           GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           String A219PacienteEstado ,
                                           GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           String A224PacienteEnterarse ,
                                           GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           String AV82Pacientewwds_1_filterfulltext ,
                                           int AV83Pacientewwds_2_tfpacienteid ,
                                           int AV84Pacientewwds_3_tfpacienteid_to ,
                                           String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           String AV89Pacientewwds_8_tfpacientenombres ,
                                           String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                           String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           String AV98Pacientewwds_17_tfpacientedireccion ,
                                           int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                           String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           String AV101Pacientewwds_20_tfpacientecorreo ,
                                           String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           String AV103Pacientewwds_22_tfpacientetelefono ,
                                           short AV105Pacientewwds_24_tfpaisid ,
                                           short AV106Pacientewwds_25_tfpaisid_to ,
                                           String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           String AV107Pacientewwds_26_tfpaisdescripcion ,
                                           int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                           short AV110Pacientewwds_29_tfsecuserid ,
                                           short AV111Pacientewwds_30_tfsecuserid_to ,
                                           String AV113Pacientewwds_32_tfubigeocode_sel ,
                                           String AV112Pacientewwds_31_tfubigeocode ,
                                           String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           String AV114Pacientewwds_33_tfubigeonombre ,
                                           java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                           java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                           java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                           String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                           String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           String AV123Pacientewwds_42_tfpacienteespecifique ,
                                           java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int31 = new byte[76];
      Object[] GXv_Object32 = new Object[2];
      scmdbuf = "SELECT T1.[UbigeoCode], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId]," ;
      scmdbuf += " T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[PacienteEstado], T3.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo]," ;
      scmdbuf += " T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento] FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais]" ;
      scmdbuf += " T3 ON T3.[PaisId] = T1.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T3.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int31[0] = (byte)(1) ;
         GXv_int31[1] = (byte)(1) ;
         GXv_int31[2] = (byte)(1) ;
         GXv_int31[3] = (byte)(1) ;
         GXv_int31[4] = (byte)(1) ;
         GXv_int31[5] = (byte)(1) ;
         GXv_int31[6] = (byte)(1) ;
         GXv_int31[7] = (byte)(1) ;
         GXv_int31[8] = (byte)(1) ;
         GXv_int31[9] = (byte)(1) ;
         GXv_int31[10] = (byte)(1) ;
         GXv_int31[11] = (byte)(1) ;
         GXv_int31[12] = (byte)(1) ;
         GXv_int31[13] = (byte)(1) ;
         GXv_int31[14] = (byte)(1) ;
         GXv_int31[15] = (byte)(1) ;
         GXv_int31[16] = (byte)(1) ;
         GXv_int31[17] = (byte)(1) ;
         GXv_int31[18] = (byte)(1) ;
         GXv_int31[19] = (byte)(1) ;
         GXv_int31[20] = (byte)(1) ;
         GXv_int31[21] = (byte)(1) ;
         GXv_int31[22] = (byte)(1) ;
         GXv_int31[23] = (byte)(1) ;
         GXv_int31[24] = (byte)(1) ;
         GXv_int31[25] = (byte)(1) ;
         GXv_int31[26] = (byte)(1) ;
         GXv_int31[27] = (byte)(1) ;
         GXv_int31[28] = (byte)(1) ;
         GXv_int31[29] = (byte)(1) ;
         GXv_int31[30] = (byte)(1) ;
         GXv_int31[31] = (byte)(1) ;
         GXv_int31[32] = (byte)(1) ;
         GXv_int31[33] = (byte)(1) ;
         GXv_int31[34] = (byte)(1) ;
         GXv_int31[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int31[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int31[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int31[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int31[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int31[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int31[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int31[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int31[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int31[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int31[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int31[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int31[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int31[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int31[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int31[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int31[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int31[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int31[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int31[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int31[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int31[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int31[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int31[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int31[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int31[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int31[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int31[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int31[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int31[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int31[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int31[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int31[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int31[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int31[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int31[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int31[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int31[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int31[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int31[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int31[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      GXv_Object32[0] = scmdbuf ;
      GXv_Object32[1] = GXv_int31 ;
      return GXv_Object32 ;
   }

   protected Object[] conditional_P002P12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A214PacienteTipoDocumento ,
                                           GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           String A216PacienteSexo ,
                                           GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           String A219PacienteEstado ,
                                           GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           String A224PacienteEnterarse ,
                                           GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           String AV82Pacientewwds_1_filterfulltext ,
                                           int AV83Pacientewwds_2_tfpacienteid ,
                                           int AV84Pacientewwds_3_tfpacienteid_to ,
                                           String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           String AV89Pacientewwds_8_tfpacientenombres ,
                                           String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                           String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           String AV98Pacientewwds_17_tfpacientedireccion ,
                                           int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                           String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           String AV101Pacientewwds_20_tfpacientecorreo ,
                                           String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           String AV103Pacientewwds_22_tfpacientetelefono ,
                                           short AV105Pacientewwds_24_tfpaisid ,
                                           short AV106Pacientewwds_25_tfpaisid_to ,
                                           String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           String AV107Pacientewwds_26_tfpaisdescripcion ,
                                           int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                           short AV110Pacientewwds_29_tfsecuserid ,
                                           short AV111Pacientewwds_30_tfsecuserid_to ,
                                           String AV113Pacientewwds_32_tfubigeocode_sel ,
                                           String AV112Pacientewwds_31_tfubigeocode ,
                                           String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           String AV114Pacientewwds_33_tfubigeonombre ,
                                           java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                           java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                           java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                           String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                           String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           String AV123Pacientewwds_42_tfpacienteespecifique ,
                                           java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int34 = new byte[76];
      Object[] GXv_Object35 = new Object[2];
      scmdbuf = "SELECT T1.[UbigeoCode], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento], T1.[PacienteId]," ;
      scmdbuf += " T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[PacienteEstado], T3.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo]," ;
      scmdbuf += " T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento] FROM (([Paciente] T1 LEFT JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) INNER JOIN [Pais]" ;
      scmdbuf += " T3 ON T3.[PaisId] = T1.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T3.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int34[0] = (byte)(1) ;
         GXv_int34[1] = (byte)(1) ;
         GXv_int34[2] = (byte)(1) ;
         GXv_int34[3] = (byte)(1) ;
         GXv_int34[4] = (byte)(1) ;
         GXv_int34[5] = (byte)(1) ;
         GXv_int34[6] = (byte)(1) ;
         GXv_int34[7] = (byte)(1) ;
         GXv_int34[8] = (byte)(1) ;
         GXv_int34[9] = (byte)(1) ;
         GXv_int34[10] = (byte)(1) ;
         GXv_int34[11] = (byte)(1) ;
         GXv_int34[12] = (byte)(1) ;
         GXv_int34[13] = (byte)(1) ;
         GXv_int34[14] = (byte)(1) ;
         GXv_int34[15] = (byte)(1) ;
         GXv_int34[16] = (byte)(1) ;
         GXv_int34[17] = (byte)(1) ;
         GXv_int34[18] = (byte)(1) ;
         GXv_int34[19] = (byte)(1) ;
         GXv_int34[20] = (byte)(1) ;
         GXv_int34[21] = (byte)(1) ;
         GXv_int34[22] = (byte)(1) ;
         GXv_int34[23] = (byte)(1) ;
         GXv_int34[24] = (byte)(1) ;
         GXv_int34[25] = (byte)(1) ;
         GXv_int34[26] = (byte)(1) ;
         GXv_int34[27] = (byte)(1) ;
         GXv_int34[28] = (byte)(1) ;
         GXv_int34[29] = (byte)(1) ;
         GXv_int34[30] = (byte)(1) ;
         GXv_int34[31] = (byte)(1) ;
         GXv_int34[32] = (byte)(1) ;
         GXv_int34[33] = (byte)(1) ;
         GXv_int34[34] = (byte)(1) ;
         GXv_int34[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int34[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int34[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int34[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int34[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int34[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int34[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int34[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int34[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int34[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int34[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int34[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int34[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int34[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int34[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int34[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int34[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int34[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int34[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int34[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int34[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int34[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int34[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int34[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int34[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int34[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int34[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int34[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int34[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int34[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[UbigeoDepartamento] + ' / ' + T2.[UbigeoProvincia] + ' / ' + T2.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int34[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int34[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int34[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int34[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int34[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int34[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int34[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int34[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int34[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int34[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int34[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      GXv_Object35[0] = scmdbuf ;
      GXv_Object35[1] = GXv_int34 ;
      return GXv_Object35 ;
   }

   protected Object[] conditional_P002P13( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A214PacienteTipoDocumento ,
                                           GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           String A216PacienteSexo ,
                                           GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           String A219PacienteEstado ,
                                           GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           String A224PacienteEnterarse ,
                                           GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           String AV82Pacientewwds_1_filterfulltext ,
                                           int AV83Pacientewwds_2_tfpacienteid ,
                                           int AV84Pacientewwds_3_tfpacienteid_to ,
                                           String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           String AV89Pacientewwds_8_tfpacientenombres ,
                                           String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                           String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           String AV98Pacientewwds_17_tfpacientedireccion ,
                                           int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                           String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           String AV101Pacientewwds_20_tfpacientecorreo ,
                                           String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           String AV103Pacientewwds_22_tfpacientetelefono ,
                                           short AV105Pacientewwds_24_tfpaisid ,
                                           short AV106Pacientewwds_25_tfpaisid_to ,
                                           String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           String AV107Pacientewwds_26_tfpaisdescripcion ,
                                           int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                           short AV110Pacientewwds_29_tfsecuserid ,
                                           short AV111Pacientewwds_30_tfsecuserid_to ,
                                           String AV113Pacientewwds_32_tfubigeocode_sel ,
                                           String AV112Pacientewwds_31_tfubigeocode ,
                                           String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           String AV114Pacientewwds_33_tfubigeonombre ,
                                           java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                           java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                           java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                           String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                           String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           String AV123Pacientewwds_42_tfpacienteespecifique ,
                                           java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int37 = new byte[76];
      Object[] GXv_Object38 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteNombreAnexo], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento]," ;
      scmdbuf += " T1.[PacienteId], T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo]," ;
      scmdbuf += " T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int37[0] = (byte)(1) ;
         GXv_int37[1] = (byte)(1) ;
         GXv_int37[2] = (byte)(1) ;
         GXv_int37[3] = (byte)(1) ;
         GXv_int37[4] = (byte)(1) ;
         GXv_int37[5] = (byte)(1) ;
         GXv_int37[6] = (byte)(1) ;
         GXv_int37[7] = (byte)(1) ;
         GXv_int37[8] = (byte)(1) ;
         GXv_int37[9] = (byte)(1) ;
         GXv_int37[10] = (byte)(1) ;
         GXv_int37[11] = (byte)(1) ;
         GXv_int37[12] = (byte)(1) ;
         GXv_int37[13] = (byte)(1) ;
         GXv_int37[14] = (byte)(1) ;
         GXv_int37[15] = (byte)(1) ;
         GXv_int37[16] = (byte)(1) ;
         GXv_int37[17] = (byte)(1) ;
         GXv_int37[18] = (byte)(1) ;
         GXv_int37[19] = (byte)(1) ;
         GXv_int37[20] = (byte)(1) ;
         GXv_int37[21] = (byte)(1) ;
         GXv_int37[22] = (byte)(1) ;
         GXv_int37[23] = (byte)(1) ;
         GXv_int37[24] = (byte)(1) ;
         GXv_int37[25] = (byte)(1) ;
         GXv_int37[26] = (byte)(1) ;
         GXv_int37[27] = (byte)(1) ;
         GXv_int37[28] = (byte)(1) ;
         GXv_int37[29] = (byte)(1) ;
         GXv_int37[30] = (byte)(1) ;
         GXv_int37[31] = (byte)(1) ;
         GXv_int37[32] = (byte)(1) ;
         GXv_int37[33] = (byte)(1) ;
         GXv_int37[34] = (byte)(1) ;
         GXv_int37[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int37[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int37[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int37[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int37[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int37[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int37[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int37[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int37[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int37[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int37[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int37[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int37[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int37[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int37[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int37[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int37[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int37[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int37[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int37[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int37[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int37[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int37[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int37[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int37[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int37[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int37[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int37[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int37[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int37[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int37[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int37[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int37[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int37[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int37[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int37[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int37[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int37[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int37[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int37[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int37[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteNombreAnexo]" ;
      GXv_Object38[0] = scmdbuf ;
      GXv_Object38[1] = GXv_int37 ;
      return GXv_Object38 ;
   }

   protected Object[] conditional_P002P14( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A214PacienteTipoDocumento ,
                                           GXSimpleCollection<String> AV95Pacientewwds_14_tfpacientetipodocumento_sels ,
                                           String A216PacienteSexo ,
                                           GXSimpleCollection<String> AV100Pacientewwds_19_tfpacientesexo_sels ,
                                           String A219PacienteEstado ,
                                           GXSimpleCollection<String> AV109Pacientewwds_28_tfpacienteestado_sels ,
                                           String A224PacienteEnterarse ,
                                           GXSimpleCollection<String> AV122Pacientewwds_41_tfpacienteenterarse_sels ,
                                           String AV82Pacientewwds_1_filterfulltext ,
                                           int AV83Pacientewwds_2_tfpacienteid ,
                                           int AV84Pacientewwds_3_tfpacienteid_to ,
                                           String AV86Pacientewwds_5_tfpacienteapellidopaterno_sel ,
                                           String AV85Pacientewwds_4_tfpacienteapellidopaterno ,
                                           String AV88Pacientewwds_7_tfpacienteapellidomaterno_sel ,
                                           String AV87Pacientewwds_6_tfpacienteapellidomaterno ,
                                           String AV90Pacientewwds_9_tfpacientenombres_sel ,
                                           String AV89Pacientewwds_8_tfpacientenombres ,
                                           String AV92Pacientewwds_11_tfpacientenombrecompleto_sel ,
                                           String AV91Pacientewwds_10_tfpacientenombrecompleto ,
                                           java.util.Date AV93Pacientewwds_12_tfpacientefechanacimiento ,
                                           java.util.Date AV94Pacientewwds_13_tfpacientefechanacimiento_to ,
                                           int AV95Pacientewwds_14_tfpacientetipodocumento_sels_size ,
                                           String AV97Pacientewwds_16_tfpacientenrodocumento_sel ,
                                           String AV96Pacientewwds_15_tfpacientenrodocumento ,
                                           String AV99Pacientewwds_18_tfpacientedireccion_sel ,
                                           String AV98Pacientewwds_17_tfpacientedireccion ,
                                           int AV100Pacientewwds_19_tfpacientesexo_sels_size ,
                                           String AV102Pacientewwds_21_tfpacientecorreo_sel ,
                                           String AV101Pacientewwds_20_tfpacientecorreo ,
                                           String AV104Pacientewwds_23_tfpacientetelefono_sel ,
                                           String AV103Pacientewwds_22_tfpacientetelefono ,
                                           short AV105Pacientewwds_24_tfpaisid ,
                                           short AV106Pacientewwds_25_tfpaisid_to ,
                                           String AV108Pacientewwds_27_tfpaisdescripcion_sel ,
                                           String AV107Pacientewwds_26_tfpaisdescripcion ,
                                           int AV109Pacientewwds_28_tfpacienteestado_sels_size ,
                                           short AV110Pacientewwds_29_tfsecuserid ,
                                           short AV111Pacientewwds_30_tfsecuserid_to ,
                                           String AV113Pacientewwds_32_tfubigeocode_sel ,
                                           String AV112Pacientewwds_31_tfubigeocode ,
                                           String AV115Pacientewwds_34_tfubigeonombre_sel ,
                                           String AV114Pacientewwds_33_tfubigeonombre ,
                                           java.math.BigDecimal AV116Pacientewwds_35_tfpacienteestatura ,
                                           java.math.BigDecimal AV117Pacientewwds_36_tfpacienteestatura_to ,
                                           java.math.BigDecimal AV118Pacientewwds_37_tfpacientepeso ,
                                           java.math.BigDecimal AV119Pacientewwds_38_tfpacientepeso_to ,
                                           String AV121Pacientewwds_40_tfpacientenombreanexo_sel ,
                                           String AV120Pacientewwds_39_tfpacientenombreanexo ,
                                           int AV122Pacientewwds_41_tfpacienteenterarse_sels_size ,
                                           String AV124Pacientewwds_43_tfpacienteespecifique_sel ,
                                           String AV123Pacientewwds_42_tfpacienteespecifique ,
                                           java.util.Date AV125Pacientewwds_44_tfpacientefecharegistro ,
                                           java.util.Date AV126Pacientewwds_45_tfpacientefecharegistro_to ,
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
                                           java.util.Date A226PacienteFechaRegistro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int40 = new byte[76];
      Object[] GXv_Object41 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteEspecifique], T1.[PacienteFechaRegistro], T1.[PacientePeso], T1.[PacienteEstatura], T1.[SecUserId], T1.[PaisId], T1.[PacienteFechaNacimiento]," ;
      scmdbuf += " T1.[PacienteId], T1.[PacienteEnterarse], T1.[PacienteNombreAnexo], T1.[UbigeoCode], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo]," ;
      scmdbuf += " T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno]," ;
      scmdbuf += " T3.[UbigeoDistrito], T3.[UbigeoProvincia], T3.[UbigeoDepartamento] FROM (([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [Ubigeo] T3" ;
      scmdbuf += " ON T3.[UbigeoCode] = T1.[UbigeoCode])" ;
      if ( ! (GXutil.strcmp("", AV82Pacientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T1.[PacienteApellidoPaterno] like '%' + ?) or ( T1.[PacienteApellidoMaterno] like '%' + ?) or ( T1.[PacienteNombres] like '%' + ?) or ( T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and T1.[PacienteTipoDocumento] = '0') or ( T1.[PacienteNroDocumento] like '%' + ?) or ( T1.[PacienteDireccion] like '%' + ?) or ( 'masculino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'M') or ( 'femenino' like '%' + LOWER(?) and T1.[PacienteSexo] = 'F') or ( T1.[PacienteCorreo] like '%' + ?) or ( T1.[PacienteTelefono] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PaisId] AS decimal(4,0))) like '%' + ?) or ( T2.[PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'A') or ( 'pendiente' like '%' + LOWER(?) and T1.[PacienteEstado] = 'P') or ( 'inactivo' like '%' + LOWER(?) and T1.[PacienteEstado] = 'I') or ( CONVERT( char(4), CAST(T1.[SecUserId] AS decimal(4,0))) like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PacienteEstatura] AS decimal(4,2))) like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PacientePeso] AS decimal(6,2))) like '%' + ?) or ( T1.[PacienteNombreAnexo] like '%' + ?) or ( 'facebook' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'F') or ( 'búsqueda en google' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'G') or ( 'twitter' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'T') or ( 'instagram' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'I') or ( 'linked in' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'L') or ( 'mediante conocido o familiar' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'C') or ( 'otros' like '%' + LOWER(?) and T1.[PacienteEnterarse] = 'O') or ( T1.[PacienteEspecifique] like '%' + ?))");
      }
      else
      {
         GXv_int40[0] = (byte)(1) ;
         GXv_int40[1] = (byte)(1) ;
         GXv_int40[2] = (byte)(1) ;
         GXv_int40[3] = (byte)(1) ;
         GXv_int40[4] = (byte)(1) ;
         GXv_int40[5] = (byte)(1) ;
         GXv_int40[6] = (byte)(1) ;
         GXv_int40[7] = (byte)(1) ;
         GXv_int40[8] = (byte)(1) ;
         GXv_int40[9] = (byte)(1) ;
         GXv_int40[10] = (byte)(1) ;
         GXv_int40[11] = (byte)(1) ;
         GXv_int40[12] = (byte)(1) ;
         GXv_int40[13] = (byte)(1) ;
         GXv_int40[14] = (byte)(1) ;
         GXv_int40[15] = (byte)(1) ;
         GXv_int40[16] = (byte)(1) ;
         GXv_int40[17] = (byte)(1) ;
         GXv_int40[18] = (byte)(1) ;
         GXv_int40[19] = (byte)(1) ;
         GXv_int40[20] = (byte)(1) ;
         GXv_int40[21] = (byte)(1) ;
         GXv_int40[22] = (byte)(1) ;
         GXv_int40[23] = (byte)(1) ;
         GXv_int40[24] = (byte)(1) ;
         GXv_int40[25] = (byte)(1) ;
         GXv_int40[26] = (byte)(1) ;
         GXv_int40[27] = (byte)(1) ;
         GXv_int40[28] = (byte)(1) ;
         GXv_int40[29] = (byte)(1) ;
         GXv_int40[30] = (byte)(1) ;
         GXv_int40[31] = (byte)(1) ;
         GXv_int40[32] = (byte)(1) ;
         GXv_int40[33] = (byte)(1) ;
         GXv_int40[34] = (byte)(1) ;
         GXv_int40[35] = (byte)(1) ;
      }
      if ( ! (0==AV83Pacientewwds_2_tfpacienteid) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int40[36] = (byte)(1) ;
      }
      if ( ! (0==AV84Pacientewwds_3_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int40[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV85Pacientewwds_4_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int40[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Pacientewwds_5_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int40[39] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV87Pacientewwds_6_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int40[40] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Pacientewwds_7_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int40[41] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV89Pacientewwds_8_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int40[42] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV90Pacientewwds_9_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int40[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV91Pacientewwds_10_tfpacientenombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int40[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Pacientewwds_11_tfpacientenombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteApellidoPaterno] + ' ' + T1.[PacienteApellidoMaterno] + ', ' + T1.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int40[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV93Pacientewwds_12_tfpacientefechanacimiento)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] >= ?)");
      }
      else
      {
         GXv_int40[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV94Pacientewwds_13_tfpacientefechanacimiento_to)) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaNacimiento] <= ?)");
      }
      else
      {
         GXv_int40[47] = (byte)(1) ;
      }
      if ( AV95Pacientewwds_14_tfpacientetipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV95Pacientewwds_14_tfpacientetipodocumento_sels, "T1.[PacienteTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV96Pacientewwds_15_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int40[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Pacientewwds_16_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int40[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV98Pacientewwds_17_tfpacientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] like ?)");
      }
      else
      {
         GXv_int40[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Pacientewwds_18_tfpacientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteDireccion] = ?)");
      }
      else
      {
         GXv_int40[51] = (byte)(1) ;
      }
      if ( AV100Pacientewwds_19_tfpacientesexo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV100Pacientewwds_19_tfpacientesexo_sels, "T1.[PacienteSexo] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV101Pacientewwds_20_tfpacientecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] like ?)");
      }
      else
      {
         GXv_int40[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pacientewwds_21_tfpacientecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteCorreo] = ?)");
      }
      else
      {
         GXv_int40[53] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) && ( ! (GXutil.strcmp("", AV103Pacientewwds_22_tfpacientetelefono)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] like ?)");
      }
      else
      {
         GXv_int40[54] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV104Pacientewwds_23_tfpacientetelefono_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteTelefono] = ?)");
      }
      else
      {
         GXv_int40[55] = (byte)(1) ;
      }
      if ( ! (0==AV105Pacientewwds_24_tfpaisid) )
      {
         addWhere(sWhereString, "(T1.[PaisId] >= ?)");
      }
      else
      {
         GXv_int40[56] = (byte)(1) ;
      }
      if ( ! (0==AV106Pacientewwds_25_tfpaisid_to) )
      {
         addWhere(sWhereString, "(T1.[PaisId] <= ?)");
      }
      else
      {
         GXv_int40[57] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV107Pacientewwds_26_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int40[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV108Pacientewwds_27_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int40[59] = (byte)(1) ;
      }
      if ( AV109Pacientewwds_28_tfpacienteestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV109Pacientewwds_28_tfpacienteestado_sels, "T1.[PacienteEstado] IN (", ")")+")");
      }
      if ( ! (0==AV110Pacientewwds_29_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int40[60] = (byte)(1) ;
      }
      if ( ! (0==AV111Pacientewwds_30_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int40[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV112Pacientewwds_31_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int40[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV113Pacientewwds_32_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int40[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV114Pacientewwds_33_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int40[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV115Pacientewwds_34_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int40[65] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Pacientewwds_35_tfpacienteestatura)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] >= ?)");
      }
      else
      {
         GXv_int40[66] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Pacientewwds_36_tfpacienteestatura_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEstatura] <= ?)");
      }
      else
      {
         GXv_int40[67] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118Pacientewwds_37_tfpacientepeso)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] >= ?)");
      }
      else
      {
         GXv_int40[68] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119Pacientewwds_38_tfpacientepeso_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PacientePeso] <= ?)");
      }
      else
      {
         GXv_int40[69] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) && ( ! (GXutil.strcmp("", AV120Pacientewwds_39_tfpacientenombreanexo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] like ?)");
      }
      else
      {
         GXv_int40[70] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pacientewwds_40_tfpacientenombreanexo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteNombreAnexo] = ?)");
      }
      else
      {
         GXv_int40[71] = (byte)(1) ;
      }
      if ( AV122Pacientewwds_41_tfpacienteenterarse_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV122Pacientewwds_41_tfpacienteenterarse_sels, "T1.[PacienteEnterarse] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) && ( ! (GXutil.strcmp("", AV123Pacientewwds_42_tfpacienteespecifique)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] like ?)");
      }
      else
      {
         GXv_int40[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV124Pacientewwds_43_tfpacienteespecifique_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PacienteEspecifique] = ?)");
      }
      else
      {
         GXv_int40[73] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV125Pacientewwds_44_tfpacientefecharegistro) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] >= ?)");
      }
      else
      {
         GXv_int40[74] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV126Pacientewwds_45_tfpacientefecharegistro_to) )
      {
         addWhere(sWhereString, "(T1.[PacienteFechaRegistro] <= ?)");
      }
      else
      {
         GXv_int40[75] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteEspecifique]" ;
      GXv_Object41[0] = scmdbuf ;
      GXv_Object41[1] = GXv_int40 ;
      return GXv_Object41 ;
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
                  return conditional_P002P2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 1 :
                  return conditional_P002P3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 2 :
                  return conditional_P002P4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 3 :
                  return conditional_P002P5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 4 :
                  return conditional_P002P6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 5 :
                  return conditional_P002P7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 6 :
                  return conditional_P002P8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 7 :
                  return conditional_P002P9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 8 :
                  return conditional_P002P10(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 9 :
                  return conditional_P002P11(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 10 :
                  return conditional_P002P12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 11 :
                  return conditional_P002P13(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
            case 12 :
                  return conditional_P002P14(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] , (String)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , (String)dynConstraints[49] , (String)dynConstraints[50] , (java.util.Date)dynConstraints[51] , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , (String)dynConstraints[57] , (String)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).shortValue() , (String)dynConstraints[62] , ((Number) dynConstraints[63]).shortValue() , (String)dynConstraints[64] , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , (String)dynConstraints[70] , (String)dynConstraints[71] , (java.util.Date)dynConstraints[72] , (java.util.Date)dynConstraints[73] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P10", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P13", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002P14", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
            case 1 :
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
            case 2 :
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
            case 3 :
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
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((String[]) buf[19])[0] = rslt.getString(15, 20);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 1);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((String[]) buf[25])[0] = rslt.getVarchar(21);
               ((String[]) buf[26])[0] = rslt.getVarchar(22);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((String[]) buf[28])[0] = rslt.getVarchar(24);
               ((String[]) buf[29])[0] = rslt.getVarchar(25);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((String[]) buf[19])[0] = rslt.getString(15, 20);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 1);
               ((String[]) buf[22])[0] = rslt.getVarchar(18);
               ((String[]) buf[23])[0] = rslt.getString(19, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((String[]) buf[25])[0] = rslt.getVarchar(21);
               ((String[]) buf[26])[0] = rslt.getVarchar(22);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((String[]) buf[28])[0] = rslt.getVarchar(24);
               ((String[]) buf[29])[0] = rslt.getVarchar(25);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((String[]) buf[19])[0] = rslt.getString(15, 20);
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
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
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
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
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
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
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
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(9);
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
            case 12 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
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
            case 1 :
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
            case 2 :
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
            case 3 :
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
            case 4 :
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
            case 5 :
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
            case 6 :
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
            case 7 :
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
            case 8 :
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
            case 9 :
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
            case 10 :
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
            case 11 :
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
            case 12 :
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

