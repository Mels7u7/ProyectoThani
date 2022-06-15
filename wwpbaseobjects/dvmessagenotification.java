package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvmessagenotification extends GXProcedure
{
   public dvmessagenotification( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvmessagenotification.class ), "" );
   }

   public dvmessagenotification( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             String aP9 ,
                             long aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             short aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 ,
                             String aP21 ,
                             String aP22 ,
                             String aP23 ,
                             String aP24 ,
                             String aP25 ,
                             java.math.BigDecimal aP26 ,
                             String aP27 ,
                             String aP28 ,
                             String aP29 ,
                             String aP30 )
   {
      dvmessagenotification.this.aP31 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31);
      return aP31[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        String aP9 ,
                        long aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        short aP17 ,
                        String aP18 ,
                        String aP19 ,
                        String aP20 ,
                        String aP21 ,
                        String aP22 ,
                        String aP23 ,
                        String aP24 ,
                        String aP25 ,
                        java.math.BigDecimal aP26 ,
                        String aP27 ,
                        String aP28 ,
                        String aP29 ,
                        String aP30 ,
                        String[] aP31 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             String aP9 ,
                             long aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             short aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 ,
                             String aP21 ,
                             String aP22 ,
                             String aP23 ,
                             String aP24 ,
                             String aP25 ,
                             java.math.BigDecimal aP26 ,
                             String aP27 ,
                             String aP28 ,
                             String aP29 ,
                             String aP30 ,
                             String[] aP31 )
   {
      dvmessagenotification.this.AV36Title = aP0;
      dvmessagenotification.this.AV34Text = aP1;
      dvmessagenotification.this.AV38Type = aP2;
      dvmessagenotification.this.AV18ControlSelector = aP3;
      dvmessagenotification.this.AV39Width = aP4;
      dvmessagenotification.this.AV27MinHeight = aP5;
      dvmessagenotification.this.AV33StylingType = aP6;
      dvmessagenotification.this.AV32ShadowVisible = aP7;
      dvmessagenotification.this.AV30Opacity = aP8;
      dvmessagenotification.this.AV23Hide = aP9;
      dvmessagenotification.this.AV24HideDelayMilliseconds = aP10;
      dvmessagenotification.this.AV25HideMouseReset = aP11;
      dvmessagenotification.this.AV37TitleEscape = aP12;
      dvmessagenotification.this.AV35TextEscape = aP13;
      dvmessagenotification.this.AV26MessageCornerClass = aP14;
      dvmessagenotification.this.AV9AnimationEffectIn = aP15;
      dvmessagenotification.this.AV10AnimationEffectOut = aP16;
      dvmessagenotification.this.AV8AnimateSpeed = aP17;
      dvmessagenotification.this.AV12ButtonCloserEnable = aP18;
      dvmessagenotification.this.AV13ButtonCloserHoverEnable = aP19;
      dvmessagenotification.this.AV15ButtonStickerEnable = aP20;
      dvmessagenotification.this.AV16ButtonStickerHoverEnable = aP21;
      dvmessagenotification.this.AV14ButtonsShowOnNonBlock = aP22;
      dvmessagenotification.this.AV11ButtonCloseLabel = aP23;
      dvmessagenotification.this.AV17ButtonStickerLabel = aP24;
      dvmessagenotification.this.AV28NonBlockEnable = aP25;
      dvmessagenotification.this.AV29NonBlockOpacity = aP26;
      dvmessagenotification.this.AV19DesktopNotificationEnable = aP27;
      dvmessagenotification.this.AV20DesktopNotificationFallBackEnable = aP28;
      dvmessagenotification.this.AV21DesktopNotificationIconUrl = aP29;
      dvmessagenotification.this.AV22DesktopNotificationTag = aP30;
      dvmessagenotification.this.aP31 = aP31;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV31Parms = "{" ;
      if ( ! (GXutil.strcmp("", AV36Title)==0) )
      {
         AV31Parms += "\"title\":\"" + GXutil.trim( GXutil.strReplace( AV36Title, "\"", "")) + "\"," ;
      }
      if ( ! (GXutil.strcmp("", AV34Text)==0) )
      {
         AV31Parms += "\"text\":\"" + GXutil.trim( GXutil.strReplace( AV34Text, "\"", "")) + "\"," ;
      }
      if ( GXutil.strcmp(AV38Type, "nospecify") != 0 )
      {
         AV31Parms += "\"type\":\"" + AV38Type + "\"," ;
      }
      if ( ! (GXutil.strcmp("", AV18ControlSelector)==0) )
      {
         AV31Parms += "\"att\":\"" + GXutil.trim( GXutil.strReplace( AV18ControlSelector, "\"", "")) + "\"," ;
      }
      if ( ! (0==AV39Width) )
      {
         AV31Parms += "\"width\":\"" + GXutil.trim( GXutil.str( AV39Width, 4, 0)) + "\"," ;
      }
      if ( ! (0==AV27MinHeight) )
      {
         AV31Parms += "\"min_height\":\"" + GXutil.trim( GXutil.str( AV27MinHeight, 4, 0)) + "\"," ;
      }
      if ( GXutil.strcmp(AV33StylingType, "N") != 0 )
      {
         AV31Parms += "\"styling\":\"" + GXutil.trim( AV33StylingType) + "\"," ;
      }
      if ( GXutil.strcmp(AV32ShadowVisible, "na") != 0 )
      {
         AV31Parms += "\"shadow\":" + GXutil.trim( AV32ShadowVisible) + "," ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30Opacity)==0) )
      {
         AV31Parms += "\"opacity\":\"" + GXutil.trim( GXutil.substring( GXutil.str( AV30Opacity, 3, 1), 2, 2)) + "\"," ;
      }
      if ( GXutil.strcmp(AV23Hide, "na") != 0 )
      {
         AV31Parms += "\"hide\":" + GXutil.trim( AV23Hide) + "," ;
      }
      if ( ! (0==AV24HideDelayMilliseconds) )
      {
         AV31Parms += "\"delay\":\"" + GXutil.trim( GXutil.str( AV24HideDelayMilliseconds, 10, 0)) + "\"," ;
      }
      if ( GXutil.strcmp(AV25HideMouseReset, "na") != 0 )
      {
         AV31Parms += "\"mouse_reset\":" + GXutil.trim( AV25HideMouseReset) + "," ;
      }
      if ( GXutil.strcmp(AV37TitleEscape, "na") != 0 )
      {
         AV31Parms += "\"title_escape\":" + GXutil.trim( AV37TitleEscape) + "," ;
      }
      if ( GXutil.strcmp(AV35TextEscape, "na") != 0 )
      {
         AV31Parms += "\"text_escape\":" + GXutil.trim( AV35TextEscape) + "," ;
      }
      if ( ! (GXutil.strcmp("", AV26MessageCornerClass)==0) )
      {
         AV31Parms += "\"cornerclass\":\"" + GXutil.trim( AV26MessageCornerClass) + "\"," ;
      }
      if ( ( GXutil.strcmp(AV9AnimationEffectIn, "N") != 0 ) || ( GXutil.strcmp(AV10AnimationEffectOut, "N") != 0 ) )
      {
         AV31Parms += "\"animation\": {" ;
         if ( GXutil.strcmp(AV9AnimationEffectIn, "N") != 0 )
         {
            AV31Parms += "\"effect_in\":\"" + GXutil.trim( AV9AnimationEffectIn) + "\"," ;
         }
         if ( GXutil.strcmp(AV10AnimationEffectOut, "N") != 0 )
         {
            AV31Parms += "\"effect_out\":\"" + GXutil.trim( AV10AnimationEffectOut) + "\"," ;
         }
         AV31Parms += "}," ;
      }
      if ( ! (0==AV8AnimateSpeed) )
      {
         AV31Parms += "\"animate_speed\":\"" + GXutil.trim( GXutil.str( AV8AnimateSpeed, 4, 0)) + "\"," ;
      }
      if ( ( GXutil.strcmp(AV12ButtonCloserEnable, "na") != 0 ) || ( GXutil.strcmp(AV13ButtonCloserHoverEnable, "na") != 0 ) || ( GXutil.strcmp(AV15ButtonStickerEnable, "na") != 0 ) || ( GXutil.strcmp(AV16ButtonStickerHoverEnable, "na") != 0 ) || ( GXutil.strcmp(AV14ButtonsShowOnNonBlock, "na") != 0 ) )
      {
         AV31Parms += "\"buttons\": {" ;
         if ( GXutil.strcmp(AV12ButtonCloserEnable, "na") != 0 )
         {
            AV31Parms += "\"closer\":" + GXutil.trim( AV12ButtonCloserEnable) + "," ;
         }
         if ( GXutil.strcmp(AV13ButtonCloserHoverEnable, "na") != 0 )
         {
            AV31Parms += "\"closer_hover\":" + GXutil.trim( AV13ButtonCloserHoverEnable) + "," ;
         }
         if ( GXutil.strcmp(AV15ButtonStickerEnable, "na") != 0 )
         {
            AV31Parms += "\"sticker\":" + GXutil.trim( AV15ButtonStickerEnable) + "," ;
         }
         if ( GXutil.strcmp(AV16ButtonStickerHoverEnable, "na") != 0 )
         {
            AV31Parms += "\"sticker_hover\":" + GXutil.trim( AV16ButtonStickerHoverEnable) + "," ;
         }
         if ( GXutil.strcmp(AV14ButtonsShowOnNonBlock, "na") != 0 )
         {
            AV31Parms += "\"show_on_nonblock\":" + GXutil.trim( AV14ButtonsShowOnNonBlock) + "," ;
         }
         if ( ! (GXutil.strcmp("", AV11ButtonCloseLabel)==0) || ! (GXutil.strcmp("", AV17ButtonStickerLabel)==0) )
         {
            AV31Parms += "\"labels\": {" ;
            if ( ! (GXutil.strcmp("", AV11ButtonCloseLabel)==0) )
            {
               AV31Parms += "\"close\":\"" + GXutil.trim( AV11ButtonCloseLabel) + "\"," ;
            }
            if ( ! (GXutil.strcmp("", AV17ButtonStickerLabel)==0) )
            {
               AV31Parms += "\"stick\":\"" + GXutil.trim( AV17ButtonStickerLabel) + "\"," ;
            }
            AV31Parms += "}" ;
         }
         AV31Parms += "}," ;
      }
      if ( ( GXutil.strcmp(AV28NonBlockEnable, "na") != 0 ) || ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29NonBlockOpacity)==0) )
      {
         AV31Parms += "\"nonblock\": {" ;
         if ( GXutil.strcmp(AV28NonBlockEnable, "na") != 0 )
         {
            AV31Parms += "\"nonblock\":" + GXutil.trim( AV28NonBlockEnable) + "," ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29NonBlockOpacity)==0) )
         {
            AV31Parms += "\"nonblock_opacity\":\"" + GXutil.trim( GXutil.substring( GXutil.str( AV29NonBlockOpacity, 2, 1), 2, 2)) + "\"," ;
         }
         AV31Parms += "}," ;
      }
      if ( ( GXutil.strcmp(AV19DesktopNotificationEnable, "na") != 0 ) || ( GXutil.strcmp(AV20DesktopNotificationFallBackEnable, "na") != 0 ) || ! (GXutil.strcmp("", AV21DesktopNotificationIconUrl)==0) || ! (GXutil.strcmp("", AV22DesktopNotificationTag)==0) )
      {
         AV31Parms += "\"desktop\": {" ;
         if ( GXutil.strcmp(AV19DesktopNotificationEnable, "na") != 0 )
         {
            AV31Parms += "\"desktop\":" + GXutil.trim( AV19DesktopNotificationEnable) + "," ;
         }
         if ( GXutil.strcmp(AV20DesktopNotificationFallBackEnable, "na") != 0 )
         {
            AV31Parms += "\"fallback\":" + GXutil.trim( AV20DesktopNotificationFallBackEnable) + "," ;
         }
         if ( ! (GXutil.strcmp("", AV21DesktopNotificationIconUrl)==0) )
         {
            AV31Parms += "\"icon\":\"" + GXutil.trim( AV21DesktopNotificationIconUrl) + "\"," ;
         }
         if ( ! (GXutil.strcmp("", AV22DesktopNotificationTag)==0) )
         {
            AV31Parms += "\"tag\":\"" + GXutil.trim( AV22DesktopNotificationTag) + "\"," ;
         }
         AV31Parms += "}" ;
      }
      AV31Parms += "}" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP31[0] = dvmessagenotification.this.AV31Parms;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31Parms = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV39Width ;
   private short AV27MinHeight ;
   private short AV8AnimateSpeed ;
   private short Gx_err ;
   private long AV24HideDelayMilliseconds ;
   private java.math.BigDecimal AV30Opacity ;
   private java.math.BigDecimal AV29NonBlockOpacity ;
   private String AV36Title ;
   private String AV34Text ;
   private String AV38Type ;
   private String AV18ControlSelector ;
   private String AV33StylingType ;
   private String AV32ShadowVisible ;
   private String AV23Hide ;
   private String AV25HideMouseReset ;
   private String AV37TitleEscape ;
   private String AV35TextEscape ;
   private String AV26MessageCornerClass ;
   private String AV9AnimationEffectIn ;
   private String AV10AnimationEffectOut ;
   private String AV12ButtonCloserEnable ;
   private String AV13ButtonCloserHoverEnable ;
   private String AV15ButtonStickerEnable ;
   private String AV16ButtonStickerHoverEnable ;
   private String AV14ButtonsShowOnNonBlock ;
   private String AV11ButtonCloseLabel ;
   private String AV17ButtonStickerLabel ;
   private String AV28NonBlockEnable ;
   private String AV19DesktopNotificationEnable ;
   private String AV20DesktopNotificationFallBackEnable ;
   private String AV22DesktopNotificationTag ;
   private String AV21DesktopNotificationIconUrl ;
   private String AV31Parms ;
   private String[] aP31 ;
}

