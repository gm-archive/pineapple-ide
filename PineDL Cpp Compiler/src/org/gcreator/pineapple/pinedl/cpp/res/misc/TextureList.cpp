#include "header.h"
#include <vector>
#include <iostream>
#include <zlib.h>

using namespace Game;
using namespace std;

struct ImageData
{
   long long size;
   long long decompressed_size;
   Texture* tex;
};

vector<ImageData*> images;
long archive_data_start;
void init_vars();


void Load_Textures(int*, int);
Texture* Load_Compressed_Texture(FILE*, int, int);
Texture* Load_Texture(char*, int);

void TextureList::init()
{
	/* Initialize Image data */
	FILE* exe = fopen(Pineapple::Application::getExecutablePath().c_str(), "rb");
	/* Read and Store Archive Information */
	fseek(exe, -archive_size, SEEK_END);
	int imgs;
	fread(&imgs, 4, 1, exe);
	for (int i = 0; i < imgs; i++)
	{
		long long sz;
		fread(&sz, 8, 1, exe);
		long long dsz;
		fread(&dsz, 8, 1, exe);
		ImageData* data = new ImageData();
		data->size = sz;
		data->decompressed_size = dsz;
		data->tex = NULL;
		images.push_back(data);
	}
	/* Record where to get straight to the juice without reading stuff
		about the archive files. */
	archive_data_start = ftell(exe);

	/* Load images that are needed at the game start. */
	for (int i = 0; i < imgs; i++)
	{
		bool load = false;
		for (int j = 0; j < START_IMAGE_COUNT; j++)
		{
			if (START_IMAGES[j] == i)
			{
				load = true;
				break;
			}
		}
		if (load)
		{
			images[i]->tex = Load_Compressed_Texture(exe, images[i]->size, images[i]->decompressed_size);
		}
		else
		{
			// Skip data for this image
			fseek(exe, images[i]->size, SEEK_CUR);
		}
	}

	fclose(exe);

}

Texture* TextureList::Get_Texture(int id)
{
	if (images[id]->tex == NULL)
	{
		Load_Textures(&id, 1);
	}
	return images[id]->tex;
}

void Load_Textures(int* ids, int n)
{
	FILE* exe = fopen(Pineapple::Application::getExecutablePath().c_str(), "rb");
	fseek(exe, archive_data_start, SEEK_SET);
	for (int i = 0; i < images.size(); i++)
	{
		bool read = false;
		for (int j = 0; j < n; j++)
		{
			if ( *(ids+j) == i)
			{
				read = true;
				break;
			}
		}

		if (read)
		{
			// Free old texture if there's one there
			if (images[i]->tex != NULL)
			{
				delete images[i]->tex;
			}
			images[i]->tex = Load_Compressed_Texture(exe, images[i]->size, images[i]->decompressed_size);
		}
		else
		{
			// Skip image data
			fseek(exe, images[i]->size, SEEK_CUR);
		}
	}
	fclose(exe);
}

Texture* Load_Compressed_Texture(FILE* exe, int sz, int decompressed_size)
{
	char* src = new char[sz+1];
	fread(src, 1, sz, exe);
	char* dest = new char[decompressed_size+1];
	uLongf dsz = decompressed_size;
	uncompress((Bytef*)dest, &dsz, (Bytef*)src, sz);
	delete[] src;
	Texture* tex = Load_Texture(dest, decompressed_size);
	return tex;
}

Texture* Load_Texture(char* data, int sz)
{
	 return new Pineapple::Texture(data, sz);
}
