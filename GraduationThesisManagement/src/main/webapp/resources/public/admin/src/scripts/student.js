
const loadStudentById = (endpoint, callback) => {
    fetch(endpoint, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then((res) => res.json())
        .then((data) => {
            callback(data);
        })
        .catch((err) => {
            console.error(err);
            errorAlert(
                "Đã có lỗi",
                "Đã có lỗi xảy ra trong quá trình tải dữ liệu!",
                "Ok"
            );
        });
};

const saveChange = (appContext, studentId = null) => {
    let form = $("#form-add-edit-student");
    let formData = {};
    var formDataSubmit = new FormData();

    form.serializeArray().forEach((item) => {
        formData[item.name] = item.value;
    });
    formData["active"] = document.getElementById("is-active").checked;
    $("input").next("span").remove();

    formDataSubmit.append("avatarFile", file);

    showLoading();
    if (studentId === null) {
        // ADD
        formDataSubmit.append(
            "student",
            new Blob(
                [
                    JSON.stringify({
                        code: formData.code,
                        fullName: formData.fullName,
                        email: formData.email,
                        phone: formData.phone,
                        birthday: formData.birthday,
                        gender: formData.gender,
                        address: formData.address,
                        gpa: formData.gpa,
                        schoolYear: formData.schoolYear,
                        major: formData.major,
                        user: {
                            username: formData.code,
                            password: formData.code,
                            active: formData.active,
                        },
                    }),
                ],
                {
                    type: "application/json",
                }
            )
        );
        fetch(`${appContext}admin/api/students`, {
            method: "POST",
            body: formDataSubmit,
        })
            .then((res) => res.json())
            .then((data) => {
                if (Object.keys(data).length === 0) {
                    // successful
                    $("#modal-add-edit-student").hide();
                    successfulAlert("Thêm sinh viên thành công", "Ok", () =>
                        location.reload()
                    );
                } else {
                    // error
                    $.each(data, function (key, value) {
                        if (key === "file") {
                            console.log("tính sau");
                        } else if (
                            key === "code" ||
                            key === "fullName" ||
                            key === "phone" ||
                            key === "email" ||
                            key === "birthday" ||
                            key === "address"
                        ) {
                            $("input[name=" + key + "]").after(
                                '<span class="text-danger">' + value + "</span>"
                            );
                        }
                    });
                }
            })
            .catch((err) => {
                errorAlert(
                    "Đã có lỗi",
                    "Đã có lỗi xảy ra trong quá trình thêm dữ liệu!",
                    "Ok"
                );
            })
            .finally(hideLoading);
    } else {
        // UPDATE
        formDataSubmit.append(
            "student",
            new Blob(
                [
                    JSON.stringify({
                        id: studentId,
                        code: formData.code,
                        fullName: formData.fullName,
                        email: formData.email,
                        phone: formData.phone,
                        birthday: formData.birthday,
                        gender: formData.gender,
                        address: formData.address,
                        gpa: formData.gpa,
                        schoolYear: formData.schoolYear,
                        major: formData.major,
                        user: {
                            username: formData.code,
                            password: " ",
                            active: formData.active,
                        },
                    }),
                ],
                {
                    type: "application/json",
                }
            )
        );

        fetch(`${appContext}admin/api/students/${studentId}`, {
            method: "POST",
            body: formDataSubmit,
        })
            .then((res) => res.json())
            .then((data) => {
                if (Object.keys(data).length === 0) {
                    // successful
                    $("#modal-add-edit-student").hide();
                    successfulAlert("Cập nhật sinh viên thành công", "Ok", () =>
                        location.reload()
                    );
                } else {
                    // error
                    $.each(data, function (key, value) {
                        if (key === "file") {
                            console.log("tính sau");
                        } else if (
                            key === "code" ||
                            key === "fullName" ||
                            key === "phone" ||
                            key === "email" ||
                            key === "birthday" ||
                            key === "address"
                        ) {
                            $("input[name=" + key + "]").after(
                                '<span class="text-danger">' + value + "</span>"
                            );
                        }
                    });
                }
            })
            .catch((err) => {
                console.error(err);
                errorAlert(
                    "Đã có lỗi",
                    "Đã có lỗi xảy ra trong quá trình cập nhật!",
                    "Ok"
                );
            })
            .finally(hideLoading);
    }
};


const showAddStudentModal = (appContext) => {
  document.getElementById("myModalAddAndEditStudent").innerText =
    "Thêm sinh viên";

  document.getElementById("btn-submit-form").onclick = () =>
    saveChange(appContext);
  $("#modal-add-edit-student").modal();
};

const showEditStudentModal = (appContext, studentId) => {
  let endpoint = `${appContext}admin/api/students/${studentId}`;

  loadStudentById(endpoint, (data) => {
    document.getElementById("myModalAddAndEditStudent").innerText =
      "Cập nhật sinh viên";

    document.getElementById("btn-submit-form").onclick = () =>
      saveChange(appContext, studentId);
    $("#modal-add-edit-student").modal();

    let form = document.forms["form-add-edit-student"];

    if (data.user.avatar && data.user.avatar !== "") {
      form["file-output"].src = data.user.avatar;
    } else {
      form[
        "file-output"
      ].src = `${window.location.origin}${appContext}public/common/images/avatars/avatar-default.jpg`;
    }
    form["file-output"].onload = function () {
      URL.revokeObjectURL(form["file-output"].src);
    };

    form["code"].value = data.code;
    form["fullName"].value = data.fullName;
    form["email"].value = data.email;
    form["phone"].value = data.phone;
    form["birthday"].value = new Date(data.birthday).toISOString().slice(0, 10);
    form["gender"].value = data.gender;
    form["address"].value = data.address;
    form["gpa"].value = data.gpa;
    if (data.major != null) {
      form["major"].value = data.major.id;
    }
    if (data.schoolYear != null) {
      form["schoolYear"].value = data.schoolYear.id;
    }
    if (data.user !== null) {
      form["is-active"].checked = data.user.active;
    }
  });
};

const deleteStudentItem = (appContext, studentId) => {
  let endpoint = `${appContext}admin/api/students/${studentId}`;

  // DELETE
  confirmAlert(
    "Bạn có chắc không?",
    "Bạn sẽ không thể khôi phục điều này!",
    "Có, xóa nó",
    "Không, hủy bỏ",
    () => {
      showLoading();

      fetch(endpoint, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then(function (res) {
          if (res.status === 204)
            successfulAlert("Xóa sinh viên thành công", "Ok", () =>
              location.reload()
            );
        })
        .catch((err) => {
          errorAlert(
            "Đã có lỗi",
            "Đã có lỗi xảy ra trong quá trình xóa dữ liệu!",
            "Ok"
          );
        })
        .finally(hideLoading);
    }
  );
};

// event before hidden modal
$("#modal-add-edit-student").on("hidden.bs.modal", function (e) {
  $("input").next("span").remove();
  document.forms["form-add-edit-student"].reset();
});

$("#modal-add-import-student").on("hidden.bs.modal", function (e) {
  $("input").next("span").remove();
  document.forms["form-upload-file"].reset();
});

// change password
const changePassword = async (appContext, userId) => {
  try {
    const { value: password, isConfirmed } = await Swal.fire({
      title: "Đổi mật khẩu",
      input: "password",
      inputAttributes: {
        autocapitalize: "off",
      },
      showCancelButton: true,
      confirmButtonText: "Đổi mật khẩu",
      confirmButtonColor: "#218838",
      reverseButtons: true,
      showLoaderOnConfirm: true,
      cancelButtonText: "Hủy",
      inputValidator: (value) => {
        if (!value) {
          return "Mật khẩu không được để trống";
        }
        if (value.length > 50) {
          return "Mật khẩu không vượt quá 50 ký tự";
        }
        return null;
      },
      allowOutsideClick: () => !Swal.isLoading(),
    });

    if (password && isConfirmed) {
      const response = await fetch(`${appContext}admin/api/users/${userId}`, {
        method: "POST",
        body: JSON.stringify({ password }),
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          // You can add other headers like CSRF token here if needed
        },
      });

      if (response.ok) {
        successfulAlert("Đổi mật khẩu thành công", "Ok", null);
      } else {
        const error = await response.text();
        console.error(error);
        errorAlert("Đã có lỗi", "Đổi mật khẩu không thành công!", "Ok");
      }
    }
  } catch (error) {
    console.error(error);
    errorAlert("Đã có lỗi", "Đổi mật khẩu không thành công!", "Ok");
  }
};



