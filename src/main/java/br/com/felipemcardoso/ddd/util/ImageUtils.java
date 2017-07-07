package br.com.felipemcardoso.ddd.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageUtils {

    /**
     * Gera uma miniatura de um imagem.
     *
     * @param btyes  array de bytes que representa a imagem
     * @param width  largura da imagem
     * @param height altura da imagem
     * @return a miniatura
     */
    public static Image getThumb(byte[] btyes, int width, int height) {
        Image img = null;

        try {
            img = ImageIO.read(new ByteArrayInputStream(btyes));
            img = img.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);

        } catch (IOException ex) {
            //TODO: Desenhar uma imagem de erro padrão para retorno
        }

        return img;
    }
}
