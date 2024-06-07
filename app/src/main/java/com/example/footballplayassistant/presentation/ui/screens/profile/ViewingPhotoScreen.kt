package com.example.footballplayassistant.presentation.ui.screens.profile

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.enums.CameraGallery
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.skydoves.cloudy.Cloudy
import java.io.File


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ViewingPhotoScreen(type: Int) {
    val enable = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        if (type == CameraGallery.Camera.ordinal) {
            HeaderRow(text = stringResource(id = R.string.takePhoto), enable = true)
            TakePhoto()
        } else {
            HeaderRow(text = stringResource(id = R.string.library), enable = enable.value)
            Library(enable = enable)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun Library(enable: MutableState<Boolean>) {
    var selectImage by remember { mutableStateOf<Uri?>(null) }

    //без этого фоновая размытая картинка не меняется
    val glideState = remember { mutableStateOf(false) }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            selectImage = it
            glideState.value = true
            enable.value = true
        }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
        ) {
            if (selectImage != null)
                Box(modifier = Modifier.align(Alignment.Center)) {
                    if (Build.VERSION.RELEASE.toDouble() < 12.0)
                        Cloudy(radius = 20, key1 = glideState.value) {
                            glideState.value = false
                            CommonImage(
                                selectImage = selectImage!!, contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.TopCenter)
                            )

                        }
                    else
                        CommonImage(
                            selectImage = selectImage!!, contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopCenter)
                                .blur(30.dp)
                        )
                    CommonImage(
                        selectImage = selectImage!!, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .aspectRatio(1f)
                            .fillMaxHeight()
                    )
                }
            else
                AvatarBox(glideState = glideState)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            ClickableText(
                text = AnnotatedString(text = stringResource(id = R.string.recent)),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.primary),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            ) { galleryLauncher.launch("image/*") }
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_menu_18_10),
                contentDescription = "Arrow"
            )
        }
        //сетка
    }
}

@Composable
private fun TakePhoto() {
    val openCamera = remember { mutableStateOf(true) }
    val bitmapFromCamera = remember { mutableStateOf<Bitmap?>(null) }
    val glideState = remember { mutableStateOf(false) }
    val launcherCamera =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmapFromCamera.value = bitmap
            glideState.value = true
        }

    LaunchedEffect(openCamera.value) {
        if (openCamera.value) {
            launcherCamera.launch()
            openCamera.value = false
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
        ) {
            if (bitmapFromCamera.value != null)
                Box(modifier = Modifier.align(Alignment.Center)) {
                    if (Build.VERSION.RELEASE.toDouble() < 12.0)
                        Cloudy(radius = 20, key1 = glideState.value) {
                            glideState.value = false
                            BitmapImage(
                                bitmapFromCamera = bitmapFromCamera,
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.TopCenter)
                            )
                        }
                    else
                        BitmapImage(
                            bitmapFromCamera = bitmapFromCamera,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopCenter)
                                .blur(30.dp)
                        )

                    BitmapImage(
                        bitmapFromCamera = bitmapFromCamera, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .aspectRatio(1f)
                            .fillMaxHeight()
                    )
                }
            else
                AvatarBox(glideState = glideState)
        }

        CommonButton(
            text = stringResource(id = R.string.takeOneMorePhoto),
            onClick = { openCamera.value = true },
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }

}

@Composable
private fun HeaderRow(text: String, enable: Boolean) {
    val navController = LocalNavController.current!!

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.cancel)),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        ) {
            navController.navigate(Route.ChangeProfileScreen.path)
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(horizontal = 8.dp)
        )
        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.done)),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.W600,
                color = if (enable) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.tertiary
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        ) {
            if (enable)
                navController.navigate(Route.ChangeProfileScreen.path)
        }
    }
}

@Composable
private fun CommonImage(
    modifier: Modifier = Modifier,
    selectImage: Uri,
    contentScale: ContentScale
) {
    Image(
        painter = rememberAsyncImagePainter(model = selectImage),
        contentDescription = "User photo",
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
private fun BitmapImage(
    modifier: Modifier = Modifier,
    bitmapFromCamera: MutableState<Bitmap?>,
    contentScale: ContentScale
) {
    bitmapFromCamera.value?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = "User photo",
            contentScale = contentScale,
            modifier = modifier
        )
    }
}

@Composable
private fun AvatarBox(glideState: MutableState<Boolean>) {
    Box {
        if (Build.VERSION.RELEASE.toDouble() < 12.0)
            Cloudy(radius = 20, key1 = glideState.value) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "User photo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                )
                glideState.value = false
            }
        else
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "User photo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .blur(30.dp)
            )
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "User photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(1f)
                .fillMaxHeight()
        )
    }
}

//////////////////////////////////////////////////////////////////////////////


@Composable
private fun getImagePath(ctx: Context): MutableList<String> {
//    val requestPermissionLauncher = rememberLauncherForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) { isGranted ->
//        if (isGranted) {
//            Log.d("MyLog", "Permission granted")
//        } else {
//            Log.d("MyLog", "Permission denied")
//        }
//    }
//    LaunchedEffect(true) {
//        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
//    }
    var imgList: MutableList<String> = ArrayList()
    val isSDPresent = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

    if (isSDPresent) {
        val columns = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA)
        val orderBy = MediaStore.Images.Media._ID

//        val cursor: Cursor? = ctx.contentResolver.query(
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            columns,
//            null,
//            null,
//            orderBy
//        )
////////////////////////////////////////////////////////
        //откуда берутся фото
        //  /picker/0/com.android.providers.media.photopicker/media/1000005357

        // /storage/emulated/0/Pictures/         contentUri.toUri()
//        val contentUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI
//        Log.d("MyLog", "contentUri ${contentUri.path}")
//        ctx.contentResolver.query(contentUri, columns, null, null, null)?.use { cursor ->
//            if (cursor.moveToFirst()) {
//                val imageIdIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID)
//                val imageUriIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DATA)
//                do {
//                    val id = cursor.getString(imageIdIndex)
//                    val imageUri = Uri.parse(cursor.getString(imageUriIndex))
//                    Log.d("MyLog", "id ${id}")
//                    Log.d("MyLog", "imageUri ${imageUri.path}")
//                } while (cursor.moveToNext())
//                 cursor.close()
//            }
//        }
/////////////////////////////////////////
//        val count: Int = cursor!!.count
//
//        for (i in 0 until count) {
//            if (imgList.size > 8) {
//                break
//            }
//
//            cursor.moveToPosition(i * 3)
//
//            val dataColumnIndex: Int = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
//
//            Log.d("MyLog", "dataColumnIndex ${cursor.getString(dataColumnIndex)}")
//
//            imgList.add(cursor.getString(dataColumnIndex))
//        }
//        cursor.close()
    }
    Log.d("MyLog", "count ${imgList.size}")
    return imgList
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun getFotos() {
    var gpath: String =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()
    var spath = "Camera"//
    var fullpath = File(gpath + File.separator + spath)
    Log.d("MyLog", "" + fullpath)
    imageReaderNew(fullpath)
}

fun imageReaderNew(root: File) {
    val fileList: ArrayList<File> = ArrayList()
    val listAllFiles = root.listFiles()

    if (listAllFiles != null && listAllFiles.isNotEmpty()) {
        for (currentFile in listAllFiles) {
//            if (currentFile.name.endsWith(".jpg")) {
            // File absolute path
            Log.d("MyLog", "currentFile.getAbsolutePath() " + currentFile.getAbsolutePath())
            // File Name
            Log.d("MyLog", "currentFile.getName() " + currentFile.getName())
            fileList.add(currentFile.absoluteFile)
//            }
        }
        Log.d("MyLog", "listAllFiles " + listAllFiles.size)
        Log.d("MyLog", "fileList " + fileList.size)
    }
}

@Composable
fun gridView(context: Context) {
    var imgList: MutableList<String> = ArrayList()
    imgList = getImagePath(context)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(10.dp)

    ) {
        items(imgList.size) {
            Column(
                Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val imgFile = File(imgList[it])
                Image(
                    painter = rememberAsyncImagePainter(model = imgFile),
                    contentDescription = "Javascript",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}