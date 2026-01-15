package me.hd.nullavatar.hook.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.graphics.createBitmap
import android.os.Environment
import java.io.ByteArrayOutputStream
import java.io.File

object AvatarUtil {
    private val CUSTOM_AVATAR_NAME = "NullAvatar.png"

    private fun getCustomAvatarFile(): File? {
        return try {
            val externalDir = Environment.getExternalStorageDirectory()
            if (externalDir != null && externalDir.exists()) {
                File(externalDir, CUSTOM_AVATAR_NAME)
            } else null
        } catch (e: Exception) {
            null
        }
    }

    private fun loadCustomAvatar(): Bitmap? {
        val file = getCustomAvatarFile() ?: return null
        return try {
            if (file.exists() && file.canRead()) {
                BitmapFactory.decodeFile(file.absolutePath)
            } else null
        } catch (e: Exception) {
            null
        }
    }

    fun getBitmap(): Bitmap {
        return loadCustomAvatar() ?: createBitmap(64, 64)
    }

    fun getOutputStream(): ByteArrayOutputStream {
        return ByteArrayOutputStream().apply {
            getBitmap().compress(Bitmap.CompressFormat.PNG, 100, this)
        }
    }

    fun getByteArray(): ByteArray {
        return getOutputStream().toByteArray()
    }
}
