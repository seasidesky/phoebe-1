/*
 * Copyright (c) 2015, 8Kdata Technology S.L.
 *
 * Permission to use, copy, modify, and distribute this software and its documentation for any purpose,
 * without fee, and without a written agreement is hereby granted, provided that the above copyright notice and this
 * paragraph and the following two paragraphs appear in all copies.
 *
 * IN NO EVENT SHALL 8Kdata BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES,
 * INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF 8Kdata HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 8Kdata SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE PROVIDED HEREUNDER IS ON AN "AS IS" BASIS,
 * AND 8Kdata HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 *
 */

package com.eightkdata.pgfebe.fe.decoder;

import com.eightkdata.pgfebe.common.FeBeMessage;
import com.eightkdata.pgfebe.common.decoder.MessageDecoder;
import com.eightkdata.pgfebe.common.exception.FeBeException;
import com.eightkdata.pgfebe.common.message.AuthenticationMD5Password;
import io.netty.buffer.ByteBuf;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.nio.charset.Charset;

/**
 * Decoder for {@link AuthenticationMD5Password} messages.
 */
@Immutable
public class AuthenticationMD5PasswordDecoder implements MessageDecoder<FeBeMessage> {

    private static final int SALT_LENGTH = 4;

    @Override
    public AuthenticationMD5Password decode(@Nonnull ByteBuf in, @Nonnull Charset encoding) throws FeBeException {
        byte[] salt = new byte[SALT_LENGTH];
        in.readBytes(salt);

        return new AuthenticationMD5Password.Builder().setSalt(salt).build();
    }

}