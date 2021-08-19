endpoints:
    /upload/add

Api-Postman-Testing:

    method : POST
    accepts: form-data with param { file: imageFile}
    return: {profileImageUrl: uploaded image Url}
